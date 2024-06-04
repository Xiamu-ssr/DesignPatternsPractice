package org.dragon.abstractfactory;

/**
 * 美国市场交易分析工具
 *
 * @author mumu
 * @date 2024/06/04
 */
public class USAnalysisTool implements AnalysisTool{
    @Override
    public void analyze() {
        System.out.println("Analyzing US market data");
    }
}
