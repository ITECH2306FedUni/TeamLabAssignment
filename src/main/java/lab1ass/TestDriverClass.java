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
    	try {
            // create test case 1 - a person owning a pet dog which is on the restricted list
            Person p1 = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
            Animal p1Pet = new Dog("Presa Canario", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
            p1.addAPet(p1Pet);
            System.out.println(" \n I have a third person object : " + p1.toString());
            System.out.println(" \n They have the pet : " + p1.pet.toString());

            //Create a Course and give it to P1
            Course c1 = new Course(36, "IT_Giggle_Physics", 220, 6);
            p1.enrollInCourse(c1);
            System.out.println(" \n I have a Course Object : " + p1.currentCourse.toString());

        }catch(IllegalArgumentException e){
            System.out.println("Unable to create " + e);
        }

        try {
            // create test case 2 - another person owning a rabbit
            Person p2 = new Person("12 curly avenue", "Fred", "3350", "Casey");
            Animal p2Pet = new Rabbit("American Fuzzy Lop", "Leonard", "F", "05 01 1998", "05 01 1998",0);
            p2.addAPet(p2Pet);
            System.out.println(" \n I have a third person object : " + p2.toString());
            System.out.println(" \n They have the pet : " + p2.pet.toString());
            //Create another Course and give it to P2
            Course c2 = new Course(666, "Garden Time With Nine", 69, 2);
            p2.enrollInCourse(c2);
            System.out.println(" \n I have a Course Object : " + p2.currentCourse.toString());
        }catch(IllegalArgumentException e){
            System.out.println("Unable to create " + e);
        }
        try {
            // create test case 3 - another person owing a pet cat
            Person p3 = new Person("12 curly avenue", "Mark", "3350", "Casey");
            Animal p3Pet = new Cat("Siamese", "Leonard", "F", "05 01 1998", "05 01 1998", 0);
            p3.addAPet(p3Pet);
            System.out.println(" \n I have a third person object : " + p3.toString());
            System.out.println(" \n They have the pet : " + p3.pet.toString());

            //Create Last Course and give it to someone
            Course c3 = new Course(333, "Euro Beat With Blan3y", 148, 12);
            p3.enrollInCourse(c3);
            System.out.println(" \n I have a Course Object : " + p3.currentCourse.toString());
        }catch(IllegalArgumentException e ){
            System.out.println("Unable to create " + e);
        }
    }
}
