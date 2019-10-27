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
 * Class: TrafficLightModel
 *
 * Description: Traffic Light GUI - Model
 *
 * ****************************************
 */

package lab12.trafficlightmvc;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

/**
 * Represent the traffic light
 */
public class TrafficLightModel {
    /** Array of traffic lights */
    private ArrayList<Light> lights;
    /** Property for auto-off */
    private SimpleBooleanProperty isAuto;

    public TrafficLightModel() {
        lights = new ArrayList<>();
        for (LightEnum lightEnum : LightEnum.values()) {
            lights.add(new Light(lightEnum.getColorOn(), lightEnum.getColorOff()));
        }
        this.isAuto = new SimpleBooleanProperty(false);
    }

    /**
     * Get the light of some color (?)
     * @param pos
     * @return
     */
    public Light getLight(LightEnum pos) {
        return getLight(pos.ordinal());
    }

    /**
     * Get the light at an index
     * @param i - index
     * @return Light light
     */
    public Light getLight(int i) {
        return lights.get(i);
    }

    /**
     * Get the array of lights
     * @return arraylist of lights
     */
    public ArrayList<Light> getLights() { return lights; }

    /**
     * Check if auto-off is enabled
     * @return true if it is set, false otherwise
     */
    public boolean isAutoEnabled() { return isAuto.get(); }

    /**
     * Return the property of auto-off
     * @return
     */
    public SimpleBooleanProperty isAutoProperty() { return isAuto; }
}