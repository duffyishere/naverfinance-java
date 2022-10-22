package naverfinance.quotes.stock.foreign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import naverfinance.Naverfinance;
import naverfinance.Stock;
import naverfinance.quotes.stock.StockQuoteRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ForeignStockQuoteRequest extends StockQuoteRequest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ForeignStockQuoteRequest(String symbol) {
        super(symbol);
    }

    @Override
    protected Object parseJson(JsonNode node) {
        return null;
    }


    // TODO : Implement getResponse() method
    @Override
    public List<Stock> getResponse() throws IOException {
        List<Stock> result = new ArrayList<>();

        String url = Naverfinance.FOREIGN_QUOTES_BASE_URL.replace("{id}", this.symbol);
        URL request = new URL(url);
        URLConnection connection = request.openConnection();

        InputStream inputStream = connection.getInputStream();
        JsonNode node = objectMapper.readTree(inputStream);

        // TODO: Response parsing Stock object

        return result;
    }
}
