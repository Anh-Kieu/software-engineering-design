package lab12.trafficlightmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
