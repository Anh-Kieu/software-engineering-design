/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2019
* Instructor: Prof. King
* Section: 9 am
*
* Name: Anh Kieu
* Date: 08/27/2019
*
* Lab / Assignment: lab04
*
* Description: Arrays and Switch
*
* *****************************************/

package lab04;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * A simple calculator program
 *
 */
public class Calculator {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String option = "y";
    double op1 = 0;
    double op2 = 0;
    String operator = "";
    do {
    System.out.println("Welcome to the Calculator");
    System.out.println("Enter expressions with two numeric operands and a single operator from +, -, *, /, %, or ^");
    System.out.printf("Enter a simple arithmetic expression with spacing: ");
    if (in.hasNextDouble() == false) System.out.println("ERROR: Cannot parse operand 1");
    else {
      op1 = in.nextInt();
      if (!(in.hasNext("\\+") || in.hasNext("\\-") || in.hasNext("\\*") || in.hasNext("\\/") || in.hasNext("\\%") || in.hasNext("\\^"))) System.out.println("ERROR: Cannot parse operator");
      else {
        operator = in.next();
        if (in.hasNextDouble() == false) System.out.println("ERROR: Cannot parse operand 2");
        else {
          op2 = in.nextDouble();
        }
      }
    }
    String pattern = "###,###,###.##";
    DecimalFormat form = new DecimalFormat(pattern);
    // calculator
    switch(operator) {
      case "+":
        System.out.println("The sum is " + form.format(op1 + op2));
        break;
      case "-":
        System.out.println("The difference is " + form.format(op1 - op2));
        break;
      case "*":
        System.out.println("The product is " + form.format(op1 * op2));
        break;
      case "/":
        System.out.println("The quotient is " + form.format(op1 / op2));
        break;
      case "%":
        System.out.println("The module is " + form.format(op1 % op2));
        break;
      case "^":
        System.out.println("The power is " + form.format(Math.pow(op1, op2)));
        break;
    }
    System.out.printf("Try again? (y|n) ");
    option = in.next();
  } while (option.equalsIgnoreCase("y"));
  }
}
