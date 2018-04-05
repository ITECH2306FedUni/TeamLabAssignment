/**
 *
 */
package lab1ass;

/**
 * @author Kkeogh
 */
public class Animal {

    private String breed;
    private String name;
    private int registrationID;
    private static int nextValidRegistrationID = 1;

    /**
     * @param breed
     * @param name  registrationID - allocated automatically
     */
    public Animal(String _breed, String _name) {
        this.breed = _breed;
        this.name = _name;
        this.setRegistrationID();
    }

    private void setRegistrationID() { // allocate next available ID
        this.registrationID = nextValidRegistrationID++;
    }

    @Override
    public String toString() {
        return "Animal [breed=" + breed + ", name=" + name + ", registrationID=" + registrationID + "]";
    }

}
