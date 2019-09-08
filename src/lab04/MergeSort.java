/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2019
* Instructor: Prof. King
* Section: 9 am
*
* Name: Anh Kieu
* Date: 09/08/2019
*
* Lab / Assignment: lab04
*
* Description: Arrays and Switch
*
* *****************************************/

package lab04;
import java.util.Random;
import java.util.Arrays;

/**
 * Your program must automatically generate an array of random integers.
 * 2. You should have a constant defined inside the class that allows you to change the number of random
 * integers your program will generate.
 * 3. Be sure to print the array before and after sorting, only if you generated less than 50 numbers. The 50
 * should be a constant. Don't hard code it.
 * 4. You should validate that your array was sorted by printing SUCCESS or FAIL.
 */

public class MergeSort {
/**
 * Number of integers to generate
 */
static final int NUM_INTS = 10;

/**
 * Maximum integer value to use
 */
static final int MAX_INT_VALUE = 200;

/**
 * Max numbers to allow to be printed
 */
static final int MAX_PRINTABLE = 50;

/**
 * A main program that will generate <code>NUM_INTS</code> integers in an array between
 * 0 and <code>MAX_INT_VALUE</code>, sort them using {@link MergeSort}, and that show the
 * results
 *
 * @param args - not used
 */
public static void main(String[] args) {
  // Create a randomized array of integers
  int[] x = createRandomArray(NUM_INTS, MAX_INT_VALUE);
  if (NUM_INTS <= MAX_PRINTABLE)
    System.out.println("Array before sorting:\n" + Arrays.toString(x));

  // Call mergeSort to sort our data in place (i.e. sorted data is kept in x)
  mergeSort(x,0,NUM_INTS-1);
  if (NUM_INTS <= MAX_PRINTABLE)
    System.out.println("Array after sorting:\n" + Arrays.toString(x));

  // Validate - did we succeed?
  validateArrayIsSorted(x);
}

/**
 * Function that sorts array by Merge Sort method (divide and conquer)
 *
 * @param arr - array to be sorted
 * @param first - starting index of the sorted part
 * @param last - last index of the sorted part
 * @return randomly generated array
 */
public static int[] createRandomArray(int arr_length, int max_int) {
  int[] arr = new int[arr_length];
  Random rand = new Random();
  for (int i = 0; i < arr_length; i++) {
    arr[i] = rand.nextInt(max_int);
  }
  return arr;
}

/**
 * Function that sorts array by Merge Sort method (divide and conquer)
 *
 * @param arr - array to be validated
 * @return true if sorted false otherwise
 */
public static void validateArrayIsSorted(int[] arr) {
  for (int i = 0; i < arr.length-1; i++){
    if (arr[i] > arr[i+1]) System.out.println("FAIL");
  }
  System.out.println("SUCCEED");
}

/**
 * Function that sorts array by Merge Sort method (divide and conquer)
 *
 * @param arr - array to be sorted
 * @param first - starting index of the sorted part
 * @param last - last index of the sorted part
 */
public static void mergeSort(int[] arr, int first, int last) {
    if (first < last) {
      int mid = (last+first)/2;
      mergeSort(arr, first, mid);
      mergeSort(arr, mid+1, last);
      merge(arr, first, mid, last );
    }
}

/**
 * Function that merges 2 arrays in ascending order
 *
 * @param arr - The arr to re-merge
 * @param left - leftmost index of the array
 * @param right - rightmost index of the array
 */
public static void merge(int[] arr, int left, int mid, int right ) {
  int left_length = mid-left+1;
  int right_length = right - mid;
  int[] left_arr = Arrays.copyOf(Arrays.copyOfRange(arr, left, mid+1), left_length+1);
  int[] right_arr = Arrays.copyOf(Arrays.copyOfRange(arr, mid+1, right+1), right_length+1);
  left_arr[left_length] = Integer.MAX_VALUE;
  right_arr[right_length] = Integer.MAX_VALUE;
  int j = 0;
  int k = 0;
  for (int i = left; i <= right; i++) {
    if (left_arr[j] < right_arr[k]) {
      arr[i] = left_arr[j];
      j++;
    } else {
      arr[i] = right_arr[k];
      k++;
    }
  }
}
}
