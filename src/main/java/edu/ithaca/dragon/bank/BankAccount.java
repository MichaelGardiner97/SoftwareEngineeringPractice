package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
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
    public void withdraw (double amount)  {

        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("Cannot withdraw amount of: " + amount + " with a balance of: " + balance);
        }
    }

    /**
     * @param email the string to be verified as an email
     * @return true if param starts with a valid sequence, contains '@',
     * and ends with a valid sequence (with the last set of letters having a count of 3)
     */
    public static boolean isEmailValid(String email){

        return email.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z]{3}");
    }

    /**
     *
     * @param amount
     * @return true if amount has no more than 2 decimal places and is positive
     */
    public static boolean isAmountValid(Double amount){

        return false;
    }
}
