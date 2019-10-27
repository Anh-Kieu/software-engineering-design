package lab12.tempconvertermvc;

import javafx.beans.property.SimpleBooleanProperty;

public class TempConverterModel {

    private SimpleBooleanProperty propDoFtoC;
    private SimpleBooleanProperty propDoCtoF;

    public boolean isPropDoFtoC() {
        return propDoFtoC.get();
    }

    public SimpleBooleanProperty propDoFtoCProperty() {
        return propDoFtoC;
    }

    public boolean isPropDoCtoF() {
        return propDoCtoF.get();
    }

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
