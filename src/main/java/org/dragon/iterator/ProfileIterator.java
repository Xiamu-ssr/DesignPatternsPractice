package org.dragon.iterator;

/**
 * 用户信息迭代器
 *
 * @author mumu
 * @date 2024/06/08
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
