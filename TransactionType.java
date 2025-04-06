public enum TransactionType {
    DEBIT,
    CREDIT;

    public static TransactionType fromString(String typeStr) {
        if (typeStr.equalsIgnoreCase("debit")) {
            return DEBIT;
        } else if (typeStr.equalsIgnoreCase("credit")) {
            return CREDIT;
        } else {
            throw new IllegalArgumentException("Invalid transaction type. Please enter 'Debit' or 'Credit'.");
        }
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}