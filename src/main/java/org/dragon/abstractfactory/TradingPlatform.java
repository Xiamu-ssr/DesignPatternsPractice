package org.dragon.abstractfactory;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Locale;

@Data
@AllArgsConstructor
public class TradingPlatform {

    private TradingFactory tradingFactory;

    public void processTrading() {
        Order order = tradingFactory.createOrder();
        AnalysisTool analysisTool = tradingFactory.createAnalysisTool();
        order.execute();
        analysisTool.analyze();
    }

    public static void main(String[] args) {
        //通过地区选择市场
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        TradingFactory factory;
        if ("US".equals(country)) {
            factory = new USTradingFactory();
            System.out.println("Using US Trading Factory");
        } else if ("FR".equals(country) || "DE".equals(country) || "IT".equals(country) || "ES".equals(country)) {
            // Assume these country codes represent some European countries
            factory = new EUTradingFactory();
            System.out.println("Using EU Trading Factory");
        } else {
            // Default factory if not US or specified EU countries
            factory = new USTradingFactory(); // or another default factory
            System.out.println("Using default Trading Factory");
        }

        TradingPlatform platform = new TradingPlatform(factory);
        platform.processTrading();
    }
}
