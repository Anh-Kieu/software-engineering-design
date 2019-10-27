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
 * Class: TempConverterView
 *
 * Description: TempConverter GUI - View
 *
 * ****************************************
 */

package lab12.tempconvertermvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * The view of the GUI
 */
public class TempConverterView {

    // All attributes to be used in main
    /** The root pane */
    private final BorderPane root;
    /** Text input field for user input */
    private final TextField textFieldTempInput;
    /** Confirm button */
    private final Button btn;
    /** Result text */
    private final Text resultText;
    /** Toggle group of radio button */
    private final ToggleGroup toggleGroup;
    /** Radio button for FtoC */
    private final RadioButton bFtoC;
    /** Radio button for CtoF */
    private final RadioButton bCtoF;
    /** Label for temperature unit */
    private final Label lblUnits;


    /**
     * Get the unit of the temperature
     * @return unit of temperature
     */
    public Label getLblUnits() {
        return lblUnits;
    }

    /**
     * Get the radio button for FtoC
     * @return rb for FtoC
     */
    public RadioButton getRB1() {
        return bFtoC;
    }

    /**
     * Get the radio button for CtoF
     * @return rb for CtoF
     */
    public RadioButton getRB2() {
        return bCtoF;
    }



    /**
     * Get the root
     * @return the root
     */
    public BorderPane getRoot() {
        return root;
    }

    /**
     * Get the text input field
     * @return text input field
     */
    public TextField getTextFieldTempInput() {
        return textFieldTempInput;
    }

    /**
     * Get the convert button
     * @return button
     */
    public Button getBtn() {
        return btn;
    }

    /**
     * Get the result text
     * @return text
     */
    public Text getResultText() {
        return resultText;
    }

    public TempConverterView() {
        // initialize the model
        // ??

        // root node
        root = new BorderPane();
        // setup the alignment + padding
        root.setPrefWidth(250);
        root.setPadding(new Insets(15));

        // make a pane for temperature holder, including text input and other buttons
        FlowPane tempBox = new FlowPane(Orientation.HORIZONTAL);
        tempBox.setAlignment(Pos.CENTER);
        tempBox.setHgap(10);

        // input text box
        textFieldTempInput = new TextField();
        textFieldTempInput.setAlignment(Pos.CENTER);
        textFieldTempInput.setPrefColumnCount(5);

        // convert button
        btn = new Button("Convert!");

        // result text
        resultText = new Text("_________");
        resultText.setTextAlignment(TextAlignment.LEFT);

        // add unit type
        lblUnits = new Label("(F)");

        // add radio buttons
        bFtoC = new RadioButton();
        bFtoC.setText("F to C");
        bCtoF = new RadioButton();
        bCtoF.setText("C to F");

        // add Toggle Group
        toggleGroup = new ToggleGroup();
        bFtoC.setToggleGroup(toggleGroup);
        bFtoC.setSelected(true);
        bCtoF.setToggleGroup(toggleGroup);

        // create a left vbox
        VBox unitBox = new VBox(10);
        unitBox.getChildren().addAll(bFtoC, bCtoF);
        unitBox.setPadding(new Insets(10));

        // add stuff:
        tempBox.getChildren().add(new Label("Temperature:"));
        tempBox.getChildren().add(textFieldTempInput);
        tempBox.getChildren().add(lblUnits);
        root.setTop(tempBox);
        root.setCenter(resultText);
        root.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.CENTER);
        root.setLeft(unitBox);
    }
}
