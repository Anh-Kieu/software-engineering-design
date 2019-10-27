package lab12.trafficlightmvc;
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
 * Class: LightEnum
 *
 * Description: Light Enumeration
 *
 * ****************************************
 */

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Enumeration for different states of a light
 */
public enum LightEnum {

    RED(Color.RED, Color.DARKGRAY),
    YELLOW(Color.YELLOW, Color.DARKGRAY),
    GREEN(Color.LIMEGREEN, Color.DARKGRAY);
    private Paint colorOn;
    private Paint colorOff;

    private LightEnum(Paint colorOn, Paint colorOff) {
        this.colorOn = colorOn;
        this.colorOff = colorOff;
    }

    /**
     * Get the on color
     * @return colorOn
     */
    public Paint getColorOn() {
        return colorOn;
    }

    /**
     * Get the off color
     * @return colorOff
     */
    public Paint getColorOff() {
        return colorOff;
    }

}