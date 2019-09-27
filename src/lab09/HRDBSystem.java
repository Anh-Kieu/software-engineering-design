/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: Anh Kieu
 * Date: 9/25/19
 * Time: 9AM
 *
 * Project: csci205
 * Package: lab09
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */

package lab09;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Anh Kieu
 */
public class HRDBSystem {

    /** List of employees */
    private static ArrayList<Employee> listOfEmployees = new ArrayList<>();

    /**
     * Display single employee
     *
     * @param emp - Employee to be displayed
     */
    public static void displayEmployee(Employee emp) {
        System.out.print(emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + " ");
        if (emp instanceof Manager) System.out.print("[MANAGER]");
        System.out.println();
    }

    /**
     * Display multiple employees
     *
     * @param listOfEmps - list to be displayed
     */
    public static void displayEmployees(List<Employee> listOfEmps) {
        for (Employee e : listOfEmps) {
            displayEmployee(e);
        }
    }

    public static void displayManager(Manager m) {
        System.out.printf("Manager:\t\t%s %s\n", m.getFirstName(), m.getLastName());
        System.out.printf("Department:\t\t%s\n", m.getDeptName());
        System.out.printf("# Employees:\t%d\n", m.getEmpList().size());
        for (Employee e : m.getEmpList()) {
            System.out.printf("%4d:\t%s %s\n", e.getEmpID(), e.getFirstName(), e.getLastName());
        }
    }

    /**
     * Method for interacting with Employee and Manager
     *
     * @param args - not used
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException, Manager.ManagerException {

        Manager mgr1 = new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING");

        Manager mgr2 = new Manager(15, "Spongebob", "Squarepants",
                000000201, HRDateUtils.strToDate("2015-09-01"), 200000, "HR");

        Employee emp =  new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000);

        Employee emp1 =  new Employee(10, "Robert", "Randolph", 121212121, HRDateUtils.strToDate("2016-10-01"), 75000);

        Employee emp2 =  new Employee(2, "Jimi", "Hendrix", 000000001, new Date(), 70000);

        Employee emp3 =  new Employee(12, "Blueberry", "Cheesecake", 987654321, HRDateUtils.strToDate("2012-08-29"), 63000);

        Employee emp4 =  new Employee(14, "Mickey", "Mouse", 020202020, HRDateUtils.strToDate("2011-11-21"), 73000);

        Employee emp5 =  new Employee(25, "Mike", "Wazowski", 100000000, new Date(), 70000);

        // Add employees and managers into the list of employees
        listOfEmployees.add(mgr1);
        listOfEmployees.add(mgr2);
        listOfEmployees.add(emp);
        listOfEmployees.add(emp1);
        listOfEmployees.add(emp2);
        listOfEmployees.add(emp3);
        listOfEmployees.add(emp4);
        listOfEmployees.add(emp5);

        System.out.println(mgr1);
        displayEmployee(mgr1);
        displayEmployees(listOfEmployees);

        // Assign employees to managers
        mgr1.addEmployee(emp);
        mgr1.addEmployee(emp1);
        mgr1.addEmployee(emp2);
        mgr2.addEmployee(emp3);
        mgr2.addEmployee(emp4);
        mgr2.addEmployee(emp5);

        // Display managers
        displayManager(mgr1);
        displayManager(mgr2);

    }
}
