package org.dragon.singleton;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
public class SingletonPerformanceTest {
    static long timeout = 20; // 超时时间，单位为秒
    static int testIterations = 10_000_000; // 测试次数
    static int threadCount = 1000; // 并发线程数
    static Map<String, HashMap<String, Long>> result = new HashMap<>();

    public static void main(String[] args) {
        /*
        * 多次调用，结果是最后一次调用存入。为什么多次调用，因为单次test不准确，总是靠前的OrderManager跑的快，可能是因为Java某些机制导致的
        * 所以多次调用，逐渐平稳。
        * */
        firstCreationTest();
        mulAccessTest();
        mulAccessTest();
        mulAccessTest();
        ConcurrentAccessTest();
        ConcurrentAccessTest();
        printRes();
        ConcurrentAccessTest();
        printRes();
        ConcurrentAccessTest();
        printRes();
    }

    /**
     * 打印结果
     */
    private static void printRes(){
        ArrayList<String> names = new ArrayList<>();
        names.add(OrderManager1.class.getSimpleName());
        names.add(OrderManager2.class.getSimpleName());
        names.add(OrderManager3.class.getSimpleName());
        names.add(OrderManager4.class.getSimpleName());
        names.add(OrderManager5.class.getSimpleName());
        // 表头
        System.out.printf("%-20s%-20s%-25s%-25s%-20s%n", "Singleton Type", "First Creation (ms)", "Multiple Access (ms)", "Concurrent Access (ms)", "Memory Used (MB)");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (String name : names) {
            // 打印结果，转换时间为毫秒
            System.out.printf("%-20s%-20.3f%-25.3f%-25.3f%-20.3f%n", name, result.get(name).get("firstCreation") / 1_000_000.0, result.get(name).get("mulAccess") / 1_000_000.0, result.get(name).get("ConcurrentAccess") / 1_000_000.0, 0 / (1024.0 * 1024.0));
        }
    }

    /**
     * 首次创建测试
     */
    private static void firstCreationTest(){
        List<Runnable> tests = new ArrayList<>();
        tests.add(()->firstCreation(OrderManager1::getInstance));
        tests.add(()->firstCreation(OrderManager2::getInstance));
        tests.add(()->firstCreation(OrderManager3::getInstance));
        tests.add(()->firstCreation(OrderManager4::getInstance));
        tests.add(()->firstCreation(() -> OrderManager5.INSTANCE));
        // 随机化测试顺序
        Collections.shuffle(tests);
        //run
        for (Runnable test : tests) {
            test.run();
            log.info("Complete one test");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 多次访问测试
     */
    private static void mulAccessTest(){
        List<Runnable> tests = new ArrayList<>();
        tests.add(()->mulAccess(OrderManager1::getInstance, testIterations));
        tests.add(()->mulAccess(OrderManager2::getInstance, testIterations));
        tests.add(()->mulAccess(OrderManager3::getInstance, testIterations));
        tests.add(()->mulAccess(OrderManager4::getInstance, testIterations));
        tests.add(()->mulAccess(() -> OrderManager5.INSTANCE, testIterations));
        // 随机化测试顺序
        Collections.shuffle(tests);
        //run
        for (Runnable test : tests) {
            test.run();
            log.info("Complete one test");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 多线程访问测试
     */
    private static void ConcurrentAccessTest(){
        List<Runnable> tests = new ArrayList<>();
        tests.add(()->ConcurrentAccess(OrderManager1::getInstance, testIterations, threadCount));
        tests.add(()->ConcurrentAccess(OrderManager2::getInstance, testIterations, threadCount));
        tests.add(()->ConcurrentAccess(OrderManager3::getInstance, testIterations, threadCount));
        tests.add(()->ConcurrentAccess(OrderManager4::getInstance, testIterations, threadCount));
        tests.add(()->ConcurrentAccess(() -> OrderManager5.INSTANCE, testIterations, threadCount));
        // 随机化测试顺序
        Collections.shuffle(tests);
        //run
        for (Runnable test : tests) {
            test.run();
            log.info("Complete one test");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 首次创建
     *
     * @param singletonSupplier 单一供应商
     * @return long ns
     */
    private static <T> long firstCreation(Supplier<T> singletonSupplier){
        // 测试首次创建时间
        long startTime = System.nanoTime();
        T instance = singletonSupplier.get();
        long endTime = System.nanoTime();
        long resTime = endTime - startTime;
        //save res
        String simpleName = instance.getClass().getSimpleName();
        HashMap<String, Long> resMap = result.computeIfAbsent(simpleName, k->new HashMap<>());
        resMap.put("firstCreation", resTime);
        return resTime;
    }

    /**
     * 多次访问
     *
     * @param singletonSupplier 单一供应商
     * @param iterations        迭代
     * @return long ns
     */
    private static <T> long mulAccess(Supplier<T> singletonSupplier, int iterations){
        //预热
        for (int i = 0; i < 100_000; i++) {
            T instance = singletonSupplier.get();
        }
        //计算
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            T instance = singletonSupplier.get();
        }
        long endTime = System.nanoTime();
        long resTime = endTime - startTime;
        //save res
        String simpleName = singletonSupplier.get().getClass().getSimpleName();
        HashMap<String, Long> resMap = result.computeIfAbsent(simpleName, k->new HashMap<>());
        resMap.put("mulAccess", resTime);
        return resTime;
    }

    /**
     * 并发访问
     *
     * @param singletonSupplier 单一供应商
     * @param iterations        迭代
     * @param threadCount       线程数
     * @return long ns
     */
    private static <T> long ConcurrentAccess(Supplier<T> singletonSupplier, int iterations, int threadCount){
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        //预热
        CountDownLatch latch1 = new CountDownLatch(100);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100_000; j++) {
                    T instance = singletonSupplier.get();
                }
                latch1.countDown();
            });
        }
        try {
            boolean completed = latch1.await(timeout, TimeUnit.SECONDS);
            if (!completed) {
                System.out.println("Concurrent access test for 预热" + singletonSupplier.get().getClass().getSimpleName() + " timed out!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //计算
        CountDownLatch latch2 = new CountDownLatch(threadCount);
        long startTime = System.nanoTime();
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < iterations; j++) {
                    T instance = singletonSupplier.get();
                }
                latch2.countDown();
            });
        }
        try {
            boolean completed = latch2.await(timeout, TimeUnit.SECONDS);
            if (!completed) {
                System.out.println("Concurrent access test for " + singletonSupplier.getClass().getSimpleName() + " timed out!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long concurrentAccessTime = endTime - startTime;

        executorService.shutdown();
        //save res
        String simpleName = singletonSupplier.get().getClass().getSimpleName();
        HashMap<String, Long> resMap = result.computeIfAbsent(simpleName, k->new HashMap<>());
        resMap.put("ConcurrentAccess", concurrentAccessTime);
        return concurrentAccessTime;
    }
}

