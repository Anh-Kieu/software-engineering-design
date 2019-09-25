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
import java.util.Date;

/**
 *
 * @author Anh Kieu
 */
public class HRDBSystem {

    public static void main(String[] args) throws ParseException {
        // Create myself
        Employee emp =  new Employee(0, "Anh", "Kieu", 123456789, new Date(), 60000);
        System.out.println(emp);

        // Give myself a raise
        emp.raiseSalary(10000);
        System.out.println(emp);

        // Correct name
        emp.changeName("Meh", "Maid");
        System.out.println(emp);

        Manager mgrDean = new Manager(1, "Pat", "Mather",
                987654321, Employee.parseHireDate("2015-Jan-01"), 174000, "ENGINEERING");
        System.out.println(mgrDean);

    }
}
