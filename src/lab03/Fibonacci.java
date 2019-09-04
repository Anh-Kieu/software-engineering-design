/*
 * TODO -- Place your banner here!
 */
package lab03;

import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2019-fall
 *
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        if (n == 1 || n == 2) return 1;
        else {
          return recFib(n-1) + recFib(n-2);
        }
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        if (n == 1 || n == 2) return 1;
        int n1 = 1;
        int n2 = 1;
        int f = 0;
        while (n>2) {
          f = n1 + n2;
          n1 = n2;
          n2 = f;
          n--;
        }
        return f;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("Fibonacci number to compute:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println("Recursive fib: " + recFib(n));
        System.out.println("Non-recursive fib: " + nonRecFib(n));
    }

}
