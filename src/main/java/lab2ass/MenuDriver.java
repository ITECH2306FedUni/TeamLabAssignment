package lab2ass;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * MenuDriver
 *
 * @author  RAWR-XD
 * @version 1.0
 */
public class MenuDriver {
    private boolean stillRunning;
    private static Course cMain = new Course(); // Main Course List
    private static Person pMain = new Person(); // Main Person List
    private Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    // PROGRAM ENTRY POINT:
    public static void main(String[] args) {
        MenuDriver theProgram = new MenuDriver();
        theProgram.start();
    }
    private void start() {
        int choice;
        if(pMain.personList.isEmpty()) {
            System.out.println("What would you like preloaded People data? (y)es or (n)o");
            String preloadchoice = input.nextLine();
            if(preloadchoice.equalsIgnoreCase("y")){
                pMain.addPerson(new Person("31 Nowhere Street", "Nathan Blaney", "3977", "Casey"));
                pMain.addPerson(new Person("69 Rangeless Drive", "Lachlan Copsey", "3977", "Casey"));
                pMain.addPerson(new Person("56 Torvald Court", "Nine Hall", "3977", "Casey"));
            }//adds Temp testing data into the lists 
        }

/*
        String fileNameToLoad;
        // Ask for file name to load. Keeps trying
		do {
			System.out.print("Which log file do you wish load: ");
			fileNameToLoad = console.nextLine();
			logs = new LogsData();					// Create the primary data management object of this program (in the loop so that it starts clean for each file attempted)
		} while (loadFile(fileNameToLoad) == false);
*/
        stillRunning = true; // in order to commence program

        while (stillRunning) {
            showMainMenu();
            choice = getUserSelection(0, 8);
            processChoiceMainMenu(choice);
        }

    }
    /**
    * To present a menu/list of options to the user.
     */
    private void showMainMenu() {
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
    /**
     * To dispatch control to a relevant method which handles the user's selected choice.
     * @param choice - the code of the menu option selected by the user.
     */
    private void processChoiceMainMenu(int choice) {
        switch (choice) {
            case 1:
                // menu option 1: register person
                Person p1 = personWizard();
                pMain.addPerson(p1);
                System.out.println("I have a person object ID: " + p1.getPersonID() + " " + p1.toString());
                menuReturn();
                break;
            case 2:
                // menu option 2: register pet
                //print a list of people
                if(!pMain.personList.isEmpty()){
                    for (Person person: pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    //figure out who to give a pet to
                    Person petOwner = pMain.personList.get(getUserSelection(0, pMain.personList.size()-1));
                    //add dat pet
                    petOwner.addAPet(petWizard());
                    System.out.println("The added pet is: " + petOwner.pet.toString());
                    System.out.println("For the Person: " + petOwner.getName());
                }else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 3:
                // menu option 3: create new course
                Course c = courseWizard();
                cMain.diffrentCourses(c);
                System.out.println("New course : " + c.toString());
                menuReturn();
                break;
            case 4:
                // menu option 4: enroll student
                enrollmentWizard();
                menuReturn();
                break;
            case 5:
                // menu option 5: list courses
                if(!cMain.courseList.isEmpty()) {
                    for (Course course : cMain.courseList) {
                        System.out.println("ID " + course.toStringShort());
                    }
                    System.out.println("Enter in a Course ID: ");
                    int selectCourse = input.nextInt();
                    System.out.println(cMain.courseList.get(selectCourse).toString());
                }else {
                    System.out.println("Please add a Course first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 6:
                // menu option 6: calculate rego
                // figure out who to generate rates for
                if(!pMain.personList.isEmpty()){
                    for (Person person: pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");

                    Person ratePayer = pMain.personList.get(getUserSelection(0, pMain.personList.size()-1));
                    if(ratePayer.hasPet()){
                        System.out.println("Pet is a: "+ ratePayer.pet.getBreed());
                        System.out.println("Pet was first registered: "+ ratePayer.pet.regdue);
                        System.out.println("The rate to pay is: " + df.format(ratePayer.pet.calcRates()));
                    } else {
                        System.out.println(ratePayer.getName() + " does not own a pet!");
                    }
                }else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 7:
                System.out.println("7");
                //menu option 7: system testor
                System.out.println("Running Person Test's");
                TestDriverClass.runTestPerson(null);
                System.out.println("Running Pet Test's");
                TestDriverClass.runTestPet(null);
                System.out.println("Running Course Test's");
                TestDriverClass.runTestCourse(null);
                menuReturn();
                break;
            case 8:
                //menu option 8: lizard eggos
                System.out.println("If any errors occour please send an email to Zucc@lizardsquad.com.");
                System.out.println("Gaining access to Lizard Deep Web.");
                System.out.println("\n Would you like to load Facebooks private info on Adrain Shatte \n Type 'Yes' to View & 'No' to Exit "); // asks the user if they would like to send all of the private data to facebook 
                String Input = input.nextLine(); // obtain the input
                menuReturn();
                break;
            case 0:
                //quit
            	System.out.println("What would you like to QUIT (y)es or (n)o?");
                String quitChoice = input.nextLine();
                if(quitChoice.equalsIgnoreCase("y")){
                	System.out.println("GoodBye!");
                	stillRunning = false;// causes the main loop of program to end (i.e. quits)
                } else {
                	menuReturn();
                }
                break;
            default:
                //error
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        }
    }
    /**
     * To obtain from the user a selection (an integer) from a range of values
     * @param lower - the Lowest permissible value the user can enter as their selection.
     * @param upper - the Highest permissible value the user can enter
     * @return userInput The value entered by the user, unless the "lower" parameter was higher than the "upper" parameter, in which case 0 is returned.
     */
    private int getUserSelection(int lower, int upper) {
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
    /**
     * To generate a person.
     * @return A new person object
     */
    private Person personWizard () {
        System.out.println("Enter rate payer name: ");
        String name = input.nextLine(); // obtain the name
        System.out.println("Enter rate payer address: ");
        String address = input.nextLine(); // obtain the address
        System.out.println("Enter rate payer postcode: ");
        String postcode = input.nextLine(); // obtain the postcode
        System.out.println("Enter rate payer city: ");
        String city = input.nextLine(); // obtain the city
        return new Person(address, name, postcode, city);
    }

    private void showCourseMenu () {
        System.out.println();
        System.out.println("1.  Create a new Course offering");
        System.out.println("2.  Delete current Course offering");
        System.out.println("3.  Enroll a Student in a Course");
        System.out.println("4.  Generate a list of all Courses");
        System.out.println("5.  Generate Expenses Report");
        System.out.println("6.  Edit Course Data");
        System.out.println("7.  Save Course Schema");
        System.out.println("8.  Load Course Schema");
        System.out.println("9.  Generate Expenses Report From Course Schema");
        System.out.println("0.  Return to the Main Menu");
    }

    private void processChoiceCourseMenu (int choice) {
        switch(choice) {
            case 1:
                //create new course
                break;
            case 2:
                //delete a course
                break;
            case 3:
                // enroll a student in a course
                break;
            case 4:
                // generate a list of courses
                break;
            case 5:
                // generate expenses report
                break;
            case 6:
                // edit course
                break;
            case 7:
                // save course
                break;
            case 8:
                // load course
                break;
            case 9:
                // expenses from file
                break;
            case 0:
                // return to menu
                break;
            default:
                //error
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        } 
    }
    /**
     * Wrap Animal creation method in command line interface
     * @return A new pet object
     */
    private Animal petWizard () {
        String creature = "";
        while(!creature.equalsIgnoreCase("c")&& !creature.equalsIgnoreCase("d") && !creature.equalsIgnoreCase("r")){
            System.out.println ("Is the pet a (c)at, (d)og, or (r)abbit?");
            creature = input.nextLine();
        }
        System.out.println("What is the breed of the pet?");
        String breed = input.nextLine();
        System.out.println ("What is the pet's name?");
        String name = input.nextLine();
        String gender = "";
        while(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")){
            System.out.println("What is the pet's gender? (m/f)");
            gender = input.nextLine();
        }
        String regdue = "";
        while(!isValidDate(regdue)){
            System.out.println("When is the animal's first registration? (DD MMM YYYY)");
            regdue = input.nextLine();
        }
        String dob = "";
        while(!isValidDate(dob)){
            System.out.println("What is the animal's date of birth? (DD MMM YYYY)");
            dob = input.nextLine();
        }
        String chipped = "";
        if(creature.equals("r")){
            while(!chipped.equalsIgnoreCase("y") && !chipped.equalsIgnoreCase("n")){
                System.out.println ("Is the pet microchipped (y)es or (n)o?");
                chipped = input.nextLine();
            }
        }
        int microchip = 0;
        if(chipped.equalsIgnoreCase("y") || !creature.equalsIgnoreCase("r")){
            while(microchip <= 0){
                System.out.println("Microchip number of animal?");
                microchip = input.nextInt();
            }
        }
        switch (creature.toLowerCase()) {
            case "d":
                System.out.println("Has the animal been desexed? (true/false)");
                boolean desexed = input.nextBoolean();
                System.out.println("Has the animal been vaccinated? (true/false)");
                boolean vaccinated = input.nextBoolean();
                return new Dog(breed, name, gender, regdue, dob, microchip, desexed, vaccinated);
            case "c":
                return new Cat(breed, name, gender, dob, regdue, microchip);
            case "r":
                return new Rabbit(breed, name, gender, dob, regdue, microchip);
        }
        return null;
    }
    /**
     * To generate a course.
     * @return A new course object
     */
    private Course courseWizard () {
        System.out.println("Enter the Name of new course:");
        String tempCourseName = input.nextLine();
		String courseName = "";
		if (tempCourseName.length() <= 0 )
        {        	
        	System.out.println("Course Name must be greater than 0 letters, Enter Name Again if name is left blank Name Will be set Blank: "); // checks with the user if the course being blank is ok 
        	courseName = input.nextLine();
        }
		else {
			courseName = tempCourseName;
		}
        System.out.println("Enter the price of " + courseName + ":");
        float coursePrice = input.nextFloat();
        System.out.println("Enter the runtime of " + courseName + ":");
        int courseRuntime = input.nextInt();
        System.out.println("Enter the lecturer's id for " + courseName +":");
        int courseLecturerID = input.nextInt();
        return new Course(courseLecturerID, courseName, coursePrice, courseRuntime);

    }
    /**
     * To enroll a person into a course
     */
    private void enrollmentWizard () {
        int studentID;
        int courseID;
        if(!pMain.personList.isEmpty()){
            for (Person person: pMain.personList) {
                System.out.println("ID " + person.getPersonID() + ": " + person.getName());
            }
            System.out.println("Enter the ID of the student");
            studentID = input.nextInt();
            if(!cMain.courseList.isEmpty()) {
                for (Course course : cMain.courseList) {
                    System.out.println("ID: " + course.getID() + " Name: " + course.getName());
                }
                System.out.println("Enter the ID of the course you wish to enrol them in: ");
                courseID = input.nextInt();
                cMain.courseList.get(courseID).enrollstudent(pMain.personList.get(studentID));
                pMain.personList.get(studentID).enrollInCourse(cMain.courseList.get(courseID)); // Gets the selected user and than enrolls them into the selected course
            }else {
                System.out.println("Please add a Course first!");
            }
        }else {
            System.out.println("Please add a Person first!");
        }
    }
    /**
     * To check if a date matches the format criteria
     * @param date this is the date to be checked
     * @return A new true or false boolean
     */
    private static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }
    /**
     * To return the user to the menu
     */
    private void menuReturn(){
        try {
            System.out.println("Click enter to return to the menu");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}