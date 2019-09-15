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

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Transaction {

    /** Number of items in the transaction */
    private int numItems;

    /** Transaction total */
    private double totalCost;

    /** List of the price of every item in this transaction */
    private ArrayList<Double> itemList;
    /** Tracks summary stats over all prices in this transaction */
    private DoubleSummaryStatistics dss;


    /**
     * A new transaction will have 0 items and 0 totalCost
     */
    public Transaction() {
        this.itemList = new ArrayList<>();
        this.dss = new DoubleSummaryStatistics();
    }

    /**
     * Add the price of a single item at a time to this transaction
     *
     * @param price - price of the item
     */
    public void addItemToTransaction(double price) {
        itemList.add(price);
        dss.accept(price);
    }

    /**
     * Represent Transaction in String
     *
     * @return a String for Transaction
     */
    public String toString() {
        return "Transaction{itemList=" + itemList.toString() + ",  dss=DoubleSummaryStatistics{count=" + getNumItems() +
                ", sum=" + getTotalCost() + ", min=" + getMinCost() + ", avg=" + getAveCost() +", max=" + getMaxCost() + "}}";
    }

    /**
     * Get the list of prices
     *
     * @return list of prices
     */
    public List<Double> getListOfPrices() {
        return itemList;
    }

    /**
     * Get number of items
     *
     * @return number of items
     */
    public long getNumItems() {
        return this.dss.getCount();
    }

    /**
     * Get total cost
     * @return total cost
     */
    public double getTotalCost() {
        return this.dss.getSum();
    }

    /**
     * Get the lowest cost
     *
     * @return lowest cost
     */
    public double getMinCost() {
        return this.dss.getMin();
    }

    /**
     * Get the highest cost
     *
     * @return highest cost
     */
    public double getMaxCost() {
        return this.dss.getMax();
    }

    /**
     * Get the average cost
     *
     * @return average cost
     */
    public double getAveCost() {
        return this.dss.getAverage();
    }
}