package org.dragon.bridge;

import lombok.Data;

/**
 * 设备
 *
 * @author mumu
 * @date 2024/06/07
 */
@Data
public abstract class Device {
    protected boolean on = false;
    protected int volume = 30;
    protected int channel = 1;

    public boolean isEnabled(){
        return on;
    }

    public void enable(){
        on = true;
    }

    public void disable(){
        on = false;
    }

    public abstract void printStatus();
}
