package org.dragon.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 投资组合
 *
 * @author mumu
 * @date 2024/06/07
 */
public class Portfolio implements FinancialComponent{
    private String name;
    private List<FinancialComponent> children  = new ArrayList<>();

    public Portfolio(String name, FinancialComponent... components) {
        this.name = name;
        add(components);
    }

    @Override
    public void display() {
        System.out.println("Portfolio: " + name);
        for (FinancialComponent component : children ) {
            component.display();
        }
    }

    @Override
    public double getValue() {
        double totalValue = 0;
        for (FinancialComponent component : children ) {
            totalValue += component.getValue();
        }
        return totalValue;
    }

    public void add(FinancialComponent component) {
        children .add(component);
    }

    public void add(FinancialComponent... components ) {
        children.addAll(List.of(components));
    }

    public void remove(FinancialComponent component) {
        children .remove(component);
    }

    public List<FinancialComponent> getChildren() {
        return children ;
    }

}
