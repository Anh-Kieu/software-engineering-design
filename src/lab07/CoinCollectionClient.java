/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 9/18/2019
 * Time: 7:37 PM
 *
 * Project: csci205_labs
 * Package: lab07
 * Class: CoinCollectionClient
 *
 * Description:
 *
 * ****************************************
 */

package lab07;

import javax.swing.*;

public class CoinCollectionClient {

    /**
     * A nested helper enum for managing our dialog box choices
     */
    private enum AddRemoveChoices {
        DONE("Done"),
        REMOVE("Remove Coins"),
        ADD("Add Coins");

        private String label;

        AddRemoveChoices(String s) {label = s;}

        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Main program for Coin Collection GUI
     * @param args
     */
    public static void main(String[] args) {
        CoinCollection myCoins = new CoinCollection();

        // Initialize the coin collection with some coins
        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        int QUIT_VALUE = -1;
        boolean repeat = true;
        while (repeat) {
            String display = myCoins.toString();
            int choice = JOptionPane.showOptionDialog(null, display + "\nSelect your action:", "Add or remove?",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, AddRemoveChoices.values(), AddRemoveChoices.DONE);
            while (choice == AddRemoveChoices.ADD.ordinal()) {
                Coin coinType = (Coin) JOptionPane.showInputDialog(null, "Select coin type", "Coin Selection",
                        JOptionPane.INFORMATION_MESSAGE, null, Coin.values(), Coin.values()[0]);
                if (coinType == null) {
                    break;
                }
                String coinNum = JOptionPane.showInputDialog(null, "How many do you want to add?");

                if (coinNum == null) {
                    break;
                }

                int coinNumber = Integer.parseInt(coinNum);
                myCoins.addCoins(coinType, coinNumber);
                break;
            }
            while (choice == AddRemoveChoices.REMOVE.ordinal()) {
                Coin coinType = (Coin) JOptionPane.showInputDialog(null, "Select coin type", "Coin Selection",
                        JOptionPane.INFORMATION_MESSAGE, null, Coin.values(), Coin.values()[0]);
                if (coinType == null) {
                    break;
                }
                String coinNum = JOptionPane.showInputDialog(null, "How many do you want to remove? Max = " + myCoins.getCount(coinType));

                if (coinNum == null) {
                    break;
                }

                int coinNumber = Integer.parseInt(coinNum);
                myCoins.removeCoins(coinType, coinNumber);
                break;
            }
            if (choice == AddRemoveChoices.DONE.ordinal() || choice == QUIT_VALUE) repeat = false;
        }
        JOptionPane.showMessageDialog(null, "You have:\n" + myCoins.toString() + "\n Goodbye :)", "Buh-bye!", JOptionPane.DEFAULT_OPTION);
    }

}