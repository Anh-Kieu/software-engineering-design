/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Anh Kieu
 * Section: 9am
 * Date: 10/26/2019
 * Time: 6:05 PM
 *
 * Project: csci205_labs
 * Package: lab12
 * Class: TempConverterModel
 *
 * Description: TempConverter GUI - Model
 *
 * ****************************************
 */

package lab12.tempconvertermvc;


import javafx.beans.property.SimpleBooleanProperty;

/**
 * Model class for tempconverter GUI
 */
public class TempConverterModel {

    private SimpleBooleanProperty propDoFtoC;
    private SimpleBooleanProperty propDoCtoF;

    /**
     * Check if property of FtoC is true
     * @return true if it is FtoC, false otherwise
     */
    public boolean isPropDoFtoC() {
        return propDoFtoC.get();
    }

    /**
     * Get the property of FtoC
     * @return Property of the state of FtoC
     */
    public SimpleBooleanProperty propDoFtoCProperty() {
        return propDoFtoC;
    }

    /**
     * Check if property of CtoF is true
     * @return true if it is CtoF, false otherwise
     */
    public boolean isPropDoCtoF() {
        return propDoCtoF.get();
    }

    /**
     * Get the property of CtoF
     * @return Property of the state of CtoF
     */
    public SimpleBooleanProperty propDoCtoFProperty() {
        return propDoCtoF;
    }

    TempConverterModel() {
        this.propDoFtoC = new SimpleBooleanProperty(true);
        this.propDoCtoF = new SimpleBooleanProperty(false);
    }

    /**
     * Convert F to C
     * @param fTempString temperature in F
     * @return return string representing temp in C
     */
    public String convertFtoC(String fTempString) {
        double fTemp = Double.parseDouble(fTempString);
        double cTemp = (fTemp - 32) / 1.8;
        String cTempString = String.format("%.2f Celcius", cTemp);
        return cTempString;
    }

    /**
     * Convert C to F
     * @param cTempString temperature in C
     * @return return string representing temp in F
     */
    public String convertCtoF(String cTempString) {
        double cTemp = Double.parseDouble(cTempString);
        double fTemp = (cTemp*1.8)+32;
        String fTempString = String.format("%.2f Fahrenheit", fTemp);
        return fTempString;
    }

    /**
     * Convert the string based on the condition
     * @param temp string to convert
     * @return converted string
     */
    public String stringConvert(String temp) {
        if (isPropDoCtoF()) {
            return this.convertCtoF(temp);
        }
        else if (isPropDoFtoC()) {
            return this.convertFtoC(temp);
        } else {
            return temp;
        }
    }
}
