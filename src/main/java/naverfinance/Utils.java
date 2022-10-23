package naverfinance;

import naverfinance.quotes.stock.domestic.DomesticStockQuoteRequest;
import naverfinance.quotes.stock.foreign.ForeignStockQuoteRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static final String DOMESTIC_QUOTES_BASE_URL = System.getProperty("naverfinance.baseurl.quotes.domestic", "https://polling.finance.naver.com/api/realtime/domestic/stock/{id}");
    public static final String FOREIGN_QUOTES_BASE_URL = System.getProperty("naverfinance.baseurl.quotes.foreign", "https://polling.finance.naver.com/api/realtime/worldstock/stock/{id}");

    public static Stock get(String symbol, boolean includeHistorical) throws IOException {
        Map<String, Stock> result = Utils.getQuotes(symbol, includeHistorical);

        return result.get(symbol);
    }

    private static Map<String, Stock> getQuotes(String symbol, boolean includeHistorical) throws IOException {
        HashMap<String, Stock> result = new HashMap<>();
        if (isDomestic(symbol)) {
            DomesticStockQuoteRequest request = new DomesticStockQuoteRequest(symbol);
            List<Stock> stocks = request.getResponse();
            for (Stock stock : stocks) {
                result.put(stock.getSymbol(), stock);
            }
        }
        else {
            ForeignStockQuoteRequest request = new ForeignStockQuoteRequest(symbol);
            List<Stock> stocks = request.getResponse();
            for (Stock stock : stocks) {
                result.put(stock.getSymbol(), stock);
            }
        }

        return result;
    }

    private static boolean isDomestic(final CharSequence cs) {
        if (cs == null || cs.length() == 0) {
            return false;
        }

        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i)))
                return false;
        }

        return true;
    }
}
