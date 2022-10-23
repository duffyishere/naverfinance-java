package naverfinance.quotes.stock.foreign;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import naverfinance.Naverfinance;
import naverfinance.Stock;
import naverfinance.quotes.stock.StockQuoteRequest;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Slf4j
public class ForeignStockQuoteRequest extends StockQuoteRequest<Stock> {

    public ForeignStockQuoteRequest(String symbol) {
        super(symbol);
    }

    @Override
    protected List<Stock> parseJson(JsonNode node) throws IOException {
        return null;
    }

    @Override
    protected URL getUrl(String symbol) throws IOException {
        String url = Naverfinance.FOREIGN_QUOTES_BASE_URL.replace("{id}", this.symbol);

        return new URL(url);
    }
}
