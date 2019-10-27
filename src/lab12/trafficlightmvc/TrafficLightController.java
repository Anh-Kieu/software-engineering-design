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
 * Class: TrafficLightController
 *
 * Description: Traffic Light GUI - Controller
 *
 * ****************************************
 */

package lab12.trafficlightmvc;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.shape.Circle;

/**
 * Controller for Traffic Light GUI
 */
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

    /**
     * Auto toggling of auto-off mode
     */
    private void autoToggleLight() {
        for (int i =0; i < theView.getLights().size(); i++) {
            Light l = theModel.getLights().get(i);
            Circle c = theView.getLights().get(i);
            c.setOnMouseClicked(event -> {
                l.turnOnForMs(10);
            });
        }
    }

    /**
     * Toggling of normal mode
     */
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
