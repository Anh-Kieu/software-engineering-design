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

        Manager mgrDean = new Manager(0, "Pat", "Mather",
                101010101, HRDateUtils.strToDate("2015-07-01"), 174000, "ENGINEERING");
        System.out.println(mgrDean);

        Employee emp =  new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2015-08-20"), 60000);
        System.out.println(emp);

        Employee emp1 =  new Employee(10, "Robert", "Randolph", 121212121, HRDateUtils.strToDate("2015-12-01"), 75000);
        System.out.println(emp1);

        Employee emp2 =  new Employee(2, "Jimi", "Hendrix", 000000001, new Date(), 70000);
        System.out.println(emp2);

    }
}
