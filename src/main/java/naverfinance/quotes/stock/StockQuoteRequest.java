package naverfinance.quotes.stock;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public abstract class StockQuoteRequest<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    protected final String symbol;

    public StockQuoteRequest(String symbol) {
        this.symbol = symbol;
    }

    protected abstract T parseJson(JsonNode node);

    public T getSingleResponse() throws IOException {
        List<T> results = this.getResponse();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    protected abstract List<T> getResponse() throws IOException;
}
