package lab1ass.Test;

import org.junit.Assert;

import lab1ass.Course;
import lab1ass.Person;
import lab1ass.*;
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