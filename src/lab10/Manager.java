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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {

    /**
     *  Enumeration for department
     */
    enum DepartmentName {
        ENGINEERING,
        HR,
        ADMIN,
        STAFF,
        OTHER;
    }

    /**
     * Checked exception representing any issues that might arise from the Manager class
     */
    class ManagerException extends Exception{
        public ManagerException(String message) { super(message); }
    }

    /** Department of manager */
    private DepartmentName deptName;

    /** List of employee */
    private List<Employee> empList = new ArrayList<>();

    /**
     * A
     * @param empID Employee ID
     * @param firstName First name of the employee
     * @param lastName Last name of the employee
     * @param ssNum SS of the employee
     * @param hireDate the date of hiring
     * @param salary the salary of employee
     * @param deptName {@link DepartmentName} department the manager is in charge of
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary, DepartmentName deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
        this.empList = empList;
    }

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
    public Manager(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary, String deptName) throws ManagerException {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        try {
            this.deptName = DepartmentName.valueOf(deptName);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("Invalid deptName: " + deptName);
        }
    }

    /**
     * Add employee to the manager's employee list
     * @param e
     */
    public void addEmployee(Employee e) throws ManagerException {
        if (empList.contains(e)) throw new ManagerException("Employee is already in the list");
        empList.add(e);
    }

    /**
     * Get the list of employee
     *
     * @return
     */
    public List<Employee> getEmpList() {
        return empList;
    }

    public void removeEmployee(Employee e) throws ManagerException {
        if (!empList.contains(e)){
            throw new ManagerException("Employee does not exist");
        }
        empList.remove(e);
    }

    /**
     * Get the department name
     *
     * @return the name of the department
     */
    public DepartmentName getDeptName() {
        return deptName;
    }

    /**
     * Set department name
     * @param deptName
     */
    public void setDeptName(DepartmentName deptName) {
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

