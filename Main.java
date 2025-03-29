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
                        if (!name.isEmpty()) {
                            break;
                        }
                        System.out.println("Name cannot be empty. Please try again.");
                    }

                    double exchangeRate;
                    while (true) {
                        System.out.print("Please enter the exchange rate: ");
                        try {
                            exchangeRate = Double.parseDouble(scanner.nextLine());
                            if (exchangeRate > 0) {
                                break;
                            }
                            System.out.println("Exchange rate must be greater than 0. Please try again.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        }
                    }

                    double quantity;
                    while (true) {
                        System.out.print("Please enter the quantity: ");
                        try {
                            quantity = Double.parseDouble(scanner.nextLine());
                            if (quantity > 0) {
                                break;
                            }
                            System.out.println("Quantity must be greater than 0. Please try again.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        }
                    }

                    TransactionType type;
                    while (true) {
                        System.out.print("Please enter the transaction type (Debit/Credit): ");
                        String typeInput = scanner.nextLine().trim();
                        type = new TransactionType(typeInput);
                        if (type.getType() != 3) {
                            break;
                        }
                        System.out.println("Invalid transaction type. Please enter 'Debit' or 'Credit'.");
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
                        if (t.getTransactionType().getType() == 1) {
                            totalDebit += t.getQuantity() * t.getExchangeRate();
                        } else if (t.getTransactionType().getType() == 2) {
                            totalCredit += t.getQuantity() * t.getExchangeRate();
                        }
                    }
                    System.out.printf("Total Debit: " + totalDebit);
                    System.out.printf("Total Credit: " + totalCredit);
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