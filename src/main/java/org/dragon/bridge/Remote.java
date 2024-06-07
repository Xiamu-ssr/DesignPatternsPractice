package org.dragon.bridge;

/**
 * 遥控器
 *
 * @author mumu
 * @date 2024/06/07
 */
public interface Remote {
    /**
     * 开关机
     */
    void power();

    /**
     * 音量降低
     */
    void volumeDown();

    /**
     * 音量增大
     */
    void volumeUp();

    /**
     * 频道下调
     */
    void channelDown();

    /**
     * 频道上调
     */
    void channelUp();
}
