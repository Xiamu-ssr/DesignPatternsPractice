package org.dragon.decorator;

/**
 * 数据读写
 *
 * @author mumu
 * @date 2024/06/07
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
