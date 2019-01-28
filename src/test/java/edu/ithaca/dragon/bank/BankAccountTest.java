package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    /**
     * Should withdraw specified funds IF available in account
     */
    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());

        bankAccount.withdraw(100);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){

        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertTrue(BankAccount.isEmailValid("user@domain.com"));
        assertTrue(BankAccount.isEmailValid("user1@domain.com"));
        assertTrue(BankAccount.isEmailValid("user.name@domain.com"));

        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("user@domaincom"));
        assertFalse(BankAccount.isEmailValid("user#domain.com"));
        assertFalse(BankAccount.isEmailValid("@yahoo.com"));
        assertFalse(BankAccount.isEmailValid("user@domain.co.in"));
    }

    @Test
    void isAmountValidTest() {

        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertTrue(bankAccount.isAmountValid(20.00));
        assertTrue(bankAccount.isAmountValid(20.45));
        assertTrue(bankAccount.isAmountValid(20.5));

        assertFalse(bankAccount.isAmountValid(20.005));
        assertFalse(bankAccount.isAmountValid(-20.5));
        assertFalse(bankAccount.isAmountValid(-20.005));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}