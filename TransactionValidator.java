public class TransactionValidator {

    public static void validateCryptoCurrencyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public static void validateExchangeRate(double exchangeRate) {
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Exchange rate must be greater than 0.");
        }
    }

    public static void validateQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
    }
}