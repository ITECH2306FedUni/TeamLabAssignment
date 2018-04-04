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
		Person p1 = new Person( "25 somewhere Street","Kathleen","2000");
		Animal myPet = new Animal("CockerSpaniel","Fido");
		p1.addAPet(myPet);
		System.out.println("I have a person object : " + p1.toString());
		
		// create test case 2 - another person owing a spider
		Person p2 = new Person("12 curly avenue","Fred", "3350");
		Animal p2Pet = new Animal("Big Mother Fucking Spider","Leonard");
		p2.addAPet(p2Pet);
		System.out.println("I have a second person object : " + p2);

		// create test case 3 - another person owing a pet dog
		Person p3 = new Person("12 curly avenue","Fred", "3350");
		Animal p3Pet = new Animal("Big Mother Fucking Spider","Leonard");
		p3.addAPet(p3Pet);
		System.out.println("I have a second person object : " + p2);
	}

}
