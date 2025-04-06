import java.time.LocalDate;

public class Transaction {

    private String cryptoCurrency;
    private double exchangeRate;
    private double quantity;
    private TransactionType type;
    private LocalDate date;

    public Transaction(String cryptoCurrency, double exchangeRate, double quantity, TransactionType type) {
        this.cryptoCurrency = cryptoCurrency;
        this.exchangeRate = exchangeRate;
        this.quantity = quantity;
        this.type = type;
        this.date = LocalDate.now();
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getQuantity() {
        return quantity;
    }

    public TransactionType getTransactionType() {
        return type;
    }

    public String toString() {
        return "\nCryptoCurrency: " + cryptoCurrency + "\nExchange Rate: " + exchangeRate + "\nQuantity: " + quantity + "\nTransaction Type: " + type + "\nDate: " + date;
    }
}