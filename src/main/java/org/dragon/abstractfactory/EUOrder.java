package org.dragon.abstractfactory;

/**
 * 欧洲订单
 *
 * @author mumu
 * @date 2024/06/04
 */
public class EUOrder implements Order{
    @Override
    public void execute() {
        System.out.println("Executing order in EU market");
    }
}
