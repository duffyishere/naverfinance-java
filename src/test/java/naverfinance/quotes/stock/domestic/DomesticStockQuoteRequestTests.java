package naverfinance.quotes.stock.domestic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DomesticStockQuoteRequestTests {

    @Test
    public void requestTest() throws IOException {
        DomesticStockQuoteRequest request = new DomesticStockQuoteRequest("005930");
        request.getResponse();
    }
}