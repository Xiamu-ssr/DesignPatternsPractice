package org.dragon.abstractfactory;

/**
 * 欧洲市场交易分析工具
 *
 * @author mumu
 * @date 2024/06/04
 */
public class EUAnalysisTool implements AnalysisTool{
    @Override
    public void analyze() {
        System.out.println("Analyzing EU market data");
    }
}
