/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/15/2019
 * Time: 2:44 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: CashRegister
 *
 * Description:
 *
 * ****************************************
 */

package lab06;

public class CashRegister {

    /** amount of cash in drawer */
    private double cashInDrawer;

    /** current Transaction */
    private Transaction currentTransaction;

    /** name of the register */
    private String sName;

    /** the amount customer has paid */
    private double amountPaid;

    /**
     * Initialize a default, empty cash register
     */
    public CashRegister() {
        this.cashInDrawer = 0;
        this.currentTransaction = null;
        this.amountPaid = 0;
        this.sName = "Default";
    }

    /**
     * Initialize an empty cash register with a specified name
     *
     * @param sName - the name of the register
     */
    public CashRegister(String sName) {
        this(); // super
        this.sName = sName;
    }

    /**
     * Get the name of the CashRegister
     * @return String of name
     */
    public String getName() {
        return sName;
    }

    /**
     * Set the name of the CashRegister
     */
    public void setName(String name) {
        sName = name;
    }

    /**
     * Get the current Transaction
     *
     * @return Transaction
     */
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    /**
     * Check if the register is currently in a transaction
     * @return true if in a transaction false otherwise
     */
    public boolean isInTransaction() {
        return (currentTransaction != null);
    }

    /**
     * Get the amount owed on the current transaction
     *
     * @return amount owed on transaction, 0 if not in transaction
     */
    public double getAmountOwed() {
        if (!this.isInTransaction()) return 0;
        else {
            return currentTransaction.getTotalCost() - amountPaid;
        }
    }

    /**
     * Start the transaction if not in Transaction already and there is cash in drawer
     *
     * @return true if can start, false otherwise
     */
    public boolean startTransaction() {
        if (!this.isInTransaction() && cashInDrawer != 0) {
            currentTransaction = new Transaction();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finish the transaction if in the transaction and no money is owed
     *
     * @return true if can end, false otherwise
     */
    public boolean finishTransaction() {
        if (this.isInTransaction() && this.getAmountOwed() <= 0) {
            currentTransaction = null;
            amountPaid = 0;
            return true;
        } return false;
    }

    /**
     * Start the shift with an amount of money in the drawer
     *
     * @param initCash the amount to start
     */
    public void startShift(double initCash) {
        cashInDrawer = initCash;
    }

    /**
     * Return the amount of cash in the drawer, empties the cash out if not in transaction
     *
     * @return the amount of cash in drawer, -1 if in transaction
     */
    public double finishShift() {
        if (this.isInTransaction()) return -1;
        // empty the drawer
        double cash = cashInDrawer;
        cashInDrawer = 0;
        // return amount of cash in Drawer
        return cash;
    }

    /**
     * Add the amount of item to the transaction total, and increment the number of items in this transaction
     *
     * @param amountItem amount of the item being purchased
     */
    public void scanItem(double amountItem) {
        currentTransaction.addItemToTransaction(amountItem);
    }

    /**
     * Collect the payment from customer. Expect to be called multiple times
     * @param customerPaid
     * @return change if overdue, 0 if exact amount or negative if still owed
     */
    public double collectPayment(double customerPaid) {
        amountPaid += customerPaid;
        cashInDrawer += customerPaid;
        double difference = amountPaid - currentTransaction.getTotalCost();
        if (difference >= 0) {
            // overdue or exact
            amountPaid -= difference;
            cashInDrawer -= difference;
        }
        return difference;
    }

    /**
     * Represent the cashier in String
     * @return String of CashRegister
     */
    public String toString() {
        return "CashRegister{sName=\'" + sName + "\', cashInDrawer =" + cashInDrawer + ", currentTransaction=" + currentTransaction + ", amountPaid=" + amountPaid +"}";
    }



}