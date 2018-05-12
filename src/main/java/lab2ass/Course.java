package lab2ass;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Course
 *
 * @author  RAWR-XD
 * @version 1.0
 */
public class Course {
    private static int nextValidCourseID = -0;
    ArrayList<Course> courseList = new ArrayList<>();
	private ArrayList<Person> studentList = new ArrayList<Person>();
    
    private int courseID; 
    private String name;
    private double price;
    private int runtime;
    private double cost;
    float result;
    int students;
    public Course(int _studentID, String _name, double _cost, double _price, int _runtime) {
        int studentID = _studentID;
        this.name = _name;
        this.cost = _cost;
        this.price = _price;
        setRuntime(_runtime);
        this.setCourseID();
        this.students = 0;
    }

    void setCourses(ArrayList inputCourses) {
        this.courseList = inputCourses;
    }

	public Course() {
		this.setCourseID();
	}

    int getID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost () {
        return cost;
    }

    public void setCost (double cost) {
        this.cost = cost;
    }

    public int getRuntime() {
        return runtime;
    }

    private void setRuntime(int runtime) throws IllegalArgumentException {
        if (runtime > 0 && runtime <= 10) {
            this.runtime = runtime;
                  } else {
        	throw new IllegalArgumentException("Runtime Can Not be Lower than 0 or Higer than 10"); // makes sure the runtime is greater than 0 and lower than 11
        }
    }

    public String runTimeToString(int runtime) {
        return String.valueOf(runtime);
    }

    private void setCourseID() {
        this.courseID = nextValidCourseID++;
    }

    void diffrentCourses(Course courseAddToList) {
    	courseList.add(courseAddToList);
    }

    void enrollstudent(Person student) {
    	studentList.add(student);
    	System.out.println(student.getName() + " added to course");
    }

    void setNumStudents (int num) {
        this.students = num;
    }

    int getNumStudents () {
        return this.students;
    }

    double getEarnings () {
        return this.price * this.students;
    }
    
    @Override
    public String toString() {
        return "Course [course=" + name + ", price=" + price + ", runtime=" + runtime + ", courseID=" + courseID +", students= "+ studentList.toString() + "]";
    }

    public String toStringNameAndPeople() {
    	return "Course [course=" + name + ", students= " + studentList.toString() + "]";
    }
    
    String toStringShort() {
    	return "Course [ID= " + courseID + ", name= " + name + "]" ;
    }

    public String reportHeader () {
        return "course\texpenditure\tprice\tstudents\tearnings";
    }

    public String reportLine () {
        return this.name+"\t"+this.cost+"\t"+this.price+"\t"+this.students+(this.price*this.students);
    }

    public String reportFooter (double totalExpenditure, double totalEarnings, double totalProfit) {
        return "Spending: "+totalExpenditure+"\tEarnings: "+totalEarnings+"\tProfits: "+totalProfit;
    }

    //load courses from file
    ArrayList loadCourses() {
        System.out.println ("Loading courses...");
        try {
            ArrayList data = new ArrayList();
            Scanner input = new Scanner (
                new File("courses.txt")
            );
            while (input.hasNextLine()) {
                String inputType = input.nextLine();
                int inputID = Integer.parseInt(input.nextLine());
                String inputName = input.nextLine();
                double inputCost = Double.parseDouble(input.nextLine());
                double inputPrice = Double.parseDouble(input.nextLine());
                int inputRuntime = Integer.parseInt(input.nextLine());
                int inputStudents = Integer.parseInt(input.nextLine());
                Course course = null;
                switch (inputType) {
                    case "class lab2ass.Course":
                        course = new Course (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        course.setNumStudents(inputStudents);
                        break;
                    case "class lab2ass.OnlineCourse":
                        course = new OnlineCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        course.setNumStudents(inputStudents);
                        break;
                    case "class lab2ass.ShortCourse":
                        course = new ShortCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        course.setNumStudents(inputStudents);
                        break;
                    case "class lab2ass.EveningCourse":
                        course = new EveningCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        course.setNumStudents(inputStudents);
                        break;
                }
                System.out.println (course.toString());
                data.add(course);
            }
            return data;
        } catch (FileNotFoundException e) {
            System.out.println ("Error: file not found");
        }
        return null;
    }
    
    // Save all courses to a list
    void saveCourses() {
        System.out.println ("Saving courses...");
        try {
            File saveLocation = new File ("courses.txt");
            PrintWriter output = new PrintWriter (saveLocation);
            for (Course course: this.courseList) {
                output.println (course.getClass());
                output.println (course.getID());
                output.println (course.getName());
                output.println (course.getCost());
                output.println (course.getPrice());
                output.println (course.getRuntime());
                output.println (course.getNumStudents());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println ("we didn't find the file we literally just made FFS java");
        }
    }
}