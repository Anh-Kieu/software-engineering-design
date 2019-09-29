/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/28/2019
 * Time: 5:44 PM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Contractor
 *
 * Description:
 *
 * ****************************************
 */

package lab10;

import java.util.Date;

public class Contractor implements Payable{
    /**
     * Calculate pay based on the number of working hours
     *
     * @param numHrs - number of working hour
     * @return the payment
     */
    @Override
    public double calculatePay(double numHrs) {
        // do not get paid even if overtime
        return numHrs*hourlyRate;
    }

    /**
     * Get the receiver of the payment
     *
     * @return The receiver
     */
    @Override
    public String getPayTo() {
        return "Name : " + firstName + " " + lastName;
    }

    /**
     * Get the paymemt memo
     *
     * @return the memo
     */
    @Override
    public String getPayMemo() {
        return "Contractor ID: " + id + ", Pay Date: " + HRDateUtils.dateToStr(new Date());
    }


    /** Contractor id */
    private int id;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Social Security number */
    private int ssNum;

    /** Hourly Rate */
    private double hourlyRate;


    public Contractor(int id, String first, String last, int ssNum, double hourlyRate) {
        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    /** Getter and setter for the attribute */
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getSsNum() { return ssNum; }

    public void setSsNum(int ssNum) { this.ssNum = ssNum; }

    public double getHourlyRate() { return hourlyRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate;   }

    @Override
    /**
     * Generate a String representation of Contractor
     * @return String of Contractor
     */
    public String toString() {
        String s = "CONTRACTOR: " + this.id + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += String.format(",%.2f", this.hourlyRate);
        return s;
    }
}














