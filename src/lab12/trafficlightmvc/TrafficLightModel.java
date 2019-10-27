package lab12.trafficlightmvc;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

/**
 * Represent the traffic light
 */
public class TrafficLightModel {
    private ArrayList<Light> lights;
    private SimpleBooleanProperty isAuto;
    public TrafficLightModel() {
        lights = new ArrayList<>();
        for (LightEnum lightEnum : LightEnum.values()) {
            lights.add(new Light(lightEnum.getColorOn(), lightEnum.getColorOff()));
        }
        this.isAuto = new SimpleBooleanProperty(false);
    }
    public Light getLight(LightEnum pos) {
        return getLight(pos.ordinal());
    }
    public Light getLight(int i) {
        return lights.get(i);
    }
    public ArrayList<Light> getLights() { return lights; }
    public boolean isAutoEnabled() { return isAuto.get(); }
    public SimpleBooleanProperty isAutoProperty() { return isAuto; }
}