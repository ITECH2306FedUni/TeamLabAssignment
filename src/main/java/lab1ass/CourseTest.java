package lab1ass;
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
        Course ctest = new Course(333, "Eurobeat with BLAN3Y", 148, 12);
        p1test.enrollInCourse(ctest);
        Assert.assertEquals("Course [course=Eurobeat with BLAN3Y, price=148.0, runtime=12, courseID=0]", p1test.currentCourse.toString());
    }
}