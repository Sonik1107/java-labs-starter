package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        this.balance = b;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
