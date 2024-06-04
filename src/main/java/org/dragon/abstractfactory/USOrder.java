package org.dragon.abstractfactory;

/**
 * 美国订单
 *
 * @author mumu
 * @date 2024/06/04
 */
public class USOrder implements Order{
    @Override
    public void execute() {
        System.out.println("Executing order in US market");
    }
}
