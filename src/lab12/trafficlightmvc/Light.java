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
 * Class: Light
 *
 * Description: Light
 *
 * ****************************************
 */

package lab12.trafficlightmvc;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Paint;

/**
 * Represent a single light that can be toggled
 */
public class Light {
    /** Property of the state of the light */
    private SimpleBooleanProperty isOnProp;
    /** Color when the light is on */
    private Paint colorOn;
    /** Color when the light is off */
    private Paint colorOff;

    /**
     * Get the on color of the light
     * @return colorOn
     */
    public Paint getColorOn() {
        return colorOn;
    }

    /**
     * Get the off color of the light
     * @return colorOff
     */
    public Paint getColorOff() {
        return colorOff;
    }

    /**
     * Get the color of the light
     * @return
     */
    public Paint getColor() {
        if (isOn()) return getColorOn();
        else return getColorOff();
    }


    public Light(Paint colorOn, Paint colorOff) {
        this.isOnProp = new SimpleBooleanProperty(false);
        this.colorOn = colorOn;
        this.colorOff = colorOff;
    }

    /**
     * Check if the light is on
     * @return
     */
    public boolean isOn() {
        return isOnProp.get();
    }

    /**
     * Change the state of the light
     */
    public void toggle() {
        isOnProp.set(!isOnProp.get());
    }

    /**
     * Get the property of the state of the light
     * @return SimpleBooleanProperty of true if it is on, false otherwise
     */
    public SimpleBooleanProperty isOnProperty() {
        return isOnProp;
    }


    /**
     * Keep the light turn on for some ms
     * @param ms the period of time
     */
    public void turnOnForMs(long ms) {
        Runnable r = () -> {
            try {
                if (isOn()) return;
                toggle();
                Thread.sleep(ms);
            } catch (InterruptedException e) {
            } finally {
                if (isOn()) toggle();
                System.out.println("???");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}

