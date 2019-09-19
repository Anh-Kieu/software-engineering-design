/**
 * CSCI 205 - Software Engineering and Design
 *
 * Lab 08 - Learning how to use JUnit.
 *
 * @author Brian King, Rick Zaccone
 */
package lab08;

import java.util.LinkedList;
import java.util.List;

/**
 * The <code>CashRegister</code> class models a very simple cash register. The
 * cash register assumes that it has an unlimited supply of money in its drawer,
 * and thus this is not modeled. It handles the management of one transaction of
 * a time, where a transaction consists of a list of items purchased. This
 * register only logs the amount of each purchase in a single transaction.
 *
 * @author Prof. Rick Zaccone and Brian King
 */
public class CashRegister {

    /**
     * The total amount of the current transaction
     */
    private double totalTransaction;

    /**
     * Payment collected from the customer so far
     */
    private double paymentCollected;

    /**
     * List of purchases in the current transaction
     */
    private final LinkedList<Double> listOfItemPrices;

    /**
     * Maximum price allowed on an item
     */
    private static double MAX_ITEM_PRICE = 1000.0;

    class ChangeException extends Exception {
        public ChangeException(String message) {
            super(message);
        }
    }

    /**
     * Constructs a new cash register
     */
    public CashRegister() {
        totalTransaction = 0;
        paymentCollected = 0;
        listOfItemPrices = new LinkedList<Double>();
    }

    /**
     * @return the number of purchases in the current transaction
     */
    public int getPurchaseCount() {
        return listOfItemPrices.size();
    }

    /**
     * @return the list of purchases in the current transaction
     */
    public List<Double> getListOfPurchases() {
        return listOfItemPrices;
    }

    /**
     * @return get the total amount of the current transaction
     */
    public double getTransactionTotal() {
        return totalTransaction;
    }

    /**
     * @return the total amount of payment collected for the current transaction
     */
    public double getPaymentCollected() {
        return paymentCollected;
    }

    /**
     * Records the sale of an item in a transaction.
     *
     * @param price the price of the item. Precondition: price >= 0
     */
    public void scanItem(double price) {
        // If this is the first purchase in the transaction, then clear out the
        // list of purchases
        if (price < 0.0 || price > MAX_ITEM_PRICE) {
            String msg = String.format("scanItem: Bad Price $%.2f", price);
            throw new IllegalArgumentException(msg);
        }
        if (totalTransaction == 0) {
            listOfItemPrices.clear();
        }

        listOfItemPrices.add(price);
        totalTransaction += price;
    }

    /**
     * Enters the payment received from the customer; should be called once for
     * each monetary unit moneyType
     *
     * @param moneyType the moneyType of the monetary units in the payment
     * @param unitCount the number of monetary units
     */
    public void collectPayment(Money moneyType, int unitCount) {
        if (unitCount < 0) {
            String msg = String.format("collectPayment: Bad unit count %d", unitCount);
            throw new IllegalArgumentException(msg);
        }
        paymentCollected += unitCount * moneyType.getValue();
    }

    /**
     * Computes the change due and resets the machine for the next customer,
     * only if enough money was collected.
     *
     * @return the change due to the customer
     * @throws ChangeException thrown if not enough payment collected to cover transaction
     */
    public double giveChange() throws ChangeException {
        if (paymentCollected < totalTransaction) {
            String message = String.format("INSUFFICIENT PAYMENT: Collected $%.2f, transaction = $%.2f", paymentCollected, totalTransaction);
            throw new ChangeException(message);
        }
        double change = paymentCollected - totalTransaction;
        totalTransaction = 0;
        paymentCollected = 0;
        return change;
    }

    public static void main(String[] args) {
        CashRegister myRegister = new CashRegister();
        myRegister.scanItem(0.55);
        myRegister.scanItem(1.27);
        System.out.println("Purchases: " + myRegister.getListOfPurchases());
        System.out.println("Expected: [0.55, 1.27]");
        myRegister.collectPayment(Money.DOLLAR, 1);
        myRegister.collectPayment(Money.QUARTER, 3);
        myRegister.collectPayment(Money.NICKEL, 2);
        System.out.println("Payment made: " + myRegister.getPaymentCollected());
        System.out.println("Expected: 1.85");

        try {
            double myChange = myRegister.giveChange();
            System.out.println("Change: " + myChange);
            System.out.println("Expected: 0.03");
        } catch (ChangeException e) {
            System.err.println(e.getMessage());
        }

        // Check for an invalid price
//        myRegister.scanItem(-0.50);
//        myRegister.collectPayment(Money.DIME, -1);
    }

}
