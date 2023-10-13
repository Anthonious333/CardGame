package simpleIO;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.lang.String;
import java.lang.Object;

/**
 * 
 * This class contains helper methods for students learning Java for the first
 * time, to simplify the process of obtaining input from the user using a
 * dialog, and outputting information with a dialog
 *
 * @author Karen Spindler, OCT
 * @since August 2020
 */
public class Dialog {

    /**
     * This method obtains text (letters, numbers, special characters) from the
     * user.
     * 
     * <p>Suggested usage: </p>
     * <code>String name = Dialog.readString("What is your name?");</code>
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
                // prompt user & get the text from the user
                returnValue = JOptionPane.showInputDialog(prompt);
                // if we got here, we must have read the text successfully!
                validInput = true;
            } catch (Exception e) {
                // something went wrong; let the user know
                JOptionPane.showMessageDialog(null, "Could not read String", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // return the text entered by the user
        return returnValue;
    }

    /**
     * This method obtains an integer (positive or negative whole number) from the
     * user.
     * 
     * <p>Suggested usage: </p>
     * <code>int number = Dialog.readInt("Enter a number: ");</code>
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
                // get the number entered by the user and parse is as an integer
                returnValue = Integer.parseInt(JOptionPane.showInputDialog(prompt));
                // if we got here, we must have read the number successfully!
                validInput = true;
            } catch (Exception e) {
                // something went wrong; let the user know
                JOptionPane.showMessageDialog(null, "Could not read integer", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // return the number entered by the user
        return returnValue;
    }

    /**
     * This method obtains a real number (which may include decimals or floating
     * point values) from the user.
     * 
     * <p>Suggested usage: </p>
     * <code>double number = Dialog.readDouble("Enter a number: ");</code>
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
                // get the number entered by the user and parse is as a double
                returnValue = Double.parseDouble(JOptionPane.showInputDialog(prompt));
                // if we got here, we must have read the number successfully!
                validInput = true;
            } catch (Exception e) {
                // something went wrong; let the user know
                JOptionPane.showMessageDialog(null, "Could not read double", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // return the number entered by the user
        return returnValue;
    }

    /**
     * This method obtains a single character from the user.
     * 
     * <p>Suggested usage: </p>
     * <code>char goAgain = Dialog.readChar("Play Again? Y - Yes or N - No: ");</code>
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
                // read the entire text from the user, but save the first character only
                returnValue = JOptionPane.showInputDialog(prompt + " (only first character will be read) ").charAt(0);
                // if we got here, we must have read the character successfully!
                validInput = true;
            } catch (Exception e) {
                // something went wrong; let the user know
                JOptionPane.showMessageDialog(null, "Could not read character", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // return the character entered by the user
        return returnValue;
    }

    /**
     * This method will allow the user to respond to a yes/no question
     * 
     * <p>Suggested usage: </p>
     * <code>boolean goAgain = Dialog.askYesNoQuestion("Do you want to play again?");</code>
     * 
     * @param question
     *            The question for the user (Must be a yes/no question)
     * @return A <code>boolean</code> indicating the user's answer. Yes:true,
     *         No:false
     */
    public static boolean askYesNoQuestion(String question) {
        int result = JOptionPane.showConfirmDialog(null, question, "Question", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    /**
     * This method will allow the user to make a choice from a list of options (each
     * option appears as a button on the dialog)
     * 
     * <p>Suggested usage: </p>
     * <code>String choice = Dialog.chooseOption("Choose a shape ", new String [] {"square", "rectangle", "triangle"});</code>
     * 
     * @param prompt
     *            A message for the user, so they know what the choices mean
     * @param options
     *            List of choices in a <code>String[]</code> array
     * @return A <code>String</code> corresponding to the user's choice
     */
    public static String chooseOption(String prompt, String[] options) {
        // setting up input validation
        boolean validInput = false;
        // default return value
        int choice = -1;

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // prompt user & get the text from the user
                choice = JOptionPane.showOptionDialog(null, prompt, "Make a selection", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                // if we got here, we must have read the text successfully!
                validInput = true;
            } catch (HeadlessException e) {
                // something went wrong; let the user know
                JOptionPane.showMessageDialog(null, "Could not read choice", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // return the text clicked by the user
        return options[choice];
    }

    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param message
     *            Text for the user to read.
     */
    public static void print(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * This method gives a number to the user in a simple dialog (OK button only)
     * 
     * @param number
     *            The number to output
     */
    public static void print(int number) {
        JOptionPane.showMessageDialog(null, number);
    }

    /**
     * This method gives a number to the user in a simple dialog (OK button only)
     * 
     * @param number
     *            The floating-point number to output
     */
    public static void print(double number) {
        JOptionPane.showMessageDialog(null, number);
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

        JOptionPane.showMessageDialog(null, Console.roundDouble(number, rounding));
    }

    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param character
     *            Character for the user to read.
     */
    public static void print(char character) {
        JOptionPane.showMessageDialog(null, Character.toString(character));
    }

    /**
     * This method gives a message to the user in a simple dialog (OK button only)
     * 
     * @param obj
     *            Object to be displayed.
     */
    public static void print(Object obj) {
        JOptionPane.showMessageDialog(null, obj.toString());
    }
}
