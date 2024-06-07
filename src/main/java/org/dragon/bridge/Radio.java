package org.dragon.bridge;

/**
 * 无线电广播
 *
 * @author mumu
 * @date 2024/06/07
 */
public class Radio extends Device{
    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm radio.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
