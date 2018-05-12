package lab2ass;

import java.io.Serializable;

/**
 * The Cat Class
 * @author  RAWR-XD (Nathan Blaney)
 * @version 1.0
 */

public class Cat extends Animal implements Serializable {
    private int microchip;
    /**
     * To build the cat object
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     * @param _microchip microchip id for the pet
     */
    Cat(String _breed, String _name, String _gender, String _dob, String _regdue, int _microchip) {
        super(_breed, _name, _gender, _dob, _regdue, _microchip);
        setMicrochip(_microchip);
    }
    private void setMicrochip(int microchip) throws IllegalArgumentException {
        if (microchip >= 0){
            this.microchip = microchip;
        } else {
            throw new IllegalArgumentException("Microchip should not be null");
        }
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
