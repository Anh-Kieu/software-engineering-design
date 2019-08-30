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
        while (true) {
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

          // Output the additional comment
          if (fahTemp <= 32) {
            System.out.println("Brrr... it is FREEZING out!");
          } else if (32 < fahTemp && fahTemp <= 60) {
            System.out.println("It's a bit cool out");
          } else if (60 < fahTemp && fahTemp <= 85) {
            System.out.println("It's comfortably warm");
          } else {
            System.out.println("It's HOT! I need A/C!");
          }

          // Prompt user for another try:
          System.out.printf("Try again? (y|n): ");
          String again = in.next();

          // Handle break
          if (again.equalsIgnoreCase("n"))
            break;
        }
        System.out.println("Goodbye!");
    }
}
