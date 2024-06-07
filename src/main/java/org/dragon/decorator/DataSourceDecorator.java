package org.dragon.decorator;

/**
 * 数据源装饰器
 *
 * @author mumu
 * @date 2024/06/07
 */
public abstract class DataSourceDecorator implements DataSource{
    private DataSource wrapper;
    DataSourceDecorator(DataSource source) {
        wrapper = source;
    }
    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
