package lab09;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee emp;

    @BeforeEach
    void setUp() throws ParseException {
        emp = new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void changeName() {
        emp.changeName("First", "Last");
        assertEquals(emp.getFirstName(), "First");
        assertEquals(emp.getLastName(), "Last");
    }

    @Test
    void raiseSalary() {
        assertEquals(emp.getSalary(), 174000);
        emp.raiseSalary(1000);
        assertEquals(emp.getSalary(), 174000 + 1000);
    }

    @Test
    void testEquals() throws ParseException {
        Employee test = null;
        assertNotEquals(emp, test);

        test = new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000);
        System.out.println(emp);

        assertNotEquals(emp, test);

        test = new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING");

        assertEquals(emp, test);
    }
}