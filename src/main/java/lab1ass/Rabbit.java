package lab1ass;

public class Rabbit extends Animal {
    /**
     METHOD:  Rabbit Construct
     PURPOSE: To build the animal object
     PASSED:
     @param _breed  breed of the animal
     @param _name   name of the animal
     @param _dob    dob of the animal DD MMM YYYY
     @param _gender gender of the animal
     @param _regdue date that reg is due DD MMM YYYY
     @param _microchip microchip id for the pet
     RETURNS: Rabbit Object
     EFFECT:  A rabbit object is built
     */
    Rabbit(String _breed, String _name, String _gender, String _dob, String _regdue, int _microchip) {
        super(_breed, _name, _gender, _dob, _regdue, _microchip);

    }
    /**
     METHOD:  toString
     PURPOSE: Return the rabbit object
     PASSED: null
     RETURNS: Animal Object
     EFFECT:  An rabbit object in text
     */
    @Override
    public String toString() {
        return "Rabbit [breed=" + breed
                + ", name=" + name
                + ", dob=" + dob
                + ", gender=" + gender
                + ", regdue=" + regdue
                + ", microchip=" + microchip
                + ", registrationID=" + registrationID
                + "]";
    }
}
