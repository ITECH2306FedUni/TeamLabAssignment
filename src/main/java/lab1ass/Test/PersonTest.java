package lab1ass.Test;
import org.junit.Assert;

import lab1ass.Person;

public class PersonTest {

    @org.junit.Test
    public void testAddPerson()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Assert.assertEquals("Person [name=Kathleen, address=25 Somewhere Street, postcode=2000]", p1test.toString());
    }
}
