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
 * Class: HelloMain
 *
 * Description: Testing JavaFX
 *
 * ****************************************
 */

package lab12.ex1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Date;

public class HelloMain extends Application {

    private Button btn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set up the root node for our scene graph. Resizable
        StackPane root = new StackPane();

        // Initialize all controls
        initSceneGraph(root);

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(root, 400, 300));
        // Set the title for the main window
        primaryStage.setTitle("Hello, JavaFX!");
        // Display the scene
        primaryStage.show();
    }

    /**
     * Initialize all controls and place them in the scence graph <code>root</code>
     *
     * @param root the root node container of the graph
     */
    private void initSceneGraph(StackPane root) {
        // Add a button and handler to report the current time
        btn = new Button();
        btn.setText("Report the time");
        btn.setOnAction(event -> {
            Date d = new Date();
            System.out.printf("%tI:%<tM:%<tS %<tp%n",d);
        });

        // Add button to scene graph
        root.getChildren().add(btn);
    }
}
