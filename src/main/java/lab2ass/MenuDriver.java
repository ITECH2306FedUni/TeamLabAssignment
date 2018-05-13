package lab2ass;


import jdk.nashorn.internal.objects.NativeJSON;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * MenuDriver
 *
 * @author RAWR-XD
 * @version 1.0
 */
public class MenuDriver {
    private static Course cMain = new Course(); // Main Course List
    private static Person pMain = new Person(); // Main Person List
    private DecimalFormat df = new DecimalFormat("0.00");
    private PrintWriter writer = null;
    private boolean stillRunning;
    private boolean subMenu;
    private Scanner input = new Scanner(System.in);
    private String fileName;
private Scanner inputFileLoadStudent;
    // PROGRAM ENTRY POINT:
    public static void main(String[] args) {
        MenuDriver theProgram = new MenuDriver();
        theProgram.start();
    }

    private void start() {
        int choice;
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
        System.out.println("2.  Pet's Menu");
        System.out.println("3.  Courses Menu");
        System.out.println("4.  Student Menu");
        System.out.println("5.  Run system tests");
        System.out.println("6.  Save or Load Person/Pet data");
        System.out.println("8.  Facebook Private Infomation");
        System.out.println("0.  Exit Program");
    }

    /**
     * To dispatch control to a relevant method which handles the user's selected choice.
     *
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
                // menu option 2: pet menu
                subMenu = true;
                while (subMenu) {
                    showPetMenu();
                    int selection = getUserSelection(0, 5);
                    processChoicePetMenu(selection);
                }
                menuReturn();
                break;
            case 3:
                // menu option 3: course menu
                subMenu = true;
                while (subMenu) {
                    showCourseMenu();
                    int selection = getUserSelection(0, 10);
                    processChoiceCourseMenu(selection);
                }
                break;
            case 4:
                // menu option 4: student menu
                subMenu = true;
                while (subMenu) {
                    showStudentMenu();
                    int selection = getUserSelection(0, 9);
                    processChoiceStudentMenu(selection);
                }
                break;
            case 5:
                //menu option 5: system testor
                System.out.println("Running Person Test's");
                TestDriverClass.runTestPerson(null);
                System.out.println("Running Pet Test's");
                TestDriverClass.runTestPet(null);
                System.out.println("Running Course Test's");
                TestDriverClass.runTestCourse(null);
                menuReturn();
                break;
            case 6:
                //menu option 6: save/load data
                System.out.println("What would you like to (s)ave or (l)oad data?");
                String fileChoice = input.nextLine();
                if (fileChoice.equalsIgnoreCase("s")) {
                    try {
                        fileName = "PersonAndPetData.txt";
                        writer = new PrintWriter(fileName, "UTF-8");
                    } catch (FileNotFoundException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (!pMain.personList.isEmpty()) {
                        for (Person person : pMain.personList) {
                            writer.println(person);
                            if (person.hasPet()) {
                                for (Animal pet : person.personPetList) {
                                    writer.println(pet.toString());
                                }
                            }
                        }
                    }
                    writer.close();
                    System.out.println("The People and Pet data been saved under the name: " + fileName.replaceAll("\\s", ""));
                } else if  (fileChoice.equalsIgnoreCase("l")){
                    fileName = "PersonAndPetData.txt";
                    String line = "";
                    String cvsSplitBy = ",";

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(cvsSplitBy);
                            if(data[0].equalsIgnoreCase("person")){
                                Person person = new Person(data[2],data[1],data[3],data[4]);
                                pMain.addPerson(person);
                            }
                            Person person = pMain.personList.get(pMain.personList.size()-1);
                            if(data[0].equalsIgnoreCase("cat")) {
                                person.addAPet(new Cat(data[1],data[2],data[3],data[4],data[5],Integer.valueOf(data[6])));
                            } else if(data[0].equalsIgnoreCase("dog")) {
                                person.addAPet(new Dog(data[1],data[2],data[3],data[4],data[5],Integer.valueOf(data[6]), Boolean.getBoolean(data[7]), Boolean.getBoolean(data[8])));
                            } else if(data[0].equalsIgnoreCase("rabbit")) {
                                person.addAPet(new Rabbit(data[1],data[2],data[3],data[4],data[5],Integer.valueOf(data[6])));
                            }
                        }
                        System.out.println("People and Pet data has been loaded from: "+ fileName.replaceAll("\\s", ""));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                menuReturn();
                break;
            case 7:
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
                if (quitChoice.equalsIgnoreCase("y")) {
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
     *
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
     *
     * @return A new person object
     */
    private Person personWizard() {
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

    private void showCourseMenu() {
        System.out.println();
        System.out.println("1.  Create a new Course offering");
        System.out.println("2.  View Course Details");
        System.out.println("3.  Delete current Course offering");
        System.out.println("4.  Enroll a Student in a Course");
        System.out.println("5.  Generate a list of all Courses");
        System.out.println("6.  Generate Expenses Report");
        System.out.println("7.  Edit Course Data");
        System.out.println("8.  Save Course Schema");
        System.out.println("9.  Load Course Schema");
        System.out.println("10. Generate Expenses Report From Course Schema");
        System.out.println("0.  Return to the Main Menu");
    }

    private void showStudentMenu() {
        System.out.println();
        System.out.println("1.  View all Students");
        System.out.println("2.  Generate Invoice");
        System.out.println("3.  Enter In Results");
        System.out.println("4.  View Results");
        System.out.println("5.  View Text Doc");
        System.out.println("6.  Save A Student");
        System.out.println("7.  Delete A Student ");
        System.out.println("8.  Load A Student");
        System.out.println("0.  Return to the Main Menu");

    }

    private void processChoiceStudentMenu(int choice) {
        switch (choice) {
            case 1:

                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        if (!person.CourseList.isEmpty()) {
                            System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                        }
                    }
                }
                break;
            case 2:
                if ((!pMain.personList.isEmpty()) && (!cMain.courseList.isEmpty())) {
                    System.out.println("");
                    for (Person person : pMain.personList) {
                        if (!person.CourseList.isEmpty()) {
                            System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                        }
                    }
                    System.out.println();
                    System.out.println("Enter Student ID:");
                    int ID = input.nextInt(); // obtain the city
                    generateStudentInvoice(ID);
                } else {
                    System.out.println("No Students or Courses");


                }
                break;
            case 3:
                if ((!pMain.personList.isEmpty()) && (!cMain.courseList.isEmpty())) {
                    System.out.println("");
                    for (Person person : pMain.personList) {
                        if (!person.CourseList.isEmpty()) {
                            System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                        }
                    }  
                    System.out.println();
                    System.out.println("Enter Student ID:");
                    int ID1 = input.nextInt();
                    for (Course course : pMain.personList.get(ID1).CourseList) {
                        System.out.println("ID " + course.toStringShort());
                        
                    }
                    System.out.println("Enter Course ID:");
                    int courseID = input.nextInt();
                    System.out.println("Enter In Result:");
                    float result = input.nextFloat();
                    pMain.personList.get(ID1).CourseList.get(courseID).result = result;
                } else {
                    System.out.println("No Students or Courses");


                }
                break;
            case 4:
                if ((!pMain.personList.isEmpty()) && (!cMain.courseList.isEmpty())) {
                    System.out.println("");
                    for (Person person : pMain.personList) {
                        if (!person.CourseList.isEmpty()) {
                            System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                        }
                    }
                    System.out.println("");
                    System.out.println("Enter Student ID:");
                    int ID2 = input.nextInt();
                    for (Course course : pMain.personList.get(ID2).CourseList) {
                        System.out.println("ID " + course.toStringShort());
                        
                    }
                    for (Course course : cMain.courseList) {
                        if (!course.courseList.isEmpty()) {
                            System.out.println("ID " + course.getID() + ": " + course.getName());
                        }
                    }
                    System.out.println("Enter Course ID:");
                    int courseID1 = input.nextInt();
                    System.out.println(pMain.personList.get(ID2).CourseList.get(courseID1).result);
                    break;

                } else {
                    System.out.println("No Students or Courses");


                }
            case 5:
                Scanner inputFile = null;
                try {
                    inputFile = new Scanner(new File("StudentInvoice.txt"));
                } catch (FileNotFoundException e) {
                    // 
                    e.printStackTrace();
                }
                String firstline = inputFile.nextLine();
                System.out.println("Data: " + firstline);
                String firstline2 = inputFile.nextLine();
                System.out.println("Data: " + firstline2);
                break;

            case 6:
                System.out.println("");

                System.out.println("Enter Student ID:");
                try {
                int ID1StudentSave = input.nextInt();
                
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("StudentSave.txt", "UTF-8");
                } catch (FileNotFoundException | UnsupportedEncodingException e) {
                    // 
                    e.printStackTrace();
                }
                writer.println(pMain.personList.get(ID1StudentSave).getName());
                System.out.println(pMain.personList.get(ID1StudentSave).getName());
                for (Course course : pMain.personList.get(ID1StudentSave).CourseList) {
                     {
                    	writer.println("Break");
                        writer.println(course.getName());
                    }
                }
                } catch (java.lang.IndexOutOfBoundsException exception)
                {System.out.println("No Name by that ID");
                	break;}
                writer.close(); 
                break;
            case 7:
                System.out.println("");
                for (Person person : pMain.personList) {
                    System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                }
                System.out.println();
                System.out.println("Enter In Student ID");
                int studentDelID = input.nextInt();
                for (Course course : pMain.personList.get(studentDelID).CourseList) {
                    System.out.println("ID " + course.toStringShort());
                    
                }
                System.out.println("Enter In Course ID");
                int studentDelIDCourse = input.nextInt();
                pMain.personList.get(studentDelID).CourseList.remove(studentDelIDCourse);
                break;
            case 8:
               inputFileLoadStudent = null;
                try {
                    inputFileLoadStudent = new Scanner(new File("StudentSave.txt"));
                } catch (FileNotFoundException e) {
                    // 
                    e.printStackTrace();
                }
                String name = inputFileLoadStudent.nextLine();
                for (Person person : pMain.personList) {
                     {

                        if (name.equals(person.getName()))
                        {
                        	System.out.println("Data Found:  " + name);
                        }
                    }
                }
                if (inputFileLoadStudent.nextLine().equals("Break"))
                {
                	System.out.println("Break Found");
                	nextbreak(name);
                }
               
    
              
                break;
            case 9:
                break;
            case 0:
                subMenu = false;
                menuReturn();
                break;
        }

    }
private void nextbreak(String name)
{
	String nextlineString = inputFileLoadStudent.nextLine();
	String namesave = name;
	System.out.println("READING BREAK");
	System.out.println(nextlineString);
	  for (Course course : cMain.courseList) {
         if (course.getName().equals(nextlineString)) 
         {
        	 int courseIDPos = course.getID() - 1;
        	 for (Person person : pMain.personList) {
                if(person.getName().equals(name))
                {
                	person.enrollInCourse(cMain.courseList.get(courseIDPos));
                }
          }
      }
	}
if (inputFileLoadStudent.hasNextLine())
{
System.out.println("New Line Found");
nextbreak(namesave);

}
	  

}
    private void processChoiceCourseMenu(int choice) {
        switch (choice) {
            case 1:
                //create new course
                Course c = courseWizard();
                cMain.diffrentCourses(c);
                System.out.println("New course : " + c.toString());
                menuReturn();
                break;
            case 2:
                //get course details
                if (!cMain.courseList.isEmpty()) {
                    int index = 0;
                    for (Course course : cMain.courseList) {
                        System.out.println(index+". "+course.getName());
                        index++;
                    }
                    int selectCourse = getUserSelection(0, index--);
                    System.out.println(cMain.courseList.get(selectCourse).toString());
                } else {
                    System.out.println("Please add a Course first!");
                }
                menuReturn();
                break;
            case 3:
                //delete a course
                //FIXME: this should be a method at some point
                if (!cMain.courseList.isEmpty()) {
                    int index = 0;
                    for (Course course : cMain.courseList) {
                        System.out.println(index+". "+course.getName());
                        index++;
                    }
                    int pos = getUserSelection(0, index--);
                    cMain.courseList.remove(pos);
                } else {
                    System.out.println("No courses in record");
                }
                menuReturn();
                break;
            case 4:
                // enroll a student in a course
                enrollmentWizard();
                menuReturn();
                break;
            case 5:
                // generate a list of courses
                for (Course course : cMain.courseList) {
                    System.out.println(course.toString());
                }
                menuReturn();
                break;
            case 6:
                // generate expenses report
                System.out.println (cMain.reportHeader());
                double totalExpenditure = 0;
                double totalEarnings = 0;
                for(Course course:cMain.courseList) {
                    System.out.println (course.reportLine());
                    totalExpenditure -= course.getCost();
                    totalEarnings += course.getEarnings();
                }
                double netProfit = totalEarnings - totalExpenditure;
                System.out.println(cMain.reportFooter(totalExpenditure,totalEarnings,netProfit));
                break;
            case 7:
                // edit course
                break;
            case 8:
                // save course
                cMain.saveCourses();
                menuReturn();
                break;
            case 9:
                // load course
                cMain.setCourses(cMain.loadCourses());
                menuReturn();
                break;
            case 10:
                // expenses from file
                break;
            case 0:
                // return to menu
                subMenu = false;
                menuReturn();
                break;
            default:
                //error
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        }
    }

    /**
     * To present the sub pet menu/list of options to the user.
     * @author RAWR-XD (Nathan Blaney)
     */
    private void showPetMenu() {
        System.out.println();
        System.out.println("1.  Register new Pet");
        System.out.println("2.  List Pet(s)");
        System.out.println("3.  Modify Pet(s)");
        System.out.println("4.  Remove Pet(s)");
        System.out.println("5.  Generate Registration Costs");
        System.out.println("0.  Exit");
    }
    /**
     *
     * To process the sub pet menu/list of options to the user.
     * @author RAWR-XD (Nathan Blaney)
     */
    private void processChoicePetMenu(int choice) {
        switch (choice) {
            case 1:
                // menu option 1: register pet
                //print a list of people
                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    //figure out who to give a pet to
                    Person petOwner = pMain.personList.get(getUserSelection(0, pMain.personList.size() - 1));
                    //add dat pet
                    petOwner.addAPet(petWizard());
                    System.out.println("The added pet is: " + petOwner.pet.toString());
                    System.out.println("For the Person: " + petOwner.getName());
                } else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 2:
                // menu option 2: list pet(s)
                //print a list of pet(s) for a person
                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    Person petOwner = pMain.personList.get(getUserSelection(0, pMain.personList.size() - 1));
                    if (petOwner.hasPet()) {
                        System.out.println(petOwner.getName() + " has the following pet(s)");
                        for (Animal pet : petOwner.personPetList) {
                            System.out.println("A " + pet.getType() + ", " + pet.getName() + " the " + pet.getBreed());
                        }
                    } else {
                        System.out.println(petOwner.getName() + " does not own a pet!");
                    }

                } else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 3:
                // menu option 3: modify pet(s)
                //print a list of pet(s) for a person then give the option to modify
                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    Person petOwner = pMain.personList.get(getUserSelection(0, pMain.personList.size() - 1));
                    if (petOwner.hasPet()) {
                        int index = 0;
                        System.out.println(petOwner.getName() + " has the following pet(s)");
                        for (Animal pet : petOwner.personPetList) {
                            System.out.println("A " + pet.getType() + ", " + pet.getName() + " the " + pet.getBreed() + " (" + index++ + ")");
                        }
                        System.out.println("Please enter the Pets ID");
                        int pos = input.nextInt();
                        input.nextLine();
                        Animal pet = petOwner.personPetList.get(pos);
                        if (pet.getType().equalsIgnoreCase("dog")) {
                            Dog dog = (Dog) pet;
                            System.out.println(dog.getName() + " is currently listed as desexed being " + dog.isDesexed());
                            System.out.println("Has the animal been desexed? (true/false)");
                            dog.setDesexed(input.nextBoolean());
                            System.out.println(dog.getName() + " is currently listed as vaccinated being " + dog.isVaccinated());
                            System.out.println("Has the animal been vaccinated? (true/false)");
                            dog.setVaccinated(input.nextBoolean());
                        } else {
                            System.out.println("Currently only dog entries can be altered");
                        }
                    } else {
                        System.out.println(petOwner.getName() + " does not own a pet!");
                    }

                } else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 4:
                // menu option 4: remove pet(s)
                //print a list of pet(s) for a person then give the option to remove
                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    Person petOwner = pMain.personList.get(getUserSelection(0, pMain.personList.size() - 1));
                    if (petOwner.hasPet()) {
                        int index = 0;
                        System.out.println(petOwner.getName() + " has the following pet(s)");
                        for (Animal pet : petOwner.personPetList) {
                            System.out.println("A " + pet.getType() + ", " + pet.getName() + " the " + pet.getBreed() + " (" + index++ + ")");
                        }
                        System.out.println("Please enter the Pets ID");
                        int pos = input.nextInt();
                        input.nextLine();
                        System.out.println("Are you sure you want to remove the pet (y)es or (n)o?");
                        String quitChoice = input.nextLine();
                        if (quitChoice.equalsIgnoreCase("y")) {
                            petOwner.personPetList.remove(pos);
                        } else {
                            menuReturn();
                        }
                    } else {
                        System.out.println(petOwner.getName() + " does not own a pet!");
                    }

                } else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                menuReturn();
                break;
            case 5:
                // menu option 5: calculate rego
                if (!pMain.personList.isEmpty()) {
                    for (Person person : pMain.personList) {
                        System.out.println("ID " + person.getPersonID() + ": " + person.getName());
                    }
                    System.out.println("Please enter a Person's ID");
                    Person ratePayer = pMain.personList.get(getUserSelection(0, pMain.personList.size() - 1));
                    if (ratePayer.hasPet()) {
                        try {
                            fileName = "RegoInvoice" + ratePayer.getName() + ".txt";
                            writer = new PrintWriter(fileName.replaceAll("\\s", ""), "UTF-8");
                        } catch (FileNotFoundException | UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        double totalRate = 0;
                        System.out.println(ratePayer.getName() + " has " + ratePayer.personPetList.size() + " pet(s)");
                        writer.println(ratePayer.getName() + " has " + ratePayer.personPetList.size() + " pet(s)");
                        for (Animal pet : ratePayer.personPetList) {
                            System.out.println(pet.getName() + " the " + pet.getBreed() + ", a type of " + pet.getType());
                            writer.println(pet.getName() + " the " + pet.getBreed() + ", a type of " + pet.getType());
                            System.out.println(pet.getName() + " was first registered: " + pet.regdue);
                            writer.println(pet.getName() + " was first registered: " + pet.regdue);
                            System.out.println("The rate to pay is: " + df.format(pet.calcRates()));
                            writer.println("The rate to pay is: " + df.format(pet.calcRates()));
                            totalRate = totalRate + pet.calcRates();
                        }
                        System.out.println("Total rates to pay is " + df.format(totalRate));
                        System.out.println("A Text version of this invoice has been saved under the name: " + fileName.replaceAll("\\s", ""));
                        writer.println("Total rates to pay is " + df.format(totalRate));
                    } else {
                        System.out.println(ratePayer.getName() + " does not own a pet!");
                    }
                } else {
                    System.out.println("Please add a Person first!");
                    menuReturn();
                    break;
                }
                writer.close();
                menuReturn();
                break;
            case 0:
                // return to menu
                subMenu = false;
                menuReturn();
                break;
            default:
                //error
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        }
    }

    /**
     * Wrap Animal creation method in command line interface
     *
     * @return A new pet object
     */
    private Animal petWizard() {
        String creature = "";
        while (!creature.equalsIgnoreCase("c") && !creature.equalsIgnoreCase("d") && !creature.equalsIgnoreCase("r")) {
            System.out.println("Is the pet a (c)at, (d)og, or (r)abbit?");
            creature = input.nextLine();
        }
        System.out.println("What is the breed of the pet?");
        String breed = input.nextLine();
        System.out.println("What is the pet's name?");
        String name = input.nextLine();
        String gender = "";
        while (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            System.out.println("What is the pet's gender? (m/f)");
            gender = input.nextLine();
        }
        String regdue = "";
        while (!isValidDate(regdue)) {
            System.out.println("When is the animal's first registration? (DD MMM YYYY)");
            regdue = input.nextLine();
        }
        String dob = "";
        while (!isValidDate(dob)) {
            System.out.println("What is the animal's date of birth? (DD MMM YYYY)");
            dob = input.nextLine();
        }
        String chipped = "";
        if (creature.equals("r")) {
            while (!chipped.equalsIgnoreCase("y") && !chipped.equalsIgnoreCase("n")) {
                System.out.println("Is the pet microchipped (y)es or (n)o?");
                chipped = input.nextLine();
            }
        }
        int microchip = 0;
        if (chipped.equalsIgnoreCase("y") || !creature.equalsIgnoreCase("r")) {
            while (microchip <= 0) {
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
     *
     * @return A new course object
     */
    private Course courseWizard() {
        String type = "";
        while (!type.equalsIgnoreCase("c") && !type.equalsIgnoreCase("s") && !type.equalsIgnoreCase("e") && !type.equalsIgnoreCase("o")) {
            System.out.println("What type of course do you wish to create?");
            System.out.println("(C)ourse, (S)hortcourse, (E)vening course, or (O)nline Course");
            type = input.nextLine();
        }
        String courseName = "";
        while (courseName.length() <= 0) {
            System.out.println("Enter the Name of new course:");
            courseName = input.nextLine();
        }
        double courseCost = 0.0;
        if (!type.toLowerCase().equals("o")) {
            System.out.println("enter the cost of" + courseName + "to run");
            courseCost = input.nextDouble();
        }
        System.out.println("Enter the price of " + courseName + ":");
        double coursePrice = input.nextDouble();
        System.out.println("Enter the runtime of " + courseName + ":");
        int courseRuntime = input.nextInt();
        System.out.println("Enter the lecturer's id for " + courseName + ":");
        int courseLecturerID = input.nextInt();
        switch (type.toLowerCase()) {
            case "c":
                return new Course(courseLecturerID, courseName, courseCost, coursePrice, courseRuntime);
            case "s":
                return new ShortCourse(courseLecturerID, courseName, courseCost, coursePrice, courseRuntime);
            case "e":
                return new EveningCourse(courseLecturerID, courseName, courseCost, coursePrice, courseRuntime);
            case "o":
                return new OnlineCourse(courseLecturerID, courseName, 0.0, coursePrice, courseRuntime);
        }
        return null;

    }

    /**
     * To enroll a person into a course
     */
    private void enrollmentWizard() {
        int studentID;
        int courseID;
        if (!pMain.personList.isEmpty()) {
            for (Person person : pMain.personList) {
                System.out.println("ID " + person.getPersonID() + ": " + person.getName());
            }
            System.out.println("Enter the ID of the student");
            studentID = input.nextInt();
            if (!cMain.courseList.isEmpty()) {
                for (Course course : cMain.courseList) {
                    System.out.println("ID: " + course.getID() + " Name: " + course.getName());
                }
                System.out.println("Enter the ID of the course you wish to enrol them in: ");
                courseID = input.nextInt();
                cMain.courseList.get(courseID).enrollstudent(pMain.personList.get(studentID));
                pMain.personList.get(studentID).enrollInCourse(cMain.courseList.get(courseID)); // Gets the selected user and than enrolls them into the selected course
            } else {
                System.out.println("Please add a Course first!");
            }
        } else {
            System.out.println("Please add a Person first!");
        }
    }

    /**
     * To check if a date matches the format criteria
     *
     * @param date this is the date to be checked
     * @return A new true or false boolean
     */
    private static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Is this string a double
     *
     * @param dub the double to check
     * @return A boolean
     */
    private boolean isDouble(String dub) {
        try {
            Double.parseDouble(dub);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Is this string an int
     *
     * @param wint the int to check
     * @return A boolean
     */
    private boolean isInt(String wint) {
        try {
            Double.parseDouble(wint);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void generateStudentInvoice(int ID) {
    	double priceInvoiceGen = 0.00;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("StudentInvoice.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

            e.printStackTrace();
        }


        if (!pMain.personList.get(ID).CourseList.isEmpty()) {
        	writer.println("### Course Invoice For " + pMain.personList.get(ID).getName() + " ###");
            for (Course course : pMain.personList.get(ID).CourseList) {
            	priceInvoiceGen += course.getPrice();
                writer.println("Course ID: "+course.getID() + " Course Name: " +  course.getName() + " Course Price: $" + course.getPrice() +" Course Runtime: " + course.getRuntime() + " Course Type: " + course.getClass());
            }
            writer.println("Final Total: $" + priceInvoiceGen);
        }

        writer.close();

    }

    private void menuReturn() {
        try {
            System.out.println("Click enter to return to the menu");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}