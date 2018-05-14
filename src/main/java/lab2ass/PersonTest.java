package lab2ass;

import org.junit.Assert;

/**
 * The Person Test Class
 *
 * @author RAWR-XD
 * @version 1.0
 */
public class PersonTest {

    @org.junit.Test
    public void testAddPerson() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Assert.assertEquals("Person,Kathleen,25 Somewhere Street,2000,Casey", p1test.toString());
    }
    @org.junit.Test
    public void testPersonHasPetFalse() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Assert.assertFalse(p1test.hasPet());
    }
    @org.junit.Test
    public void testPersonChangeName() {
        Person p1test = new Person("25 Somewhere Street", "Kathlen", "2000", "Casey");
        Assert.assertEquals("Kathlen",p1test.getName());
        p1test.setName("Kathleen");
        Assert.assertEquals("Kathleen",p1test.getName());
    }
}