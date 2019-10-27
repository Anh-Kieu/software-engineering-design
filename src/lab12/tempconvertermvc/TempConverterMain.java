package lab12.tempconvertermvc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TempConverterMain extends Application {

    TempConverterView theView;
    TempConverterController theController;
    TempConverterModel theModel;

    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new TempConverterView();
        this.theModel = new TempConverterModel();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.theController = new TempConverterController(theModel, theView);

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(theView.getRoot()));
        primaryStage.sizeToScene();

        // set the title for the main window
        primaryStage.setTitle("Temperature Converter");

        // Display
        primaryStage.show();
    }


}
