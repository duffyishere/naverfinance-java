package naverfinance.quotes.stock.domestic;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import naverfinance.Utils;
import naverfinance.Stock;
import naverfinance.Converters;
import naverfinance.quotes.stock.StockQuote;
import naverfinance.quotes.stock.StockQuoteRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DomesticStockQuoteRequest extends StockQuoteRequest<Stock> {

    public DomesticStockQuoteRequest(String symbol) {
        super(symbol);
    }

    @Override
    protected List<Stock> parseJson(JsonNode node) throws IOException {
        List<Stock> result = new ArrayList<>();

        if (node.has("datas")) {
            node = node.get("datas");
            for (JsonNode data : node) {
                String symbol = data.get("itemCode").asText();
                Stock stock = new Stock(symbol);

                stock.setName(data.get("stockName").asText());
                stock.setCurrency(data.get("currencyType").get("code").asText());

                stock.setQuote(this.getQuote(data));

                result.add(stock);
            }
        }
        else {
            throw new IOException("Invalid response");
        }

        return result;
    }

    private StockQuote getQuote(JsonNode node) {
        String symbol = node.get("itemCode").asText();
        StockQuote quote = new StockQuote(symbol);

        quote.setClosePrice(Converters.stringToBigDecimal(node.get("closePrice").asText()));
        quote.setCompareToPreviousClosePrice(Converters.stringToBigDecimal(node.get("compareToPreviousClosePrice").asText()));
        quote.setCompareToPreviousPrice(node.get("compareToPreviousPrice").get("name").asText());
        quote.setFluctuationsRatio(Converters.stringToDouble(node.get("fluctuationsRatio").asText()));
        quote.setOpenPrice(Converters.stringToBigDecimal(node.get("openPrice").asText()));
        quote.setHighPrice(Converters.stringToBigDecimal(node.get("highPrice").asText()));
        quote.setLowPrice(Converters.stringToBigDecimal(node.get("lowPrice").asText()));
        quote.setAccumulatedTradingVolume(Converters.stringToBigDecimal(node.get("accumulatedTradingVolume").asText()));
//        quote.setLocalTradedAt(Converters.stringToLocalDateTime(node.get("localTradedAt").asText()));

        return quote;
    }

    @Override
    protected URL getUrl(String symbol) throws IOException {
        String url = Utils.DOMESTIC_QUOTES_BASE_URL.replace("{id}", this.symbol);

        return new URL(url);
    }
}
