package lab10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account acc;

    /** For checking the output stream */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /** Delta constant for checking floating point assertions */
    private static final double EPSILON = 1.0E-6;

    /** This is a constant because we don't test Employee, instead we test Account -> won't change employee */


    @BeforeEach
    void setUp() {
        acc = new Account(1000000);
        System.setOut( new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    /**
     * Test credit method, to see if balance is added
     */
    void credit() {
        assertEquals(acc.getBalance(), 1000000);
        acc.credit(5000);
        assertEquals(acc.getBalance(), 1000000 + 5000);
    }

    @Test
    /**
     * Test debit method, to see if balance is subtracted
     */
    void debit() throws Account.InsufficientFundsException {
        assertEquals(acc.getBalance(), 1000000);
        acc.debit(5000);
        assertEquals(acc.getBalance(), 1000000 - 5000);
    }

    @DisplayName("Not enough fund check")
    @Test
    /**
     * Test if the debit raised exception for over debit
     */
    void debitException() {
        assertThrows(Account.InsufficientFundsException.class, () -> acc.debit(30000000));
    }

    @Test
    /**
     * Test process Check
     */
    void processCheck() throws Account.InsufficientFundsException, ParseException {
        Employee emp = new Employee(100, "Boo", "Boop", 123456789, HRDateUtils.strToDate("2015-08-20"), 50000);
        assertEquals(acc.getBalance(), 1000000);
        acc.processCheck(emp, 45, System.out);
        double expected = 1000000 - (emp.getSalary()/(52 * 40))*40 - (emp.getSalary()/(52 * 40))*5*1.5;
        assertEquals(expected, acc.getBalance(), EPSILON);
        assertEquals("Name : Boo Boop Employee ID: 100, Pay Date: 2019-09-29" + System.getProperty("line.separator"), outContent.toString());
    }


}