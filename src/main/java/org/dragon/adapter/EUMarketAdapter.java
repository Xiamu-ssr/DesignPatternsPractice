package org.dragon.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

@Data
@AllArgsConstructor
public class EUMarketAdapter implements MarketDataService{
    private EUMarketProvider marketProvider;
    @Override
    public double getStockPrice(String stockSymbol) {
        String xmlData = marketProvider.fetchStockInfo(stockSymbol);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
            NodeList priceNode = doc.getElementsByTagName("price");
            return Double.parseDouble(priceNode.item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
