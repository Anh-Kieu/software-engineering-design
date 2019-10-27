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
 * Class: TreeNode
 *
 * Description:
 *
 * ****************************************
 */

package lab12.ex3;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class TreeNode extends Rectangle {

    private static final double INIT_WIDTH = 100;
    private static final double INIT_HEIGHT = 75;

    public TreeNode(Paint fillColor) {
        super(INIT_WIDTH, INIT_HEIGHT, fillColor);
        setupEffects();
    }

    /**
     * Set shadow effect for nodes
     */
    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);
    }
}
