package lab09;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager mgr1;
    private Manager mgr2;
    private Employee emp;
    private Employee emp1;
    private Employee emp2;
    private Employee emp3;
    private Employee emp4;
    private Employee emp5;

    @BeforeEach
    void setUp() throws ParseException, Manager.ManagerException {
        mgr1 = new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING");

        mgr2 = new Manager(15, "Spongebob", "Squarepants",
                000000201, HRDateUtils.strToDate("2015-09-01"), 200000, "HR");

        emp =  new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000);

        emp1 =  new Employee(10, "Robert", "Randolph", 121212121, HRDateUtils.strToDate("2016-10-01"), 75000);

        emp2 =  new Employee(2, "Jimi", "Hendrix", 000000001, new Date(), 70000);

        emp3 =  new Employee(12, "Blueberry", "Cheesecake", 987654321, HRDateUtils.strToDate("2012-08-29"), 63000);

        emp4 =  new Employee(14, "Mickey", "Mouse", 020202020, HRDateUtils.strToDate("2011-11-21"), 73000);

        emp5 =  new Employee(25, "Mike", "Wazowski", 100000000, new Date(), 70000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee() throws Manager.ManagerException {
        List<Employee> new_list = new ArrayList<>();
        assertEquals(mgr1.getEmpList(), new_list);

        mgr1.addEmployee(emp);

        assertNotEquals(mgr1.getEmpList(), new_list);

        new_list.add(emp);

        assertEquals(mgr1.getEmpList(), new_list);
    }

    @Test
    void removeEmployee() throws Manager.ManagerException {
        mgr1.addEmployee(emp);
        mgr1.addEmployee(emp1);
        mgr1.addEmployee(emp2);

        List<Employee> l = new ArrayList<>();
        l.add(emp1);
        l.add(emp2);
        // test remove
        mgr1.removeEmployee(emp);

        assertEquals(mgr1.getEmpList(), l);
    }

    @DisplayName("Remove non exist")
    @Test
    void testRemoveException() {
        assertThrows(Manager.ManagerException.class, () -> mgr1.removeEmployee(emp));
    }

    @DisplayName("Add already exist")
    @Test
    void testAddException() throws Manager.ManagerException {
        mgr1.addEmployee(emp);
        assertThrows(Manager.ManagerException.class, () -> mgr1.addEmployee(emp));
    }

    @DisplayName("Bad epartment name")
    @Test
    void testConstructor() {
        assertThrows(Manager.ManagerException.class, () -> new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "SUSHI"));
    }

}