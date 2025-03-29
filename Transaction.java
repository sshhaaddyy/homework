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

    public String getCryptoCurrenct() {
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
        String stringType = "Credit";
        if (this.type.getType() == 1) {
            stringType = "Debit";
        }
        return "\nCryptoCurrency: " + this.cryptoCurrency + "\nExchange Rate: " + this.exchangeRate + "\nQuantity: " + this.quantity + "\nTransaction Type: " + stringType + "\nDate: " + this.date;
    }
}