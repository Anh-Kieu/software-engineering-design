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
 * Class: SimpleTree
 *
 * Description: Tree GUI
 *
 * ****************************************
 */

package lab12.ex3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class SimpleTree extends Application {

    private Group root;
    private Scene scene;
    private Line line1to2;
    private Line line1to3;
    private TreeNode r1;
    private TreeNode r2;
    private TreeNode r3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        scene = new Scene(root, 500,500, Color.DARKGRAY);

        createLine();

        createNode();

        updateLinePosition(line1to2,r1,r2);
        updateLinePosition(line1to3,r1,r3);

        root.getChildren().add(line1to2);
        root.getChildren().add(line1to3);
        root.getChildren().add(r1);
        root.getChildren().add(r2);
        root.getChildren().add(r3);

        primaryStage.setTitle("Simple Tree");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    /**
     * Create tree nodes
     */
    private void createNode() {
        r1 = new TreeNode(Color.BLUE);
        r1.setX(200);
        r1.setY(100);

        r2 = new TreeNode(Color.LIGHTBLUE);
        r2.setX(75);
        r2.setY(250);

        r3 = new TreeNode(Color.LIGHTBLUE);
        r3.setX(325);
        r3.setY(250);
    }

    /**
     * Create connection lines
     */
    private void createLine() {
        line1to2 = new Line();
        line1to2.setStrokeWidth(3);

        line1to3 = new Line();
        line1to3.setStrokeWidth(3);
    }

    /**
     * Update the line position according to the nodes
     * @param line line to be updated
     * @param r1 node 1
     * @param r2 node 2
     */
    private void updateLinePosition(Line line, TreeNode r1, TreeNode r2) {
        line.setStartX(r1.getX() + r1.getWidth()/2);
        line.setStartY(r1.getY() + r1.getHeight()/2);
        line.setEndX(r2.getX() + r2.getWidth()/2);
        line.setEndY(r2.getY() + r2.getHeight()/2);
    }

}
