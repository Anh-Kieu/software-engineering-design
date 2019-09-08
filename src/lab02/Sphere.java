/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2019
* Instructor: Prof. King
* Section: 9 am
*
* Name: Anh Kieu
* Date: 08/28/2019
*
* Lab / Assignment: lab02
*
* Description: Computing the volume of a sphere
*
* *****************************************/

package lab02;

import java.lang.Math;
import java.util.Scanner;

public class Sphere {
  public static void main(String[] args) {

    // Prompt user for input
    System.out.printf("Enter the radius of a sphere: ");

    // Create variable
    Scanner in = new Scanner(System.in);
    double radius = in.nextDouble();

    // Calculate volume
    double volume = 4 * Math.pow(radius, 3) * Math.PI / 3;

    // Output result
    System.out.printf("The volume is: %.2f\n", volume);
    System.out.printf("Rounded to nearest integer: %d\n", Math.round(volume));
  }
}
