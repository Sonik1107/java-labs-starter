package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTest {

    @Test
    public void TrueBalance() {
        BankAccount account = new BankAccount(400);
        assertEquals(400, account.getBalance(), "Баланс: 400");
    }

    @Test
    public void ZeroBalance() {
        BankAccount account = new BankAccount(0);
        assertEquals(0, account.getBalance(), "Баланс: 0");
    }

    @Test
    public void FalseBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100);
        }, "Баланс не может быть отрицательным");
    }

    @Test
    public void TrueDeposit() {
        BankAccount account = new BankAccount(150);
        account.deposit(50);
        assertEquals(200, account.getBalance(), "Баланс: 200");
    }

    @Test
    public void ZeroDeposit() {
        BankAccount account = new BankAccount(150);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        }, "Нельзя пополнять на 0");
    }

    @Test
    public void FalseDeposit() {
        BankAccount account = new BankAccount(150);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        }, "Нельзя пополнять на отрицательную сумму");
    }

    @Test
    public void TrueWithdraw() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance(), "Баланс: 150");
    }

    @Test
    public void ZeroWithdraw() {
        BankAccount account = new BankAccount(200);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        }, "Нельзя снять 0");
    }

    @Test
    public void NegativeWithdraw() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20);
        }, "Нельзя снять отрицательное число");
    }

    @Test
    public void ExcessWithdraw() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        }, "Нельзя снять больше, чем есть на балансе");
    }
}
