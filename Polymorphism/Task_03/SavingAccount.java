package Polymorphism.Task_03;

public class SavingAccount extends Account {

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();
        double balanceAfterAmountWithdrawal = balance - amount;

        if (balanceAfterAmountWithdrawal <= 100) {
            System.out.println("Sorry but we have to deny the withdrawal, due to balance falling below 100$");
        } else {
            super.withdraw(amount);
        }

    }
}
