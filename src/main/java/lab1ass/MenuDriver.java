package lab1ass;

import java.util.Scanner;

/**
 * @author RAWR xD
 */
public class MenuDriver {
    private boolean stillRunning;
    public Course cMain = new Course(0, null, 0, 0);
    Scanner input = new Scanner(System.in);
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
            choice = getUserSelection(0, 8);
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
        System.out.println("8.  Facebook Private Infomation");
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
                // menu option 1
                Person p1 = personWizard();
                System.out.println("I have a person object : " + p1.toString());
                break;
            case 2:
                System.out.println("2");
                // menu option 2
                break;
            case 3:
                System.out.println("3");
                // menu option 3 New Course
                Scanner in3 = new Scanner(System.in);
                System.out.println("Enter the Name of new Course:");
                String courseName = in3.nextLine();
                System.out.println("Enter the Price of " + courseName + ":");//
                float coursePrice = in3.nextFloat();
                System.out.println("Enter the RunTime of " + courseName + ":");
                int courseRuntime = in3.nextInt();
                System.out.println("Enter the Lecturer's Id of " + courseName +":");
                int courseLecturerID = in3.nextInt();
                Course c1 = new Course(courseLecturerID, courseName, coursePrice, courseRuntime);
                cMain.diffrentCourses(c1);
                
                System.out.println("A New Course "+ courseName + "has been created with the following values [ " + c1.toString() + " ]");
                in3.close();
               
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
                break;
            case 8:
            	System.out.println("If any errors occour please send an email to Zucc@lizardsquad.com.");
            	System.out.println("Gaining access to Lizard Deep Web.");
            	break;
            case 0:
                stillRunning = false;// causes the main loop of program to end (i.e. quits)
                input.close();
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
            userInput = input.nextInt(); // obtain the input
            input.nextLine(); // gets rid of the newline after the number we just read
            if (userInput < lower || userInput > upper)
                System.out.println("Invalid choice.");
        } while (userInput < lower || userInput > upper);
        System.out.println(); // put a space before the next output

        return userInput;
    }
    
    private Person personWizard () {
        System.out.println("Enter rate payer name: ");
        String name = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer address: ");
        String address = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer postcode: ");
        String postcode = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer city: ");
        String city = input.nextLine(); // obtain the input
    	return new Person(address, name, postcode, city);
    }

    /*//Wraps Animal creation method in command line interface
    private Animal petWizard () {
        Scanner in = new Scanner(System.in);
        System.out.println ("Is the pet a (c)at, (d)og, or (r)abbit?");
        String creature = in.nextLine();
        System.out.println ("What is the animals name?");
        String name = in.nextLine();
        System.out.println("what is the breed?");
        String breed = in.nextLine();
        System.out.println("What is the animals sex (m/f)?");
        String gender = in2.nextLine();
        System.out.println("has the animal been microchipped (y/n)?");
        boolean chipped = (in2.nextLine() == "y");
        switch (creature) {
            case "d":
                System.out.println("has the animal been desexed(y/n)?");
                boolean desexed = (in2.nextLine() == "y");
                return new Dog(breed, name, gender, regdue, chipped);
            case "c":
                return new Cat(breed, name, );
            case "r":
                return new Rabbit();
        }
    }*/
}