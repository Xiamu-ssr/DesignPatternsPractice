package org.dragon.decorator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * 文件数据读写
 *
 * @author mumu
 * @date 2024/06/07
 */
@Data
@AllArgsConstructor
public class FileDataSource implements DataSource{
    private String name;
    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
