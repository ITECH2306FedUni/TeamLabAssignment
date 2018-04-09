/**
 *
 */
package lab1ass;

/**
 * @author Kkeogh
 */
public abstract class Animal {

    private static int nextValidRegistrationID = 1;
    // General Animal Attributes
    private int registrationID;
    private String breed;
    private String name;
    private String dob;
    private String gender;
    private String regdue;
    // TODO Breed specific attributes
    private String[] allowedAnimals = {"Dog", "Cat", "Rabbit"};
    private String[] restrictedDogBreed = {"American Pit Bull Terrier", "Pit Bull Terrier", "Dogo Argentino, Fila Brasileiro", "Japanese Tosa", "Perro de Presa Canario", "Presa Canario"};
    /**
     * @param _breed breed of the animal
     * @param _name name of the animal
     * @param _dob dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     */
    public Animal(String _breed, String _name, String _gender, String _dob, String _regdue) {
        this.breed = _breed;
        this.name = _name;
        this.gender = _gender;
        this.dob = _dob;
        this.regdue = _regdue;
        this.setRegistrationID();
    }

    private void setRegistrationID() { // allocate next available ID
        this.registrationID = nextValidRegistrationID++;
    }

    @Override
    public String toString() {
        return "Animal [breed=" + breed + ", name=" + name +  ", dob=" + dob +   ", gender=" + gender +  ", regdue=" + regdue + ", registrationID=" + registrationID + "]";
    }

}
