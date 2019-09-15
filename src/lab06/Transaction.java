/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Anh Kieu
 * Section: 9am
 * Date: 9/15/2019
 * Time: 2:38 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: Transaction
 *
 * Description: Classes
 *
 * ****************************************
 */

package lab06;

public class Transaction {

    /** Number of items in the transaction */
    private int numItems;

    /** Transaction total */
    private double totalCost;

    /**
     * A new transaction will have 0 items and 0 totalCost (i.e a
     * default constructor is sufficient.)
     */
    public Transaction() {
        this.numItems = 0;
        this.totalCost = 0;
    }

    /**
     * Add the price of a single item at a time to this transaction
     *
     * @param price - price of the item
     */
    public void addItemToTransaction(double price) {
        numItems += 1;
        totalCost += price;
    }

    /**
     * Represent Transaction in String
     *
     * @return a String for Transaction
     */
    public String toString() {
        return "Transaction{numItems=" + numItems + ", transactionTotal =" + totalCost + "}";
    }

    /**
     * Get number of items
     * @return int of num items
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * Set number of items
     *
     * @param itemAdd number of added items
     */
    public void setNumItems(int itemAdd) {
        numItems += itemAdd;
    }

    /**
     * Get the total cost
     * @return total cost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Set the total cost
     * @param total the amount to set
     */
    public void setTotalCost(double total) {
        totalCost = total;
    }
}