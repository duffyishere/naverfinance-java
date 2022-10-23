package naverfinance.quotes.stock.domestic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomesticStockQuoteRequestTests {

    private static final Logger log = LoggerFactory.getLogger(DomesticStockQuoteRequestTests.class);

    @Test
    public void requestTest() throws IOException {
        DomesticStockQuoteRequest request = new DomesticStockQuoteRequest("005930");
//        request.getResponse().stream()
//                .forEach(stock -> log.info(stock.toString()));
        log.info(">>> {}", request.getSingleResponse().getQuote().toString());
    }
}