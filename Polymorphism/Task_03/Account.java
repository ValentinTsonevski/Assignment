package Polymorphism.Task_03;

public abstract class Account {
    private int accountNumber;
    private double balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void getAccountInfo() {
        System.out.printf("Account number: %d" +
                "Balance: %f",getAccountNumber(),getBalance());
    }

}
