package lab10;

public interface Payable {
    /**
     * Calculate pay based on the number of working hours
     * @param numHrs - number of working hour
     * @return the payment
     */
    double calculatePay(double numHrs);

    /**
     * Get the receiver of the payment
     * @return The receiver
     */
    String getPayTo();

    /**
     * Get the paymemt memo
     * @return the memo
     */
    String getPayMemo();
}
