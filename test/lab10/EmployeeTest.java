package lab10;

import lab10.Employee;
import lab10.HRDateUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmployeeTest {

    private Employee emp;

    @BeforeEach
    void setUp() throws ParseException {
        emp = new Employee(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    /**
     * Test change name method
     */
    void changeName() {
        emp.changeName("First", "Last");
        assertEquals(emp.getFirstName(), "First");
        assertEquals(emp.getLastName(), "Last");
    }

    @Test
    /**
     * Test raise salary method
     */
    void raiseSalary() {
        assertEquals(emp.getSalary(), 174000);
        emp.raiseSalary(1000);
        assertEquals(emp.getSalary(), 174000 + 1000);
    }

    @Test
    /**
     * Test calculate payment of the employee
     */
    void testCalculatePay() {
        // 30 hours of work:
        double expected1 = 30*(emp.getSalary()/(52*40));
        assertEquals(expected1, emp.calculatePay(30));

        // 45 hours of work:
        double expected2 = 40*(emp.getSalary()/(52*40)) + 5*1.5*(emp.getSalary()/(52*40));
        assertEquals(expected2, emp.calculatePay(45));
    }

    @Test
    /**
     * Test equal method of employee
     */
    void testEquals() throws ParseException {
        Employee test = null;
        assertNotEquals(emp, test);

        test = new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000);
        System.out.println(emp);

        assertNotEquals(emp, test);

        test = new Employee(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000);

        assertEquals(emp, test);
    }

}