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

package lab10;

import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Anh Kieu
 */
public class HRDBSystem {


    /** List of employees */
    private static ArrayList<Employee> empList;

    /** List of manager */
    private static ArrayList<Manager> mgrList;

    /** List of contractor */
    private static ArrayList<Contractor> contractors;

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

        initManagers();
        initEmployees();
        initContractors();

        assignEmployeesToManagers();

        System.out.println("--- OUR COMPLETE LIST --- (before sorted)");
        displayEmployees(empList);

        System.out.println();

        // Display a manager
        displayManager(mgrList.get(0));

        System.out.println();

        // Exercise 8
        testAccount();

        // sorting by last name
        sortingByLastName();

        // sorting by reverse id
        sortingByReverseId();


    }

    private static void sortingByLastName() {
        System.out.println();
        System.out.println("Sort by last name");
        Collections.sort(empList, (e1, e2) -> e1.getLastName().compareToIgnoreCase(e2.getLastName()));
        displayEmployees(empList);
    }

    private static void sortingByReverseId() {
        System.out.println();
        System.out.println("Sort by reverse ID");
        Collections.sort(empList, Comparator.comparingInt(Employee::getEmpID));
        Collections.reverse(empList);
        displayEmployees(empList);
    }

    private static void testAccount() {
        // Create an account
        Account acc = new Account(4000.0);
        System.out.println(acc);

        // Test out a couple of payments, intentionally throwing exception with the 2nd payment
        try {
            System.out.println("TEST: Printing a check to employee id: " + empList.get(3).getEmpID());

            // 40 hours + 10 hours overtime
            acc.processCheck(empList.get(3), 50, System.out);
            System.out.println("TEST: Printing a check to contractor id: " + contractors.get(0).getId());
            acc.processCheck(contractors.get(0), 100, System.out);
        } catch (Account.InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Verify that funds were debited
        System.out.println(acc);
    }

    private static void assignEmployeesToManagers() throws Manager.ManagerException {
        // Assign employees to managers

        for (int i = 0; i < empList.size(); i++) {
            if (i % 2 == 0) mgrList.get(0).addEmployee(empList.get(i));
            else mgrList.get(1).addEmployee(empList.get(i));
        }
    }

    private static void initContractors() {
        contractors = new ArrayList<>();
        contractors.add(new Contractor(73, "Hazel", "Nut", 342942039, 30.00));
        contractors.add(new Contractor(90, "Chicken", "Parmesan", 342942039, 30.00));
    }

    private static void initManagers() throws Manager.ManagerException, ParseException {
        mgrList = new ArrayList<>();
        mgrList.add(new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING"));

        mgrList.add(new Manager(15, "Spongebob", "Squarepants",
                000000201, HRDateUtils.strToDate("2015-09-01"), 200000, "HR"));
    }

    private static void initEmployees() throws ParseException {
        empList = new ArrayList<>();
        // Add employees and managers into the list of employees
        empList.add(new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000));
        empList.add(new Employee(10, "Robert", "Randolph", 121212121, HRDateUtils.strToDate("2016-10-01"), 75000));
        empList.add(new Employee(2, "Jimi", "Hendrix", 000000001, new Date(), 70000));
        empList.add(new Employee(12, "Blueberry", "Cheesecake", 987654321, HRDateUtils.strToDate("2012-08-29"), 63000));
        empList.add(new Employee(14, "Mickey", "Mouse", 020202020, HRDateUtils.strToDate("2011-11-21"), 73000));
        empList.add(new Employee(25, "Mike", "Wazowski", 100000000, new Date(), 70000));
    }
}
