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
    Integer registrationID;
    String breed;
    String name;
    String dob;
    String gender;
    String regdue;
    int microchip;

    /**
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     * @param _microchip microchip id for the pet
     */
    Animal(String _breed, String _name, String _gender, String _dob, String _regdue, int _microchip) {
        this.setRegistrationID();
        this.breed = _breed;
        this.name = _name;
        this.gender = _gender;
        this.dob = _dob;
        this.regdue = _regdue;
        this.microchip = _microchip;
    }

    public Integer getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID() { // allocate next available ID
        this.registrationID = nextValidRegistrationID++;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegdue() {
        return regdue;
    }

    public void setRegdue(String regdue) {
        this.regdue = regdue;
    }

    @Override
    public String toString() {
        return "Animal [breed=" + breed
        + ", name=" + name
        + ", dob=" + dob
        + ", gender=" + gender
        + ", regdue=" + regdue
        + ", microchip=" + microchip
        + ", registrationID=" + registrationID
        + "]";
    }

}
