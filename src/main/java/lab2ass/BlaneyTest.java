/**
 *
 */
package lab2ass;

/**
 * @author RAWR xD
 */
public class BlaneyTest {

    /**
     * @param args
     */

    public static void main(String[] args) {

        //Person test
        System.out.println("\n PERSON TEST DATA");
        try {
            // create test case 1 - a person owning a pet dog which is on the restricted list
            Person p1 = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
            Animal p1Pet1 = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
            Animal p1Pet2 = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 14, true, false);
            p1.addAPet(p1Pet1);
            p1.addAPet(p1Pet2);
            System.out.println(" \n I have a first person object : " + p1.toString());
            System.out.println(p1.personPetList);
            for(Animal animal: p1.personPetList) {
                System.out.println(animal.toString());
            }


            } catch (IllegalArgumentException e) {
            System.out.println("Unable to create " + e);
        }
    }
}

