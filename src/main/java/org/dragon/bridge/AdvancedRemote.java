package org.dragon.bridge;

/**
 * 高级遥控器
 *
 * @author mumu
 * @date 2024/06/07
 */
public class AdvancedRemote extends BasicRemote{
    public AdvancedRemote(Device device) {
        super(device);
    }
    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
