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
 * Class: TempConverterController
 *
 * Description: TempConverter GUI - Controller
 *
 * ****************************************
 */

package lab12.tempconvertermvc;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Class for GUI controller
 */
public class TempConverterController {

    TempConverterView view;
    TempConverterModel model;

    TempConverterController(TempConverterModel model, TempConverterView view) {
        this.model = model;
        this.view = view;
        // bind the properties
        model.propDoFtoCProperty().bind(view.getRB1().selectedProperty());
        model.propDoCtoFProperty().bind(view.getRB2().selectedProperty());
        view.getLblUnits().textProperty().bind(Bindings.when(model.propDoCtoFProperty()).then("(C)").otherwise("(F)"));
        // tie events to one handler
        view.getTextFieldTempInput().setOnAction(view.getBtn().getOnAction());
        view.getRB1().setOnAction(view.getBtn().getOnAction());
        view.getRB2().setOnAction(view.getBtn().getOnAction());
        convertAction();
    }

    /**
     * Set the action for the convert button
     */
    private void convertAction() {
        Button btn = this.view.getBtn();
        TextField textFieldTempInput = this.view.getTextFieldTempInput();
        Text result = this.view.getResultText();
        btn.setOnAction(event -> {
            try {
                if (textFieldTempInput.getText().length() == 0) return;
                String converted = this.model.stringConvert(textFieldTempInput.getText());
                result.setText(converted);
            }catch (NumberFormatException e) {
                alertWrongInput(textFieldTempInput.getText());
            }
        });
    }

    private String unitPick() {
        return "";
    }

    /**
     * Display alert if the user inputs the wrong type
     */
    private void alertWrongInput(String input) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect input!");
        alert.setHeaderText("Incorrect input specified");
        alert.setContentText(String.format("Cannot convert \"%s\"", input));
        alert.show();
    }

}
