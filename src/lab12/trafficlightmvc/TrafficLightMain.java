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
 * Class: TrafficLightMain
 *
 * Description: Traffic Light GUI - Main
 *
 * ****************************************
 */

package lab12.trafficlightmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to run GUI
 */
public class TrafficLightMain extends Application {

    private TrafficLightModel theModel;
    private TrafficLightView theView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        theModel = new TrafficLightModel();
        theView = new TrafficLightView(theModel);
    }

    @Override
    public void start(Stage primaryStage) {
        TrafficLightController theController = new TrafficLightController(theModel, theView);

        Scene scene = new Scene(theView.getRoot());

        primaryStage.setTitle("Traffic Light Simulation");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
