package naverfinance;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Converters {

    private static boolean isParseable(String data) {
        return !(data == null || data.equals(""));
    }

    public static BigDecimal stringToBigDecimal(String data) {
        BigDecimal result = null;
        if (!Converters.isParseable(data)) {
            return result;
        }

        try {
            result = new BigDecimal(data.replaceAll(",", ""));
        }
        catch (NumberFormatException e) {
            log.warn("Failed to convert string to bigdecimal. data: {}", data);
            log.debug("Failed to convert string to bigdecimal. data: {}", data, e);
        }

        return result;
    }

    public static double stringToDouble(String data) {
        double result = Double.NaN;
        if (!Converters.isParseable(data))
            return result;

        try {
            return Double.parseDouble(data.replaceAll(",", ""));
        }
        catch (NumberFormatException e) {
            log.warn("Failed to convert string to double. data: {}", data);
            log.debug("Failed to convert string to double. data: {}", data, e);
        }

        return result;
    }

    public static LocalDateTime stringToLocalDateTime(String data) {
        LocalDateTime result = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        if (!Converters.isParseable(data))
            return result;

        try {
            return LocalDateTime.parse(data.substring(0, data.length() -6), formatter);
        }
        catch (Exception e) {
            log.warn("Failed to convert string to localdatetime. data: {}", data);
            log.debug("Failed to convert string to localdatetime. data: {}", data, e);
        }

        return result;

    }
}
