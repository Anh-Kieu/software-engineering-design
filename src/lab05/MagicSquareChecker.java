/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/10/2019
 * Time: 2:07 PM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: MagicSquareChecker
 *
 * Description:
 *
 * ****************************************
 */

package lab05;

import java.util.Arrays;

/**
 * A class that checks if the square matrix is a magic square, meaning that the sum of each row is the same as the sum
 * of each column, which is also the same value of both diagonals and the entries of matrix are unique.
 *
 * @author Anh Kieu - aqk001
 */
public class MagicSquareChecker {

    // 2 hard-code matrices
    // Good 4x4 square
    static final int[][] MAGIC_SQUARE_4_GOOD = {
            { 16, 3, 2, 13 },
            { 5, 10, 11, 8 },
            { 9, 6, 7, 12 },
            { 4, 15, 14, 1 }
    };
    // Bad squares (repeated entries or not equal sums)

    // repeated entries
    static final int[][] REPEATED_ENTRY = {
            { 16, 2, 2, 13 },
            { 5, 10, 11, 8 },
            { 9, 6, 7, 12 },
            { 4, 15, 14, 1 }
    };

    // not equal sums
    static final int[][] NOT_EQUAL_SUM = {
            { 16, 3, 2, 13, 24 },
            { 5, 10, 11, 8, 23 },
            { 9, 6, 7, 12, 21 },
            { 4, 15, 14, 1, 20 },
            { 19, 18, 0, 17 , 5},
    };

    // not square
    static final int[][] NOT_SQUARE = {
            { 16, 3, 2},
            { 5, 10, 11},
    };

    /**
     * Execute the steps in Magic Square Checker
     * @param args
     */
    public static void main(String[] args) {

        int[][] matrixValidated = MAGIC_SQUARE_4_GOOD;

        // Print out the matrix being validated
        System.out.println("Checking square:");
        printMatrix(matrixValidated);

        // Check constraints
        // Check square
        if (!checkSquare(matrixValidated))
            System.out.println("FAIL as matrix is not square");
        else if (!checkUnique(matrixValidated)) System.out.println("FAIL as repeated entries"); // Check entries
        else if (!checkSum(matrixValidated)) System.out.println("FAIL as not equal sum");       // Check sums
        else
        // The matrix passes the test
        System.out.println("SUCCESS");
    }

    /**
     * Print the matrix as string
     *
     * @param matrix - 2d array to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String row = "";
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5s", matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * Check if the matrix is square
     *
     * @param matrix - 2d array of int to validate
     * @return true if it is square, false otherwise
     */
    public static boolean checkSquare(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    /**
     * Check if the entries are unique
     *
     * @param matrix - 2d array of int to validate
     * @return true if unique entries, else false
     */
    public static boolean checkUnique(int[][] matrix) {
        int[] list_of_number = new int[matrix.length*matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list_of_number[i*matrix[0].length + j] = matrix[i][j];
            }
        }
        Arrays.sort(list_of_number);
        for (int i = 0; i < matrix.length - 1; i++) {
            if (list_of_number[i] == list_of_number[i+1]) {
                System.out.println("Number " + list_of_number[i] + " has too many values!");
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the sums are equal
     *
     * @param matrix - 2d array of int to check
     * @return true if the sums are equal, false otherwise
     */
    public static boolean checkSum(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            // Check row equal
            if (sumRow(matrix, i) != sumRow(matrix, i + 1)) return false;
            // Check col equal
            if (sumColumn(matrix, i) != sumColumn(matrix, i + 1)) return false;
        }
        // Check diagonal
        if (sumLTRDiagonal(matrix) != sumRTLDiagonal(matrix)) return false;

        // Check col, sum, diagonal
        if (!(sumRow(matrix, 0) == sumColumn(matrix, 0) && sumRow(matrix, 0) == sumRTLDiagonal(matrix))) return false;
        return true;
    }

    /**
     * Compute sum of row <code>row</code> in the <code>matrix</code>
     *
     * @param matrix - 2d array of int to calcuate
     * @param row - row number
     * @return the sum of that row
     */
    public static int sumRow(int[][] matrix, int row) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[row][i];
        }
        return sum;
    }

    /**
     * Compute the sum of column <code>col</code> in the <code>matrix</code>
     *
     * @param matrix - 2d matrix to calculate
     * @param col - column number
     * @return the sum
     */
    public static int sumColumn(int[][] matrix, int col) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[i][col];
        }
        return sum;
    }

    /**
     * Compute the sum of the left to right diagonal
     *
     * @param matrix - 2d array to compute
     * @return the sum
     */
    public static int sumLTRDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][i];
        }
        return sum;
    }

    /**
     * Compute the sum of the right to left diagonal
     *
     * @param matrix - 2d array to compute
     * @return the sum
     */
    public static int sumRTLDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[matrix[0].length - 1 - i][i];
        }
        return sum;
    }
}