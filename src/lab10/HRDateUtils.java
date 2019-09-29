/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/26/2019
 * Time: 12:57 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: HRDateUtils
 *
 * Description:
 *
 * ****************************************
 */

package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class HRDateUtils {
    /** Our date formatter to ensure we have a common date */
    static SimpleDateFormat empDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Helper method to parse a date string into a date object. This is
     * really here just to show how to deal with an exception that may
     * be thrown in a method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    static Date strToDate(String sDate) throws ParseException {
        return empDateFormatter.parse(sDate);
    }

    /**
     * Helper method to parse a date into a string.
     *
     * @param dString - the Date
     * @return String representing date
     */
    static String dateToStr(Date dString) {
        return empDateFormatter.format(dString);
    }
}