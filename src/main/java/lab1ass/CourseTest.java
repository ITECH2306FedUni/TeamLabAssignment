package lab1ass;
import org.junit.Assert;
/**
 * The Course Test Class
 * @author  RAWR-XD
 * @version 1.0
 */
public class CourseTest {
	private static Course cMain = new Course();
    private static Person pMain = new Person();
    @org.junit.Test
    public void testAddPerson()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        pMain.addPerson(p1test);        
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 148, 9);
        cMain.diffrentCourses(ctest);
        cMain.courseList.get(0).enrollstudent(pMain.personList.get(0));
        pMain.personList.get(0).enrollInCourse(cMain.courseList.get(0));
        Assert.assertEquals("Course [course=Eurobeat with BLAN3Y, price=148.0, runtime=9, courseID=0, students= [Person [name=Kathleen, address=25 Somewhere Street, postcode=2000]]]", cMain.courseList.get(0).toString());
        //Tests if the person is added
        

        //Tests if the person is added
    }
    
    public void testFailRuntimeAddPerson()
    {
    	Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        pMain.addPerson(p1test);        
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 148, -5);
        cMain.diffrentCourses(ctest);
        cMain.courseList.get(0).enrollstudent(pMain.personList.get(0));
        pMain.personList.get(0).enrollInCourse(cMain.courseList.get(0));
        Assert.assertEquals("Unable to create java.lang.IllegalArgumentException: Runtime Can Not be Lower than 0 or Higer than 10", cMain.courseList.get(0).toString());
    //Tests if the runtime is longer than 0
    }
    public void testAddingMultiPeople()
    {
    	  
        Person p2test = new Person("88 Ye Street", "Greg", "9999", "bong");
        pMain.addPerson(p2test);        
        Course c1test = new Course(0, "Eurobeat with BLAN3Y", 148, 9);
        cMain.diffrentCourses(c1test);
        cMain.courseList.get(0).enrollstudent(pMain.personList.get(1));
        pMain.personList.get(1).enrollInCourse(cMain.courseList.get(0));
        Assert.assertEquals("Course [course=Eurobeat with BLAN3Y, price=148.0, runtime=9, courseID=0, students= [Person [name=Kathsleen, address=25 Somewhere Street, postcode=2000]]]", cMain.courseList.toString());
        //Tests if the person is added
    }
    }
