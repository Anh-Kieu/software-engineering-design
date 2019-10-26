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
 * Class: TempConverter
 *
 * Description: Temperature converter GUI
 *
 * ****************************************
 */

package lab12.ex3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TempConverter extends Application {

    VBox root;
    FlowPane tempBox;
    TextField textFieldTempInput;
    Button btn;
    Text result;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new VBox(5);

        // setup the alignment + padding
        root.setPrefWidth(250);
        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(10,5,10,5));

        makeTemperatureHolder();

        makeTextInput();

        displayResult();

        setAction();

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();

        // set the title for the main window
        primaryStage.setTitle("Hello, Me!");

        // Display
        primaryStage.show();

    }

    /**
     * Set the action for the convert button
     */
    private void setAction() {
        btn = new Button("Convert!");
        btn.setOnAction(event -> {
            try {
                double temp = Double.parseDouble(textFieldTempInput.getText());
                double cel = (temp - 32) / 1.8;
                result.setText(String.format("%.1f (C)", cel));
            }catch (NumberFormatException e) {
                alertWrongInput();
            }
        });
        textFieldTempInput.setOnAction(btn.getOnAction());

        root.getChildren().add(btn);
    }

    /**
     * Display alert if the user inputs the wrong type
     */
    private void alertWrongInput() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect input!");
        alert.setHeaderText("Incorrect input specified");
        alert.setContentText(String.format("Cannot convert \"%s\"", textFieldTempInput.getText()));
        alert.show();
    }

    /**
     * Display the result after converted
     */
    private void displayResult() {
        result = new Text("");
        result.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(result);
    }

    /**
     * Text input box for user input
     */
    private void makeTextInput() {
        textFieldTempInput = new TextField();
        textFieldTempInput.setAlignment(Pos.CENTER);
        textFieldTempInput.setPrefColumnCount(5);
        tempBox.getChildren().add(textFieldTempInput);
    }

    /**
     * Temperature UI Box
     */
    private void makeTemperatureHolder() {
        tempBox = new FlowPane(Orientation.HORIZONTAL);
        tempBox.setAlignment(Pos.CENTER);
        tempBox.setHgap(10);
        tempBox.getChildren().add(new Label("Temperature (F):"));
        root.getChildren().add(tempBox);
    }
}
