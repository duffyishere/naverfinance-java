package naverfinance.quotes.stock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockQuote {

    private final String symbol;

    private BigDecimal closePrice;

    private BigDecimal compareToPreviousClosePrice;

    private String compareToPreviousPrice;

    private double fluctuationsRatio;

    private BigDecimal openPrice;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private BigDecimal accumulatedTradingVolume;

    private LocalDateTime localTradedAt;

    public StockQuote(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getCompareToPreviousClosePrice() {
        return compareToPreviousClosePrice;
    }

    public void setCompareToPreviousClosePrice(BigDecimal compareToPreviousClosePrice) {
        this.compareToPreviousClosePrice = compareToPreviousClosePrice;
    }

    public String getCompareToPreviousPrice() {
        return compareToPreviousPrice;
    }

    public void setCompareToPreviousPrice(String compareToPreviousPrice) {
        this.compareToPreviousPrice = compareToPreviousPrice;
    }

    public double getFluctuationsRatio() {
        return fluctuationsRatio;
    }

    public void setFluctuationsRatio(double fluctuationsRatio) {
        this.fluctuationsRatio = fluctuationsRatio;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getAccumulatedTradingVolume() {
        return accumulatedTradingVolume;
    }

    public void setAccumulatedTradingVolume(BigDecimal accumulatedTradingVolume) {
        this.accumulatedTradingVolume = accumulatedTradingVolume;
    }

    public LocalDateTime getLocalTradedAt() {
        return localTradedAt;
    }

    public void setLocalTradedAt(LocalDateTime localTradedAt) {
        this.localTradedAt = localTradedAt;
    }
}
