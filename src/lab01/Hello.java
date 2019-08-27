/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2019
* Instructor: Prof. King
* Section: 9 am
*
* Name: Anh Kieu
* Date: 08/27/2019
*
* Lab / Assignment: lab01
*
* Description: Getting Started - Hello World program
*
* *****************************************/

package lab01;

public class Hello
{
  public static void main( String[] args ) {
    double startTime = System.nanoTime();
    System.out.println("Programming is not a spectator sport!");
    double elapsedNanos = (System.nanoTime() - startTime)/1000000;
    System.out.printf("Time to execute : %.4f ms\n", elapsedNanos);
    System.exit(0);
  }
}
