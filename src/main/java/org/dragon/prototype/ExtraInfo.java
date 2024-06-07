package org.dragon.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 额外信息
 *
 * @author mumu
 * @date 2024/06/05
 */
@Data
@AllArgsConstructor
public class ExtraInfo implements Cloneable, Serializable {
    private String description;
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
