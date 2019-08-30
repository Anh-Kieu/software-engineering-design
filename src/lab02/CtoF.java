/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: Anh Kieu
 * Date: 08/29/1999
 *
 * Lab: Lab02,
 *
 * @author Brian King, 2012-Fall
 *
 * Description:
 * A simple program to ask the user for a temperature in Celsius, and converts
 * it to Fahrenheit.
 * *****************************************
 */

package lab02;

import java.util.Scanner;

public class CtoF {
    public static void main(String[] args) {

        // Prompt user for a Celsius temp
        System.out.printf("Enter a temperature in Celsius: ");

        // Create the Scanner object, attached to console input
        Scanner in = new Scanner(System.in);

        // Read and store the Celsius temp
        int celTemp = in.nextInt();

        // Convert the temp to Fahrenheit
        double fahTemp = ((double) celTemp * 9) / 5 + 32;

        // Output the results with correct formatting, one significant digit
        System.out.printf("%d C = %.1f F\n", celTemp, fahTemp);
    }
}
