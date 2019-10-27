package lab12.trafficlightmvc;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Paint;

/**
 * Represent a single light that can be toggled
 */
public class Light {
    private SimpleBooleanProperty isOnProp;

    public Paint getColorOn() {
        return colorOn;
    }

    public Paint getColorOff() {
        return colorOff;
    }

    public Paint getColor() {
        if (isOn()) return getColorOn();
        else return getColorOff();
    }

    private Paint colorOn;
    private Paint colorOff;

    public Light(Paint colorOn, Paint colorOff) {
        this.isOnProp = new SimpleBooleanProperty(false);
        this.colorOn = colorOn;
        this.colorOff = colorOff;
    }

    public boolean isOn() {
        return isOnProp.get();
    }

    public void toggle() {
        isOnProp.set(!isOnProp.get());
    }

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

