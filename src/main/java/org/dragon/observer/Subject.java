package org.dragon.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题
 * <BR/>将与观察者一系列互动抽取出来
 *
 * @author mumu
 * @date 2024/06/17
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
