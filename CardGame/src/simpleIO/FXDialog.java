package simpleIO;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

/**
 * 
 * This class contains helper methods for students learning Java for the first time, to simplify the process of 
 * obtaining input from the user using a dialog, and outputting information with a dialog.
 * 
 * For use with JavaFX application ONLY!
 * 
 * @author Karen Spindler, OCT
 * @since August 2020
 *
 */
public class FXDialog {

    /**
     * This method obtains text (letters, numbers, special characters) from the
     * user.
     * 
     * @param prompt
     *            A message for the user, so they know what text is expected
     * @return A <code>String</code> containing the text entered by the user (may be
     *         an empty <code>String</code>)
     */
    public static String readString(String prompt) {

        // setting up input validation
        boolean validInput = false;
        // default return value
        String returnValue = "";

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // get the number entered by the user and parse it as an integer
                TextInputDialog input = new TextInputDialog();
                input.setHeaderText(null);
                input.setContentText(prompt);
                input.setTitle("Please enter some text");

                returnValue = input.showAndWait().get();

                // if we got here, we must have read the String successfully!
                validInput = true;

            } catch (Exception e) {
                // something went wrong; let the user know
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not read String.");

                alert.showAndWait();
            }
        }

        return returnValue;

    }

    /**
     * This method obtains an integer (positive or negative whole number) from the
     * user.
     * 
     * @param prompt
     *            A message for the user, so they know what number is expected
     * @return An <code>int</code> containing the number entered by the user. If the
     *         user tries to enter something other than an <code>int</code>, they
     *         are re-prompted until they provide the appropriate input
     */
    public static int readInt(String prompt) {

        // setting up input validation
        boolean validInput = false;
        // default return value
        int returnValue = 0;

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // get the number entered by the user and parse it as an integer
                TextInputDialog input = new TextInputDialog();
                input.setHeaderText(null);
                input.setContentText(prompt);
                input.setTitle("Please enter a number (no decimals)");

                returnValue = Integer.parseInt(input.showAndWait().get());

                // if we got here, we must have read the number successfully!
                validInput = true;

            } catch (Exception e) {
                // something went wrong; let the user know
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not read integer");

                alert.showAndWait();
            }
        }
        // return the number entered by the user
        return returnValue;
    }

    /**
     * This method obtains a real number (which may include decimals or floating
     * point values) from the user.
     * 
     * @param prompt
     *            A message for the user, so they know what number is expected
     * @return A <code>double</code> containing the number entered by the user. If
     *         the user tries to enter something other than a <code>double</code>,
     *         they are re-prompted until they provide the appropriate input
     */
    public static double readDouble(String prompt) {

        // setting up input validation
        boolean validInput = false;
        // default return value
        double returnValue = 0;

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // get the number entered by the user and parse it as an integer
                TextInputDialog input = new TextInputDialog();
                input.setHeaderText(null);
                input.setContentText(prompt);
                input.setTitle("Please enter a number");

                returnValue = Double.parseDouble(input.showAndWait().get());

                // if we got here, we must have read the number successfully!
                validInput = true;

            } catch (Exception e) {
                // something went wrong; let the user know
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not read double");

                alert.showAndWait();
            }
        }
        // return the number entered by the user
        return returnValue;
    }

    /**
     * This method obtains a single character from the user.
     * 
     * @param prompt
     *            A message for the user, so they know what character is expected
     * @return A <code>char</code> containing the character entered by the user.
     *         Only the first character is returned; the rest of the text is
     *         ignored. If the user tries to enter an empty <code>String</code>,
     *         they are re-prompted until they provide the appropriate input
     */
    public static char readChar(String prompt) {
        // setting up input validation
        boolean validInput = false;
        // default return value
        char returnValue = ' ';
        
        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // get the number entered by the user and parse it as an integer
                TextInputDialog input = new TextInputDialog();
                input.setHeaderText(null);
                input.setContentText(prompt);
                input.setTitle("Please enter a single character");

                returnValue = input.showAndWait().get().charAt(0);

                // if we got here, we must have read the character successfully!
                validInput = true;

            } catch (Exception e) {
                // something went wrong; let the user know
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not read character.");

                alert.showAndWait();
            }
        }

        // return the character entered by the user
        return returnValue;
    }

    /**
     * This method will allow the user to respond to a yes/no question
     * 
     * @param question
     *            The question for the user (Must be a yes/no question)
     * @return A <code>boolean</code> indicating the user's answer. Yes:true,
     *         No:false
     */
    public static boolean askYesNoQuestion(String question) {
        Alert dialog = new Alert(AlertType.NONE, question, ButtonType.YES, ButtonType.NO);
        
        return dialog.showAndWait().get() == ButtonType.YES;
    }

    /**
     * This method will allow the user to make a choice from a list of options (each
     * option appears as a button on the dialog) (Edited by Anthony Farinon)
     * 
     * @param prompt
     *            A message for the user, so they know what the choices mean
     * @param options
     *            List of choices in a <code>String[]</code> array
     * @return A <code>String</code> corresponding to the user's choice
     */
    public static String chooseOption(String prompt, String... options) {
        // setting up input validation
        boolean validInput = false;
        // default return value
        String returnValue = "";

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                 // prompt user & get the text from the user               
                ChoiceDialog<String> input = new ChoiceDialog<String>(options[0], options);
                input.setContentText(prompt);
                input.setHeaderText(null);
                returnValue = input.showAndWait().get();
 
                // if we got here, we must have read the text successfully!
                validInput = true;
            } catch (Exception e) {
                // something went wrong; let the user know
                // something went wrong; let the user know
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not read choice.");

                alert.showAndWait();            }
        }
        // return the text clicked by the user
        return returnValue;
    }

    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param message
     *            Text for the user to read.
     */
    public static void print(String message) {
        Alert alert = new Alert(AlertType.NONE, message, ButtonType.OK);
        alert.showAndWait();
    }

    /**
     * This method gives a number to the user in a simple dialog (OK button only)
     * 
     * @param number
     *            The number to output
     */
    public static void print(int number) {
        print(Integer.toString(number));
    }

    /**
     * This method gives a number to the user in a simple dialog (OK button only)
     * 
     * @param number
     *            The floating-point number to output
     */
    public static void print(double number) {
        print(Double.toString(number));
    }

    /**
     * This method gives a number to the user in a simple dialog (OK button only),
     * rounded to the indicated number of decimal places
     * 
     * @param number
     *            The floating-point number to output
     * @param rounding
     *            The number of decimal places to include
     */
    public static void print(double number, int rounding) {
        print(Console.roundDouble(number, rounding));
    }

    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param character
     *            Character for the user to read.
     */
    public static void print(char character) {
        print(Character.toString(character));
    }
    
    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param obj
     *            Object to be displayed.
     */
    public static void print(Object obj) {
        print(obj.toString());
    }

}
