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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * A basic representation for an Employee to be stored in an HR database system
 *
 * @author Brian King
 */
public class Employee {

    /** Our date formatter to ensure we have a common date */
    private static SimpleDateFormat empDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    /** Employee id */
    private int empID;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Social Security number */
    private int ssNum;

    /** Date employee was hired */
    private Date hireDate;

    /** Current salary of the employee */
    private double salary;

    /** Collection of unique Employee IDs generated/assigned */
    private static HashSet<Integer> setofAssignedIDs = new HashSet<>();

    /**
     * Explicit constructor to create new employee
     *
     * @param empID     Employee id
     * @param firstName First name
     * @param lastName  Last name
     * @param ssNum     Social Security Number
     * @param hireDate  Hire date (as {@link Date} object
     * @param salary    Current employee salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary) {
        if (Employee.setofAssignedIDs.contains(empID) || empID <= 0) empID = generateID();
        this.empID = empID;
        Employee.setofAssignedIDs.add(empID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    /**
     * @return the employee id
     */
    public int getEmpID() { return empID; }

    /**
     * @return employee first name
     */
    public String getFirstName() { return firstName; }

    /**
     * @return Last name
     */
    public String getLastName() { return lastName; }

    /**
     * @return Social Security number
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * @return {@link Date} employee was hired
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @return current employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Generate new ID for employees
     *
     * @return new ID
     */
    private static Integer generateID() {
        Integer element = 1;
        while (Employee.setofAssignedIDs.contains(element)) {
            element += 1;
        }
        return element;
    }

    /**
     * Helper method to parse a date string into a date object. This is
     * really here just to show how to deal with an exception that may
     * be thrown in a method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormatter.parse(sDate);
    }

    /**
     * Helper method to parse a date into a string.
     *
     * @param dString - the Date
     * @return String representing date
     */
    public static String dateToStr(Date dString) {
        return empDateFormatter.format(dString);
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    /**
     * Check if the objects are equal
     *
     * @param obj - obj to compare
     * @return true if equal, otherwise false (only compare Employee ssNum)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass() ) return false;
        else {
            return ssNum == ((Employee) obj).getSsNum();
        }
    }
}
