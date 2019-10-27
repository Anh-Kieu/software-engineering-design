package lab12.trafficlightmvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class TrafficLightView {

    private TrafficLightModel theModel;
    private VBox root;
    private CheckBox checkboxAutoOff;

    public VBox getRoot() {
        return root;
    }

    public CheckBox getCheckboxAutoOff() {
        return checkboxAutoOff;
    }

    public ArrayList<Circle> getLights() {
        return lights;
    }

    private ArrayList<Circle> lights;

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
