package org.dragon.composite;

public class Demo {
    public static void main(String[] args) {
        // 创建单个金融产品
        FinancialComponent stock1 = new Stock("AAPL", 150.00, 10);
        FinancialComponent stock2 = new Stock("GOOGL", 2800.00, 5);
        FinancialComponent stock3 = new Stock("NIDA", 3800.00, 10);
        FinancialComponent bond1 = new Bond("US Treasury", 1000.00, 2.0);
        FinancialComponent bond2 = new Bond("CN Treasury", 2000.00, 4.0);

        // 创建复合金融产品组合
        FinancialComponent portfolio1 = new Portfolio("Tech 01 Portfolio", stock1, bond1);
        FinancialComponent portfolio2 = new Portfolio("Tech 02 Portfolio", stock2, bond2);
        FinancialComponent diversifiedPortfolio = new Portfolio("Diversified Portfolio", portfolio1, stock3, portfolio2);

        // 显示金融组合信息
        diversifiedPortfolio.display();
        System.out.println("Total Portfolio Value: $" + diversifiedPortfolio.getValue());

    }
}
