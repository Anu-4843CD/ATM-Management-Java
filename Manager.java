import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Account> accounts;

    public Manager() {
        accounts = new HashMap<>();
    }

    public Account createAccount(String accountNumber, String ownerName, String password) {
        if (!accounts.containsKey(accountNumber)) {
            Account newAccount = new Account(accountNumber, ownerName, password);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully.");
            return newAccount;
        } else {
            System.out.println("Account number already exists.");
            return null;
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
