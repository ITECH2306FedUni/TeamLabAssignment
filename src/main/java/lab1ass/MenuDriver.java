package lab1ass;

import java.util.Scanner;

/**
 * @author RAWR xD
 */
public class MenuDriver {
    boolean stillRunning;

    // PROGRAM ENTRY POINT:
    public static void main(String[] args) {
        MenuDriver theProgram = new MenuDriver();
        theProgram.start();

    }

    private void start() {
        int choice;
        //String fileNameToLoad;

        // Ask for file name to load. Keeps trying
/*		do {
			System.out.print("Which log file do you wish load: ");
			fileNameToLoad = console.nextLine();

			logs = new LogsData();					// Create the primary data management object of this program (in the loop so that it starts clean for each file attempted)
		} while (loadFile(fileNameToLoad) == false);
*/
        stillRunning = true;        // in order to commence program

        while (stillRunning) {
            showMainMenu();
            choice = getUserSelection(0, 7);
            processChoiceMainMenu(choice);
        }

    }

    // METHOD:  showMainMenu
    // PURPOSE: To present a menu/list of options to the user.
    // PASSED:  nothing
    // RETURNS: nothing
    // EFFECTS: A list of options is displayed on the screen.
    public void showMainMenu() {
        System.out.println();        // ensure a break between previous output and the menu
        System.out.println("What would you like to do?");
        System.out.println("1.  Add a new rate payer");
        System.out.println("2.  Register an Animal to a rate payer");
        System.out.println("3.  Create a new course offering");
        System.out.println("4.  Enrol a student in a course");
        System.out.println("5.  List details of a particular available course");
        System.out.println("6.  Calculate registration renewal notice for a particular rate payer who has previously registered an animal");
        System.out.println("7.  Run system tests");
        System.out.println("0.  Exit Program");
    }

    // METHOD:  processChoiceMainMenu
    // PURPOSE: To dispatch control to a relevant method which handles the user's selected choice.
    // PASSED:
    //     choice - the code of the menu option selected by the user.
    // RETURNS: nothing
    // EFFECT:  Some action will be performed based on the user's choice. An invalid choice
    //     will result in an error message being displayed to the screen.
    // NOTE: This method will invoke a range of other methods to actually achieve the user's choice.
    public void processChoiceMainMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("1");
                // menu option 1
                break;
            case 2:
                System.out.println("2");
                // menu option 2
                break;
            case 3:
                System.out.println("3");
                // menu option 3
                break;
            case 4:
                System.out.println("4");
                // menu option 4
                break;
            case 5:
                System.out.println("5");
                // menu option 5
                break;
            case 6:
                System.out.println("6");
                // menu option 6
                break;
            case 7:
                System.out.println("7");
                TestDriverClass.main(null);
            case 0:
                stillRunning = false;// causes the main loop of program to end (i.e. quits)
                break;
            default:
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        }
    }

    // METHOD:  getUserSelection
    // PURPOSE: To obtain from the user a selection (an integer) from a range of values
    // PASSED:
    //    lower - the Lowest permissible value the user can enter as their selection.
    //    upper - the Highest permissible value the user can enter
    // RETURNS:
    //    The value entered by the user, unless the "lower" parameter was higher
    //    than the "upper" parameter, in which case 0 is returned.
    // EFFECTS:
    //    A prompt is displayed on the screen to ask the user for a value in the range.
    //    Input is sought from the user via the keyboard (System.in)
    public int getUserSelection(int lower, int upper) {
        int userInput;

        if (lower > upper)
            return 0;

        do {
            System.out.print("Enter a selection (" + lower + "-" + upper + "):");
            Scanner in = new Scanner(System.in);
            userInput = in.nextInt(); // obtain the input
            in.nextLine();
            // gets rid of the newline after the number we just read
            in.close();

            if (userInput < lower || userInput > upper)
                System.out.println("Invalid choice.");
        } while (userInput < lower || userInput > upper);
        System.out.println();        // put a space before the next output

        return userInput;
    }
}