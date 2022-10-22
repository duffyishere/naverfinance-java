package naverfinance;

import lombok.extern.slf4j.Slf4j;
import naverfinance.quotes.stock.StockQuote;

@Slf4j
public class Stock {

    private final String symbol;

    private String name;

    private String currency;

    private StockQuote quote;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public StockQuote getQuote() {
        return quote;
    }

    public void setQuote(StockQuote quote) {
        this.quote = quote;
    }
}
