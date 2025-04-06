import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactionList = new ArrayList<>();
        System.out.println("--- Welcome to Crypto Diary! ---");

        while (true) {
            System.out.println("\nPlease select an operation:\n\n1. Add new transaction\n2. Load transaction history\n3. Exit\n");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    String name;
                    while (true) {
                        System.out.print("Please enter the crypto currency name: ");
                        name = scanner.nextLine().trim();
                        try {
                            TransactionValidator.validateCryptoCurrencyName(name);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    double exchangeRate;
                    while (true) {
                        System.out.print("Please enter the exchange rate: ");
                        String input = scanner.nextLine();
                        try {
                            exchangeRate = Double.parseDouble(input);
                            TransactionValidator.validateExchangeRate(exchangeRate);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    double quantity;
                    while (true) {
                        System.out.print("Please enter the quantity: ");
                        String input = scanner.nextLine();
                        try {
                            quantity = Double.parseDouble(input);
                            TransactionValidator.validateQuantity(quantity);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    TransactionType type;
                    while (true) {
                        System.out.print("Please enter the transaction type (Debit/Credit): ");
                        String typeInput = scanner.nextLine().trim();
                        try {
                            type = TransactionType.fromString(typeInput);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Transaction transaction = new Transaction(name, exchangeRate, quantity, type);
                    transactionList.add(transaction);
                    System.out.println("\nTransaction has been successfully added to your diary!");
                    break;

                case 2:
                    System.out.println("\n--- Transaction History ---");
                    for (Transaction t : transactionList) {
                        System.out.println(t);
                    }
                    System.out.println("\n--- Current account balance ---");
                    double totalDebit = 0.0;
                    double totalCredit = 0.0;
                    for (Transaction t : transactionList) {
                        if (t.getTransactionType() == TransactionType.DEBIT) {
                            totalDebit += t.getQuantity() * t.getExchangeRate();
                        } else if (t.getTransactionType() == TransactionType.CREDIT) {
                            totalCredit += t.getQuantity() * t.getExchangeRate();
                        }
                    }
                    System.out.printf("Total Debit: %.2f\n", totalDebit);
                    System.out.printf("Total Credit: %.2f\n", totalCredit);
                    break;

                case 3:
                    System.out.println("Exiting Crypto Diary. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    break;
            }
        }
    }
}