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
	
	public static Person personToAdd = new Person();
    private static int nextValidCourseID = 0;
    ArrayList<Course> courseList = new ArrayList<>();
	private ArrayList<Person> personToaddList = new ArrayList<Person>();
    
    private int courseID; 
    private String name;
    private double price;
    private int runtime;
    private double cost;
    public float result;
    public Course(int _studentID, String _name, double _cost, double _price, int _runtime) {
        int studentID = _studentID;
        this.name = _name;
        this.cost = _cost;
        this.price = _price;
        setRuntime(_runtime);
       // this.runtime = _runtime;
    }

	public Course() {
		this.setCourseID();
	}

	public void finalize() throws Throwable {

    }
    public int getID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
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

    public void setRuntime(int runtime) throws IllegalArgumentException  {
        if (runtime > 0 && runtime <= 10) {
            this.runtime = runtime;
                  } else {
        	throw new IllegalArgumentException("Runtime Can Not be Lower than 0 or Higer than 10"); // makes sure the runtime is greater than 0 and lower than 11
        }
    }

    public String runTimeToString(int runtime) {
        return String.valueOf(runtime);
    }
    private void setCourseID() { // allocate next available ID
        this.courseID = nextValidCourseID++;
      
    }
    public void diffrentCourses(Course courseAddToList)
    {
    	courseList.add(courseAddToList);
    	
    }
    public void enrollstudent(Person personAddToList)
    {
    	personToaddList.add(personAddToList);
    	System.out.println(personAddToList.getName() + " added to course");
    }
    
      

    @Override
    public String toString() {
        return "Course [course=" + name + ", price=" + price + ", runtime=" + runtime + ", courseID=" + courseID +", students= "+ personToaddList.toString() + "]";
    }
    public String toStringNameAndPeople()
    {
    	return "Course [course=" + name + ", students= " + personToaddList.toString() + "]";
    }
    
    public String toStringShort() {
    	return "Course [ID= " + courseID + ", name= " + name + "]" ;
    }

    //load courses from file
    public void loadCourses () {
        System.out.println ("Loading courses...");
        try {
            Scanner input = new Scanner (
                new File("courses.txt")
            );
            while (input.hasNextLine()) {
                System.out.println (input.nextLine());
            }
        } catch (Exception e) {
            System.out.println ("File not Found, please create one");
        }
    }
    
    // Save all courses to a list
    public void saveCourses () {
        System.out.println ("Saving courses...");
        try {
            File saveLocation = new File ("courses.txt");
            PrintWriter output = new PrintWriter (saveLocation);
            for (Course course: this.courseList) {
                System.out.println (course.toString());
                output.println (course.toString());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println ("we didn't find the file we literally just made FFS java");
        }
    }
}