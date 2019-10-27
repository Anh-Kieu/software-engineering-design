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
 * Class: TrafficLightView
 *
 * Description: Traffic Light GUI - View
 *
 * ****************************************
 */

package lab12.trafficlightmvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * Class for TL GUI view
 */
public class TrafficLightView {

    /** the model of GUI */
    private TrafficLightModel theModel;
    /** the root node */
    private VBox root;
    /** checkbox prompting auto off */
    private CheckBox checkboxAutoOff;
    /** Array of circles representing lights */
    private ArrayList<Circle> lights;

    /**
     * Get the root pane
     * @return root
     */
    public VBox getRoot() {
        return root;
    }

    /**
     * Get the checkbox box
     * @return checkbox
     */
    public CheckBox getCheckboxAutoOff() {
        return checkboxAutoOff;
    }

    /**
     * Get the circles that represent lights
     * @return ArrayList of Circle
     */
    public ArrayList<Circle> getLights() {
        return lights;
    }

    /**
     * The view for GUI
     * @param model - GUI model
     */
    public TrafficLightView(TrafficLightModel model) {
        this.theModel = model;

        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(300);

        checkboxAutoOff = new CheckBox("Auto off");
        checkboxAutoOff.setPadding(new Insets(10));
        checkboxAutoOff.setSelected(theModel.isAutoEnabled());

        lights = new ArrayList<>();

        Circle c1 = new Circle();
        c1.setRadius(50);
        if (theModel.getLight(0).isOn()) c1.setFill(theModel.getLight(0).getColorOn());
        else c1.setFill(theModel.getLight(0).getColorOff());
        Circle c2 = new Circle();
        c2.setRadius(50);
        if (theModel.getLight(1).isOn()) c2.setFill(theModel.getLight(0).getColorOn());
        else c2.setFill(theModel.getLight(0).getColorOff());
        Circle c3 = new Circle();
        c3.setRadius(50);
        if (theModel.getLight(2).isOn()) c3.setFill(theModel.getLight(0).getColorOn());
        else c3.setFill(theModel.getLight(0).getColorOff());

        lights.add(c1);
        lights.add(c2);
        lights.add(c3);

        root.getChildren().add(checkboxAutoOff);
        root.getChildren().addAll(lights);
    }

}
