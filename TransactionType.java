public class TransactionType {

    private String type;

    public TransactionType(String type) {
        if (type.equalsIgnoreCase("debit")) {
            this.type = "Debit";
        } else if (type.equalsIgnoreCase("credit")) {
            this.type = "Credit";
        } else {
            this.type = "Bad type";
        }
    }

    public int getType() {
        if (this.type.equalsIgnoreCase("debit")) {
            return 1;
        } else if (this.type.equalsIgnoreCase("credit")) {
            return 2;
        }
        return 3;
    }
}