package lab12.ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloMe extends Application {

    private VBox root;
    private HBox topPane;
    private TextField textFieldInputName;
    private Button btn;
    private Text textNameOutput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Layout setup
        root = new VBox(10);

        // Add padding
        root.setPadding(new Insets(15));
        // Set center alignment
        root.setAlignment(Pos.CENTER);

        // Add text input
        textInputBox(root);

        // Add button
        addButton(root);

        // Add a separator
        root.getChildren().add(new Separator());

        // Add text
        addText(root);

        // Add shadow
        addShadow(root);

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();

        // set the title for the main window
        primaryStage.setTitle("Hello, Me!");

        // Display
        primaryStage.show();
    }

    /**
     * Add shadow to the text
     * @param root - big view
     */
    private void addShadow(VBox root) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setHeight(5);
        dropShadow.setRadius(2);
        dropShadow.setColor(Color.DARKOLIVEGREEN);
        textNameOutput.setEffect(dropShadow);
        root.setOnMouseMoved(event -> {
            dropShadow.setOffsetX(event.getX() - root.getWidth()/3);
            dropShadow.setOffsetX(event.getY() - root.getHeight()/3);
        });
    }

    /**
     * Add text
     * @param root - big view
     */
    private void addText(VBox root) {
        textNameOutput = new Text();
        textNameOutput.setFont(Font.font(null, FontWeight.BOLD, 30));
        textNameOutput.setFill(Color.GREEN);

        root.getChildren().add(textNameOutput);
    }

    /**
     * Add button for getting text input
     * @param root - big view
     */
    private void addButton(VBox root) {
        btn = new Button("Show my name!");
        root.getChildren().add(btn);
        btn.setOnAction(event -> {
            System.out.println("Hello, " + textFieldInputName.getText() + "!");
            textNameOutput.setText(textFieldInputName.getText());
        });
    }

    private void textInputBox(VBox root) {
        // Add another pane to the layout
        topPane = new HBox(10);
        root.getChildren().add(topPane);

        // Add label
        topPane.getChildren().add(new Label("Your name:"));

        // Add text input
        textFieldInputName = new TextField();
        topPane.getChildren().add(textFieldInputName);
    }
}
