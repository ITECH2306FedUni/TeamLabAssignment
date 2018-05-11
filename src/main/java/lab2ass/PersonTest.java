package lab2ass;
import org.junit.Assert;
/**
 * The Person Test Class
 * @author  RAWR-XD
 * @version 1.0
 */
public class PersonTest {

    @org.junit.Test
    public void testAddPerson()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Assert.assertEquals("Kathleen,25 Somewhere Street,2000,Casey", p1test.toString());
        //testing to see if adding a person works 
    }
}