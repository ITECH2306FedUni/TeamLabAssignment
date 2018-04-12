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
        // create test case 1 - a person owning a pet dog
        Person p1 = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1Pet = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true);
        p1.addAPet(p1Pet);
        System.out.println("I have a person object : " + p1.toString());

        // create test case 2 - another person owing a spider
        Person p2 = new Person("12 curly avenue", "Fred", "3350", "Casey");
        Animal p2Pet = new Rabbit("American Fuzzy Lop", "Leonard", "F", "05 01 1998", "05 01 1998",null);
        p2.addAPet(p2Pet);
        System.out.println("I have a second person object : " + p2.toString());

        // create test case 3 - another person owing a pet dog
        Person p3 = new Person("12 curly avenue", "Mark", "3350", "Casey");
        Animal p3Pet = new Cat("Siamese", "Leonard", "F", "05 01 1998", "05 01 1998", 14);
        p3.addAPet(p3Pet);
        System.out.println("I have a third person object : " + p3.toString());
    }

}
