/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Anh Kieu
 * Section: 9am
 * Date: 10/6/2019
 * Time: 2:01 PM
 *
 * Project: csci205_labs
 * Package: lab11
 * Class: ScanWebPage
 *
 * Description: Web scanner Test
 *
 * ****************************************
 */

package lab11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

class ScanWebPageTest {

    /** For checking the output stream */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut( new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    /**
     * Test of Validate method throws IllegalArgumentException due to syntax
     */
    @Test
    public void testSyntax() {
        String address = "https:\\www.bucknell.edu";
        ScanWebPage.Validate(address);
        assertEquals("Link caused error (Check syntax)! Please try again" + System.getProperty("line.separator"), outContent.toString());

    }

    /**
     * Test of Validate method throws UnknownHostException.
     */
    @Test
    public void testUnknownHost() {
        String address = "https://www.bucknell.ed";
        ScanWebPage.Validate(address);
        assertEquals("Unknown Host! Please try again!" + System.getProperty("line.separator"), outContent.toString());
    }

    /**
     * Test of Validate method, of class ScanWebPage.
     */
    @Test
    public void testMalformedURL() {
        String address = "www.bucknell.edu";
        ScanWebPage.Validate(address);
        assertEquals("Malformed URL! Please try again!" + System.getProperty("line.separator"), outContent.toString());
    }

    /**
     * Test of Validate method, of class ScanWebPage.
     */
    @Test
    public void testFileNotFound() {
        String address = "https://www.bucknell.edu/blahlnonlno.html";
        ScanWebPage.Validate(address);
        assertEquals("Link not Found! Please try again!" + System.getProperty("line.separator"), outContent.toString());
    }

    /**
     * Test of Validate method, of class ScanWebPage.
     */
    @Test
    public void testValidate() {
        String address = "https://www.bucknell.edu";
        ScanWebPage.Validate(address);
        assertEquals("Connection established" + System.getProperty("line.separator"), outContent.toString());
    }

}