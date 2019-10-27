package lab12.trafficlightmvc;

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
    public Paint getColorOn() {
        return colorOn;
    }

    public Paint getColorOff() {
        return colorOff;
    }

}