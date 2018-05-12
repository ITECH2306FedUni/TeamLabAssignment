package lab2ass;

import java.io.Serializable;

/**
 * The Rabbit Class
 * @author  RAWR-XD (Nathan Blaney)
 * @version 1.0
 */
public class Rabbit extends Animal implements Serializable {
    /**
     * To build the rabbit object
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     * @param _microchip microchip id for the pet
     */
    Rabbit(String _breed, String _name, String _gender, String _dob, String _regdue, int _microchip) {
        super(_breed, _name, _gender, _dob, _regdue, _microchip);

    }
    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }
    /**
     * Return the animal object
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + breed + "," + name + "," + dob + "," + gender + "," + regdue + "," + microchip;
    }
}
