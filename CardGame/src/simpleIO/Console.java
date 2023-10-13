package simpleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;
import java.lang.String;

/**
 * This class contains helper methods for students learning Java for the first
 * time, to simplify the process of obtaining input from the user and printing
 * to the console. Thanks to Kyle Anderson for contributing the roundDouble
 * method to this class.
 * 
 * @author Karen Spindler, OCT
 * @author Kyle Anderson
 * @since August 2020
 *
 */
public class Console {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * <p>This method obtains text (letters, numbers, special characters) from the
     * user.</p>
     * 
     * <p>Suggested usage: </p>
     * <code>String name = Console.readString("What is your name?");</code>
     * 
     * @param prompt
     *            A message for the user, so they know what text is expected
     * @return A <code>String</code> containing the text entered by the user (may be
     *         an empty <code>String</code>)
     */
    public static String readString(String prompt) {
        // use System.out to display prompt
        System.out.print(prompt + " ");

        // setting up input validation
        boolean validInput = false;
        // default return value
        String returnValue = "";

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // read the entire line from the user (until the enter button is pressed)
                returnValue = br.readLine();
                // if we got here, we must have read the line successfully!
                validInput = true;
            } catch (IOException e) {
                // something went wrong; re-prompt the user and wait for new text
                System.out.print("Could not read String.\n" + prompt + " ");
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
     * <code>int number = Console.readInt("Enter a number: ");</code>
     * 
     * @param prompt
     *            A message for the user, so they know what number is expected
     * @return An <code>int</code> containing the number entered by the user. If the
     *         user tries to enter something other than an <code>int</code>, they
     *         are re-prompted until they provide the appropriate input
     */
    public static int readInt(String prompt) {
        // use System.out to display prompt
        System.out.print(prompt + " ");

        // setting up input validation
        boolean validInput = false;
        // default return value
        int returnValue = 0;

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // read the entire line from the user (until the enter button is pressed) and
                // convert to an integer
                returnValue = Integer.parseInt(br.readLine());
                // if we got here, we must have read the number successfully!
                validInput = true;
            } catch (NumberFormatException | IOException e) {
                // something went wrong; re-prompt the user and wait for new text
                System.out.print("Could not read integer.\n" + prompt + " ");
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
     * <code>double number = Console.readDouble("Enter a number: ");</code>
     * 
     * @param prompt
     *            A message for the user, so they know what number is expected
     * @return A <code>double</code> containing the number entered by the user. If
     *         the user tries to enter something other than a <code>double</code>,
     *         they are re-prompted until they provide the appropriate input
     */
    public static double readDouble(String prompt) {
        // use System.out to display prompt
        System.out.print(prompt + " ");

        // setting up input validation
        boolean validInput = false;
        // default return value
        double returnValue = 0;

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // read the entire line from the user (until the enter button is pressed) and
                // convert to a double
                returnValue = Double.parseDouble(br.readLine());
                // if we got here, we must have read the number successfully!
                validInput = true;
            } catch (NumberFormatException | IOException e) {
                // something went wrong; re-prompt the user and wait for new text
                System.out.print("Could not read double.\n" + prompt + " ");
            }
        }
        // return the number entered by the user
        return returnValue;
    }

    /**
     * This method obtains a single character from the user.
     * 
     * <p>Suggested usage: </p>
     * <code>char goAgain = Console.readChar("Play Again? Y - Yes or N - No: ");</code>
     * 
     * @param prompt
     *            A message for the user, so they know what character is expected
     * @return A <code>char</code> containing the character entered by the user.
     *         Only the first character is returned; the rest of the text is
     *         ignored. If the user tries to enter an empty <code>String</code>,
     *         they are re-prompted until they provide the appropriate input
     */
    public static char readChar(String prompt) {
        // use System.out to display prompt
        System.out.print(prompt + " (only the first character will be read) ");

        // setting up input validation
        boolean validInput = false;
        // default return value
        char returnValue = ' ';

        // loop until a valid input is obtained
        while (!validInput) {
            try {
                // read the entire line from the user (until the enter button is pressed) save
                // the first character only
                returnValue = br.readLine().charAt(0);
                // if we got here, we must have read the character successfully!
                validInput = true;
            } catch (IOException | StringIndexOutOfBoundsException e) {
                // something went wrong; re-prompt the user and wait for new text
                System.out.print("Could not read character.\n" + prompt + " (only the first character will be read) ");
            }
        }
        // return the character entered by the user
        return returnValue;
    }

    /**
     * This method prints a newline.<br>
     * Equivalent to <code>Console.<i>print</i>("")</code>
     * 
     */
    public static void print() {
        print("");
    }
    
    /**
     * This method prints text to the console and inserts a newline at the end.<br>
     * Equivalent to <code>Console.<i>print</i>(message, true)</code>
     * 
     * @param message
     *            Text for the user to read.
     */
    public static void print(String message) {
        print(message, true);
    }

    /**
     * This method prints text to the console.
     * 
     * @param message
     *            Text for the user to read.
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the message (true: newline printed, false:
     *            no newline)
     */
    public static void print(String message, boolean newLine) {
        if (newLine) System.out.println(message);
        else System.out.print(message);
    }

    /**
     * This method prints a number to the console and inserts a newline at the
     * end.<br>
     * Equivalent to <code>Console.<i>print</i>(number, true)</code>
     * 
     * @param number
     *            The number to print to the console.
     */
    public static void print(int number) {
        print(number, true);
    }

    /**
     * This method prints a number to the console.
     * 
     * @param number
     *            The number to print to the console.
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the number (true: newline printed, false:
     *            no newline)
     */
    public static void print(int number, boolean newLine) {
        if (newLine) System.out.println(number);
        else System.out.print(number);
    }
    
    /**
     * This method prints a number (long type) to the console and inserts a newline at the
     * end.<br>
     * Equivalent to <code>Console.<i>print</i>(number, true)</code>
     * 
     * @param number
     *            The number to print to the console.
     */
    public static void print(long number) {
        print(number, true);
    }

    /**
     * This method prints a number (long type) to the console.
     * 
     * @param number
     *            The number to print to the console.
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the number (true: newline printed, false:
     *            no newline)
     */
    public static void print(long number, boolean newLine) {
        if (newLine) System.out.println(number);
        else System.out.print(number);
    }

    /**
     * This method prints a floating-point number to the console and inserts a
     * newline at the end.<br>
     * Equivalent to <code>Console.<i>print</i>(number, true)</code>
     * 
     * @param number
     *            The floating-point number to print to the console.
     */
    public static void print(double number) {
        print(number, true);
    }

    /**
     * This method prints a floating-point number to the console.
     * 
     * @param number
     *            The floating-point number to print to the console.
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the number (true: newline printed, false:
     *            no newline)
     */
    public static void print(double number, boolean newLine) {
        if (newLine) System.out.println(number);
        else System.out.print(number);
    }

    /**
     * This method prints a floating-point number to the console, rounded to the
     * indicated number of decimal places and inserts a newline at the end.<br>
     * Equivalent to <code>Console.<i>print</i>(number, rounding, true)</code>
     * 
     * @param number
     *            The floating-point number to print to the console.
     * @param rounding
     *            The number of decimal places to include
     */
    public static void print(double number, int rounding) {
        print(number, rounding, true);
    }

    /**
     * This method prints a floating-point number to the console, rounded to the
     * indicated number of decimal places
     * 
     * @param number
     *            The floating-point number to print to the console.
     * @param rounding
     *            The number of decimal places to include
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the number (true: newline printed, false:
     *            no newline)
     */
    public static void print(double number, int rounding, boolean newLine) {
        print(roundDouble(number, rounding), newLine);
    }

    /**
     * This method prints a single character to the console and inserts a newline at
     * the end. <br>
     * Equivalent to <code>Console.<i>print</i>(character, true)</code>
     * 
     * @param character
     *            The character to print to the screen
     */
    public static void print(char character) {
        print(character, true);
    }

    /**
     * This method prints a single character to the console.
     * 
     * @param character
     *            The character to print to the screen
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the character (true: newline printed,
     *            false: no newline)
     */
    public static void print(char character, boolean newLine) {
        if (newLine) System.out.println(Character.toString(character));
        else System.out.print(Character.toString(character));
    }

    /**
     * This method prints an object to the console and inserts a newline at the end.
     * <br>
     * Equivalent to <code>Console.<i>print</i>(obj, true)</code>
     * 
     * @param obj
     *            The object to print to the screen
     */
    public static void print(Object obj) {
        print(obj, true);
    }

    /**
     * This method prints an Object to the console.
     * 
     * @param obj
     *            The object to print to the screen
     * @param newLine
     *            A boolean value (true/false) to indicate whether or not a newline
     *            should be printed after the object (true: newline printed, false:
     *            no newline)
     */
    public static void print(Object obj, boolean newLine) {
        if (newLine) System.out.println(obj.toString());
        else System.out.print(obj.toString());
    }

    /**
     * Rounds the given double to the given number of decimal places, adding 0s if
     * necessary. Creates a <code>String</code> for display purposes
     * 
     * <p>Suggested usage: </p>
     * <code>String message = "Total is : " + Console.roundDouble(total, 2);</code>
     * 
     * @author Kyle Anderson
     * @param doubleToRound
     *            The double to round
     * @param decimalPlaces
     *            The number of decimal places to round to
     * @return A string version of the rounded double
     */
    public static String roundDouble(double doubleToRound, int decimalPlaces) {
        // Find the power of the scientific notation so that we can round
        double power = Math.pow(10, decimalPlaces);

        /*
         * Multiply the doubleToRound by the power so that 100.567 becomes 10056.7 (for
         * 2 decimal place rounding), then round using math and re-divide to get 100.57.
         */
        double rounded = Math.round(doubleToRound * power) / power;

        // Convert to string. If decimalPlaces is 0, cast to int before doing so.
        String roundedString = (decimalPlaces > 0) ? String.valueOf(rounded) : String.valueOf((int) rounded);

        if (roundedString.contains(".")) {
            // Determine how many decimal places we actually have and add trailing zeros if
            // necessary.
            int numDecimalPlaces = roundedString.substring(roundedString.indexOf(".") + 1, roundedString.length())
                    .length();

            // Add 0s as necessary
            for (int a = 0; a < decimalPlaces - numDecimalPlaces; a++) {
                roundedString += "0";
            }
        }

        // Return the results
        return roundedString;
    }
}
