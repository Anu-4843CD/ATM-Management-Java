import java.util.Scanner;

public class Bank {
    private Manager manager;

    public Bank() {
        manager = new Manager();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the ATM System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void register(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        manager.createAccount(accountNumber, ownerName, password);
    }

    private void login(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Account account = manager.getAccount(accountNumber);
        if (account != null && account.authenticate(password)) {
            Client client = new Client(account);
            System.out.println("Login successful.");
            clientMenu(client, scanner);
        } else {
            System.out.println("Invalid account number or password.");
        }
    }

    private void clientMenu(Client client, Scanner scanner) {
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    client.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    client.withdraw(withdrawAmount);
                    break;
                case 3:
                    client.checkBalance();
                    break;
                case 4:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }
}
