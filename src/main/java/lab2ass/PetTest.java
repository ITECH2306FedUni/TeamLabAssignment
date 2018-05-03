package lab2ass;
import org.junit.Assert;
/**
 * The Pet Test Class
 * @author  RAWR-XD
 * @version 1.0
 */
public class PetTest {

    @org.junit.Test
    public void testAddPet()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1testPet = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        p1test.addAPet(p1testPet);
        Assert.assertEquals("Dog [breed=Pug, name=Fido, dob=05 01 1998, gender=F, regdue=05 01 1998, microchip=13, desexed=true, vaccinated=false, registrationID=3]", p1test.pet.toString());
   //testing adding a person to a list 
    }
    @org.junit.Test
    public void testAddPetRestricted()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1testPet = new Dog("Presa Canario", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        p1test.addAPet(p1testPet);
        Assert.assertEquals("Unable to create java.lang.IllegalArgumentException: Dog is on the Restricted Breed's list", p1test.pet.toString());
   //Tests if adding Restricted Breed into the list
    }
    @org.junit.Test
    public void testAddPetFailure()
    {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1testPet = new Dog("Presa Canario", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        p1test.addAPet(p1testPet);
        Assert.assertEquals("Dog [Pug, name=Fido, dob=05 01 1998, gender=F, regdue=05 01 1998, microchip=13, desexed=true, vaccinated=false, registrationID=1]", p1test.pet.toString());
        // testing a failure of adding a pet to a person 
    }
}