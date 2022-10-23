package naverfinance.quotes.stock;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Slf4j
public abstract class StockQuoteRequest<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    protected final String symbol;

    public StockQuoteRequest(String symbol) {
        this.symbol = symbol;
    }

    // Parsing Node to Object class…
    protected abstract List<T> parseJson(JsonNode node) throws IOException;

    protected abstract URL getUrl(String symbol) throws IOException;

    public T getSingleResponse() throws IOException {
        List<T> results = this.getResponse();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public List<T> getResponse() throws IOException {
        URL request = this.getUrl(symbol);
        URLConnection connection = request.openConnection();

        InputStream inputStream = connection.getInputStream();
        JsonNode node = objectMapper.readTree(inputStream);

        return this.parseJson(node);
    }
}
