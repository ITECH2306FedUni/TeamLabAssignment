package lab1ass;

import java.util.ArrayList;
import java.util.List;

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
	ArrayList<Person> personToaddList = new ArrayList<Person>(); 
    
    private int courseID; 
    private String name;
    private float price;
    private int runtime;
    private int studentID;

    public Course(int _studentID, String _name, float _price, int _runtime) {
    	this.studentID = _studentID;
        this.name = _name;
        this.price = _price;
        this.runtime = _runtime;
    }

	public Course() {
		// TODO Auto-generated constructor stub
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        if (runtime > 0 && runtime <= 10) {
            this.runtime = runtime;
        }
    }

    public String runTimeToString(int runtime) {
        return String.valueOf(runtime);
    }
    private void setCourseID() { // allocate next available ID
        this.courseID = nextValidCourseID++;
        System.out.println(this.courseID);
    }
    public void diffrentCourses(Course courseAddToList)
    {
    	courseList.add(courseAddToList);
    	System.out.println("\n " + courseList.toString() + "Yo");//
    	System.out.println(courseList.size());
    }
    public void enrollstudent(Person personAddToList)
    {
    	personToaddList.add(personAddToList);
    	System.out.println(personAddToList.name + " added to course");
    }

    @Override
    public String toString() {
        return "Course [course=" + name + ", price=" + price + ", runtime=" + runtime + ", courseID=" + courseID +", students= "+ personToaddList.toString() + "]";
    }
    
    public String toStringShort() {
    	return "Course [ID= " + courseID + ", name= " + name + "]" ;
    }
}