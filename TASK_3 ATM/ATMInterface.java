import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static double balance = 5000;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    displayTransactions();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nWelcome to the ATM Interface");
        System.out.println("=============================");
        System.out.println("1. Display balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Display transaction history");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayBalance() {
        System.out.printf("\nYour current balance is $%.2f\n", balance);
    }

    private static void deposit() {
        System.out.print("\nEnter the amount you want to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.printf("\n$%.2f has been deposited to your account\n", amount);
        displayBalance();
    }

    private static void withdraw() {
        System.out.print("\nEnter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance! Please try again.");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.printf("\n$%.2f has been withdrawn from your account\n", amount);
            displayBalance();
        }
    }

    private static void transfer() {
        System.out.print("\nEnter the amount you want to transfer: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance! Please try again.");
        } else {
            System.out.print("\nEnter the recipient's account number: ");
            int recipientAccountNumber = scanner.nextInt();
            balance -= amount;
            transactions.add(new Transaction("Transfer to account " + recipientAccountNumber, amount));
            System.out.printf("\n$%.2f has been transferred to account %d\n", amount, recipientAccountNumber);
            displayBalance();
        }
    }

    private static void displayTransactions() {
        System.out.println("\nTransaction history:");
        System.out.println("====================");
        for (Transaction transaction : transactions) {
            System.out.printf("%s: $%.2f\n", transaction.getType(), transaction.getAmount());
        }
    }

    private static class Transaction {
        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }
    }
}
