package org.dragon.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基金
 *
 * @author mumu
 * @date 2024/06/07
 */
@Data
@AllArgsConstructor
public class Bond implements FinancialComponent{
    private String name;
    private double faceValue;
    private double interestRate;
    @Override
    public void display() {
        System.out.println("Bond: " + name + ", Face Value: $" + faceValue + ", Interest Rate: " + interestRate + "%");
    }

    @Override
    public double getValue() {
        return faceValue * (1 + interestRate / 100);
    }
}
