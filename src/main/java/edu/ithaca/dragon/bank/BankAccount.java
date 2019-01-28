package edu.ithaca.dragon.bank;

import java.math.BigDecimal;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){

        if (isEmailValid(email)){

            if (isAmountValid(startingBalance)) {

                this.email = email;
                this.balance = startingBalance;

            } else {
                throw new IllegalArgumentException("Balance: " + startingBalance + " is invalid, cannot create account");
            }
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) {

        if (isAmountValid(amount)) {

            if (balance - amount >= 0) {
                balance -= amount;
            } else {
                System.out.println("Cannot withdraw amount of: " + amount + " with a balance of: " + balance);
            }

        } else {

            throw new IllegalArgumentException("Amount: " + amount + " is invalid, cannot withdraw");
        }
    }

    /**
     * @param email the string to be verified as an email
     * @return true if param starts with a valid sequence, contains '@',
     * and ends with a valid sequence (with the last set of letters having a count between 2 and 4)
     */
    public static boolean isEmailValid(String email){
        return email.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z]{2,4}");
    }

    /**
     *
     * @param amount a double to be verified
     * @return true if amount has no more than 2 decimal places and is positive
     */
    public static boolean isAmountValid(Double amount){

        if (amount < 0) {
            return false;
        }

        if ((BigDecimal.valueOf(amount).scale() > 2)) {
            return false;
        }

        return true;
    }
}
