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
 * Description: Web scanner
 *
 * ****************************************
 */

package lab11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Connect to a web server and reads the specified web page. Must scan the input for a specified HTML tag
 * then output the result to a file
 */
public class ScanWebPage {

    /**
     * Validate/catch error the web address
     *
     * @param address
     * @return BufferedInputStream object of the WebPage
     */
    public static Scanner Validate(String address) {
        try {
            URL locator = new URL(address);
            Scanner in = new Scanner(locator.openStream());
            System.out.println("Connection established");
            return in;
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL! Please try again!");
            return null;
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host! Please try again!");
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("Link not Found! Please try again!");
            return null;
        } catch (IOException e) {
            System.out.println("Nonexist input of URL! Please try again!");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Link caused error (Check syntax)! Please try again");
            return null;
        }
    }

    /**
     * User interface of web address prompting and handling
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Store the verified link
        Scanner link = ScanInputLink(scan);
        // Store tag input
        String tag = ScanTag(scan);
        // Handling output file
        HandlingOutputFile(scan, link, tag);


    }

    /**
     * Prompting for output file and writing to the file
     *
     * @param scan Scanner object
     * @param link Address link
     * @param tag Tag to find
     * @throws FileNotFoundException
     */
    public static void HandlingOutputFile(Scanner scan, Scanner link, String tag) throws FileNotFoundException {
        System.out.print("Enter the output file name, or press ENTER to print to the screen: ");
        String filename = scan.next();
        if (!tag.equals("")) {
            PrintOneTagOutput(link, tag, filename);
            System.out.println("Goodbye!");
        } else {
            Map<String, Integer> tags = new HashMap<>();
            Pattern pattern = Pattern.compile("<\\w+>|<\\w+\\s+[^/>]*>");
            String sMatch;
            while(true) {
                if ((sMatch = link.findWithinHorizon(pattern, 0)) == null) break;
                String tagName = sMatch.replaceAll("<[^>]*>", "");
                if (tags.containsKey(tagName)) {
                    int prevCount = tags.get(tagName);
                    tags.put(tagName, prevCount + 1);
                } else {
                    tags.put(tagName, 1);
                }
            }
            // sort by name
            List sortedKeys = new ArrayList(tags.keySet());
            Collections.sort(sortedKeys);
            for (Object name : sortedKeys) {
                System.out.println(name + ": " + tags.get(name));
            }
            // sort by freq
        }
    }

    /**
     * Write to file or screen the output of finding a specific tag
     *
     * @param link address link
     * @param tag tag to find
     * @param filename name of the file (could be null, that means print to screen)
     * @throws FileNotFoundException
     */
    private static void PrintOneTagOutput(Scanner link, String tag, String filename) throws FileNotFoundException {
        if (!filename.equals("")) {
            PrintWriter out = new PrintWriter(filename);
            String sMatch;
            int count = 0;
            Pattern pattern = Pattern.compile("<" + tag + ">" + "|" + tag + "\\s+(\\w+)=\"([^\"]+)\"");
            while (true) {
                if ((sMatch = link.findWithinHorizon(pattern, 0)) == null) break;
                out.printf("Found: %s\n", sMatch);
                MatchResult match = link.match();
                count++;
            }
            out.println(count);
            out.close();
            System.out.printf("Wrote %d %s tags to %s\n", count, tag, filename);
        } else {
            String sMatch;
            int count = 0;
            Pattern pattern = Pattern.compile("<" + tag + ">" + "|" + tag + "\\s+(\\w+)=\"([^\"]+)\"");
            while (true) {
                if ((sMatch = link.findWithinHorizon(pattern, 0)) == null) break;
                System.out.printf("Found: %s\n", sMatch);
                MatchResult match = link.match();
                System.out.println("Parameter: " + match.group(1));
                System.out.println("Value: " + match.group(2));
                count++;
            }
        }
    }

    /**
     * Scan tag from user
     *
     * @param scan Scanner object
     * @return tag string
     */
    private static String ScanTag(Scanner scan) {
        System.out.println("Enter a HTML tag to scan for: ");
        String tag = scan.next();
        return tag;
    }

    /**
     * Prompt user for the address, makes them try again if the address is invalid
     *
     * @return BufferedInputStream of the address link
     */
    private static Scanner ScanInputLink(Scanner scan) {
        // Indicate the validity of the input for the while loop, if invalid, keep asking
        boolean invalid = true;
        Scanner link = null;
        // scan user input
        while (invalid) {
            System.out.print("Enter your link here: ");
            String address = scan.next();
            link = Validate(address);
            if (link != null) invalid = false;
        }
        return link;
    }
}











