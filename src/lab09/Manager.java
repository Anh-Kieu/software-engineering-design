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

import java.util.Date;

public class Manager extends Employee {

    /** Department of manager */
    private String deptName;


    /**
     * A
     * @param empID Employee ID
     * @param firstName First name of the employee
     * @param lastName Last name of the employee
     * @param ssNum SS of the employee
     * @param hireDate the date of hiring
     * @param salary the salary of employee
     * @param deptName department the manager is in charge of
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
    }

    /**
     * Get the department name
     *
     * @return the name of the department
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set department name
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * Represent manager object in String
     *
     * @return String representation of Manager
     */
    @Override
    public String toString() {
        return super.toString() + ", MANAGER, " + getDeptName();
    }
}

