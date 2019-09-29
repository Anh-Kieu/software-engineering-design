/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/28/2019
 * Time: 6:05 PM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Account
 *
 * Description:
 *
 * ****************************************
 */

package lab10;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Account {

    /**
     * Exception class that raises exception if the balance is not enough
     * In Account class: Will display how much is requested and how much left in the balance
     */
    class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * Get the account balance
     * @return Account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the account balance
     * @param initBalance - new account balance
     */
    public void setBalance(double initBalance) {
        this.balance = initBalance;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(("$###,###,###.##"));
        return "ACCOUNT: " + formatter.format(balance);
    }

    /**
     * Add money to the account
     *
     * @param amount to be added
     */
    public void credit(double amount) {
        balance += amount;
    }

    /**
     * Subtract money from the account, raise exception if not enough
     *
     * @param amount to be subtracted
     */
    public void debit(double amount) throws InsufficientFundsException {
        DecimalFormat formatter = new DecimalFormat(("$###,###,###.##"));
        if (amount >= balance) throw new InsufficientFundsException("Not enough fund! Demand: " + formatter.format(amount) + " Actual existing: " + formatter.format(balance));
        balance -= amount;
    }

    public void processCheck(Payable p, double hoursBilled, PrintStream out) throws InsufficientFundsException {
        double amount = p.calculatePay(hoursBilled);
        debit(amount);
        out.println(p.getPayTo() + " " + p.getPayMemo() );
    }
}