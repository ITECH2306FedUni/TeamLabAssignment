/**
 *
 */
package lab1ass;

/**
 * @author RAWR xD
 */
public class TestDriverClass {

    /**
     * @param args
     */

    public static void main(String[] args) {
    	
    	//Person Test
    	
    	System.out.println("\n PERSON TEST DATA");
    	
        // create test case 1 - a person owning a pet dog
        Person p1 = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1Pet = new Dog();
        p1Pet.setRegistrationID();
        p1Pet.setBreed("Pug");
        p1Pet.setName("Fido");
        p1Pet.setGender("F");
        p1Pet.setDob("05 01 1998");
        p1Pet.setRegdue("05 01 1998");
        ((Dog) p1Pet).setMicrochip(13);
        ((Dog) p1Pet).setDesexed(true);
        ((Dog) p1Pet).setVaccinated(false);
        p1.addAPet(p1Pet);
        System.out.println(" \n I have a third person object : " + p1.toStringPerson());
        System.out.println(" \n They have the pet : " + p1.toStringPet());

      // create test case 2 - another person owning a rabbit
        Person p2 = new Person("12 curly avenue", "Fred", "3350", "Casey");
        Animal p2Pet = new Rabbit();
        p2Pet.setRegistrationID();
        p2Pet.setBreed("American Fuzzy Lop");
        p2Pet.setName("Leonard");
        p2Pet.setGender("M");
        p2Pet.setDob("05 01 1998");
        p2Pet.setRegdue("05 01 1998");
        ((Rabbit) p2Pet).setMicrochip(null);
        p2.addAPet(p2Pet);
        System.out.println(" \n I have a third person object : " + p2.toStringPerson());
        System.out.println(" \n They have the pet : " + p2.toStringPet());

        // create test case 3 - another person owing a pet cat
        Person p3 = new Person("12 curly avenue", "Mark", "3350", "Casey");
        Animal p3Pet = new Cat();
        p3Pet.setRegistrationID();
        p3Pet.setBreed("Siamese");
        p3Pet.setName("Leonard");
        p3Pet.setGender("F");
        p3Pet.setDob("05 01 1998");
        p3Pet.setRegdue("05 01 1998");
        ((Cat) p3Pet).setMicrochip(15);
        p3.addAPet(p3Pet);
        System.out.println(" \n I have a third person object : " + p3.toStringPerson());
        System.out.println(" \n They have the pet : " + p3.toStringPet());

        //Course Test
        
        System.out.println("\n COURSE TEST DATA");
        
        //Create a Course and give it to someone
        Course c1 = new Course(36, "IT_Giggle_Physics", 220, 6);
        p1.enrollInCourse(c1);
        System.out.println(" \n I have a Course Object : " + p1.toStringCourse());
        
       //Create another Course and give it to someone
        Course c2 = new Course(666, "Garden Time With Nine", 69, 2);
        p2.enrollInCourse(c2);
        System.out.println(" \n I have a Course Object : " + p2.toStringCourse());
        
        //Create Last Course and give it to someone
        Course c3 = new Course(333, "Euro Beat With Blan3y", 148, 12);
        p3.enrollInCourse(c3);
        System.out.println(" \n I have a Course Object : " + p3.toStringCourse());
    }

}
