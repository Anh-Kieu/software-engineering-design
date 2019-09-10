/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/10/2019
 * Time: 12:40 PM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: HelloMain
 *
 * Description:
 *
 * ****************************************
 */

package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A Hello Main class
 *
 * @author Anh Kieu - aqk001
 */
public class HelloMain {

    public static final int NUM_INTS = 10;

    /**
     * Main method for the program
     *
     * @param args Command line arguments that are unused in this program
     */
    public static void main(String[] args) {
        System.out.print("Hello. What is your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.println("A Personal Message for " + name);
        System.out.println("For beautiful eyes, look for the good in others; for beautiful lips, speak only words of kindness; and for poise, walk with the knowledge that you are never alone.");
        System.out.println("-- Audrey Hepburn");

        // Test debug
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(x));
    }
}