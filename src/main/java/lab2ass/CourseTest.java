package lab2ass;

import org.junit.Assert;

/**
 * The Course Test Class
 *
 * @author RAWR-XD
 * @version 1.0
 */
public class CourseTest {

    @org.junit.Test
    public void testAddPerson() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 1000, 148, 9);
        ctest.enrollstudent(p1test);
        Assert.assertEquals("Course [course=Eurobeat with BLAN3Y, students= [Person,Kathleen,25 Somewhere Street,2000,Casey]]", ctest.toStringNameAndPeople());
    }
    @org.junit.Test
    public void testEnrollmentNumbers() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 1000, 148, 9);
        ctest.enrollstudent(p1test);
        Assert.assertEquals(1, ctest.getNumStudents());
    }
    @org.junit.Test
    public void testGetCost() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 1000, 148, 9);
        ctest.enrollstudent(p1test);
        Assert.assertEquals(1000, ctest.getCost(), 1e-15);
    }
    @org.junit.Test
    public void testChangePrice() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Course ctest = new Course(0, "Eurobeat with BLAN3Y", 1000, 148, 9);
        ctest.enrollstudent(p1test);
        Assert.assertEquals(148, ctest.getPrice(), 1e-15);
        ctest.setPrice(200);
        Assert.assertEquals(200, ctest.getPrice(), 1e-15);
    }
}
