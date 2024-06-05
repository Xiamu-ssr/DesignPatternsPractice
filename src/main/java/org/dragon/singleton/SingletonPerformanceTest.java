package org.dragon.singleton;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SingletonPerformanceTest {
    static long timeout = 5; // 超时时间，单位为秒

    public static void main(String[] args) {
        int testIterations = 1_000_000_000; // 测试次数
        int threadCount = 10; // 并发线程数

        List<Runnable> tests = new ArrayList<>();
        tests.add(() -> testSingletonPerformance("饿汉式", OrderManager1::getInstance, testIterations, threadCount));
        tests.add(() -> testSingletonPerformance("饱汉式", OrderManager2::getInstance, testIterations, threadCount));
        tests.add(() -> testSingletonPerformance("饱汉式-双检锁", OrderManager3::getInstance, testIterations, threadCount));
        tests.add(() -> testSingletonPerformance("静态内部类", OrderManager4::getInstance, testIterations, threadCount));
        tests.add(() -> testSingletonPerformance("枚举单例", () -> OrderManager5.INSTANCE, testIterations, threadCount));

        // 随机化测试顺序
        Collections.shuffle(tests);

        // 表头
        System.out.printf("%-20s%-20s%-25s%-25s%-20s%n", "Singleton Type", "First Creation (ms)", "Multiple Access (ms)", "Concurrent Access (ms)", "Memory Used (MB)");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (Runnable test : tests) {
            test.run();
            // 增加等待时间，确保系统资源恢复
            // 清空资源并重置系统状态
            resetSystemResources();
        }
    }

    private static void resetSystemResources() {
        // 提示垃圾回收
        System.gc();
        // 主动调用垃圾回收，确保资源释放
        Runtime.getRuntime().gc();
        // 等待一段时间以确保垃圾回收完成
        try {
            Thread.sleep(2000); // 等待200毫秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static <T> void testSingletonPerformance(String typeName, Supplier<T> singletonSupplier, int iterations, int threadCount) {
        // 测试首次创建时间
        long startTime = System.nanoTime();
        T instance = singletonSupplier.get();
        long endTime = System.nanoTime();
        long firstCreationTime = endTime - startTime;

        // 测试多次获取时间
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            singletonSupplier.get();
        }
        endTime = System.nanoTime();
        long multipleAccessTime = endTime - startTime;

        // 并发测试
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        startTime = System.nanoTime();
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < iterations; j++) {
                    singletonSupplier.get();
                }
                latch.countDown();
            });
        }
        try {
            boolean completed = latch.await(timeout, TimeUnit.SECONDS);
            if (!completed) {
                System.out.println("Concurrent access test for " + typeName + " timed out!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        long concurrentAccessTime = endTime - startTime;

        executorService.shutdown();

        // 内存消耗测试
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // 垃圾回收
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int i = 0; i < iterations; i++) {
            singletonSupplier.get();
        }
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;

        // 打印结果，转换时间为毫秒
        System.out.printf("%-35s%-25.3f%-30.3f%-30.3f%-20.3f%n", typeName, firstCreationTime / 1_000_000.0, multipleAccessTime / 1_000_000.0, concurrentAccessTime / 1_000_000.0, memoryUsed / (1024.0*1024.0));
    }
}

