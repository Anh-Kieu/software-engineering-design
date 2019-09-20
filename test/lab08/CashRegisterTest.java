package lab08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    /** Delta constant for checking floating point assertions */
    private static final double EPSILON = 1.0E-12;

    /** CashRegister used in every test */
    private CashRegister register;

    @BeforeEach
    void setUp() {
        this.register = new CashRegister();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPurchaseCount() {
        int result = register.getPurchaseCount();
        // Test the initial state. It should have NO items.
        assertEquals(0, result);

        // Now, set up an example with 2 items scanned
        register.scanItem(0.55);
        register.scanItem(1.27);
        assertEquals(2, register.getPurchaseCount());
    }

    @Test
    void getListOfPurchases() {
        LinkedList<Double> result = new LinkedList<>();
        // Test the initial state
        assertEquals(result, register.getListOfPurchases());

        // Now, set up an example with 2 items scanned

        result.add(0.55);
        result.add(1.27);

        register.scanItem(0.55);
        register.scanItem(1.27);
        assertEquals(result, register.getListOfPurchases());
    }

    @Test
    void getTransactionTotal() {
        // Make sure the transaction total is 0
        assertEquals(0.0, register.getTransactionTotal(), EPSILON);

        // Scan 2 items and check again
        register.scanItem(0.55);
        register.scanItem(1.27);
        assertEquals(1.82, register.getTransactionTotal(), EPSILON);
    }


    @DisplayName("scanItem: Bad Scan Test")
    @Test
    void scanItemException() {
        // Scan for a negative price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(-0.5));

        // Scan for a ridiculously large price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(10000.0));
    }

    @Test
    void collectPayment() {
        // initial state
        assertEquals(0, register.getPaymentCollected());

        // Test w 2 collect payment
        register.collectPayment(Money.DIME, 2);
        register.collectPayment(Money.QUARTER, 2);
        double expected = 2*0.1 + 2*0.25;
        assertEquals(expected, register.getPaymentCollected(), EPSILON);
    }

    @DisplayName("collectPayment: Bad collect payment Test")
    @Test
    void collectPaymentException() {
        // Negative money count
       assertThrows(IllegalArgumentException.class, () ->  register.collectPayment(Money.DIME, -1) );
    }

    @Test
    void giveChange() throws CashRegister.ChangeException {
        // Scan Item
        register.scanItem(0.55);
        register.scanItem(1.27);
        double trans = 1.82;
        // Collect payment
        register.collectPayment(Money.DOLLAR, 2);
        double pay = 2;

        assertEquals(pay-trans, register.giveChange());
    }

    @DisplayName("giveChange: Bad give change Test")
    @Test
    void giveChangeException() {
        // Try to give change before fulfilling payment
        // Scan Item
        register.scanItem(0.55);
        register.scanItem(1.27);
        // Collect payment
        register.collectPayment(Money.DOLLAR, 1);
        assertThrows(CashRegister.ChangeException.class, () -> register.giveChange());
    }

    @Test
    void testEquals() {
        CashRegister obj = new CashRegister();
        assertEquals(obj, register);

        register.scanItem(0.55);
        register.scanItem(1.27);
        register.collectPayment(Money.DOLLAR, 2);
        assertNotEquals(obj, register);
        obj.scanItem(0.55);
        obj.scanItem(1.27);
        obj.collectPayment(Money.DOLLAR, 2);
        assertEquals(obj, register);
    }
}