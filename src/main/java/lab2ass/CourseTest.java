package lab2ass;
import org.junit.Assert;
/**
 * The Course Test Class
 * @author  RAWR-XD
 * @version 1.0
 */
public class CourseTest {

    @org.junit.Test
    public void testAddPerson()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 1000, 148, 9);
        ctest.enrollstudent(p1test);
        Assert.assertEquals("Course [course=Eurobeat with BLAN3Y, price=148.0, runtime=9, courseID=0, students= [Person,Kathleen,25 Somewhere Street,2000,Casey]]", ctest.toString());
        //Tests if the person is added
    }
}
