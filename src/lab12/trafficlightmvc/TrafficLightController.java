package lab12.trafficlightmvc;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class TrafficLightController {

    private TrafficLightView theView;
    private TrafficLightModel theModel;

    public TrafficLightController(TrafficLightModel model, TrafficLightView view) {
        this.theModel = model;
        this.theView = view;
        theModel.isAutoProperty().bind(theView.getCheckboxAutoOff().selectedProperty());

        NumberBinding radiusBinding = theView.getRoot().heightProperty().divide(6).add(-15);
        for (Circle c: theView.getLights()) {
            c.radiusProperty().bind(radiusBinding);
        }
        for (int i =0; i < theView.getLights().size(); i++) {
            Light l = theModel.getLights().get(i);
            Circle c = theView.getLights().get(i);
            c.fillProperty().bind(Bindings.when(l.isOnProperty()).then(l.getColorOn()).otherwise(l.getColorOff()));
        }

        if (theModel.isAutoEnabled()) {
            autoToggleLight();
        } else {
            toggleLight();
        }
    }

    private void autoToggleLight() {
        for (int i =0; i < theView.getLights().size(); i++) {
            Light l = theModel.getLights().get(i);
            Circle c = theView.getLights().get(i);
            c.setOnMouseClicked(event -> {
                l.turnOnForMs(10);
            });
        }
    }

    private void toggleLight() {
        for (int i =0; i < theView.getLights().size(); i++) {
            Light l = theModel.getLights().get(i);
            Circle c = theView.getLights().get(i);
            c.setOnMouseClicked(event -> {
                l.toggle();
            });
        }
    }
}
