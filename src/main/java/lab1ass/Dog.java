package lab1ass;


import java.util.Arrays;

public class Dog extends Animal {
    boolean desexed;
    boolean vaccinated;
    int microchip;
    String[] restricted_breeds = {
            "American Pit Bull Terrier",
            "Pit Bull Terrier",
            "Dogo Argentino,",
            "Fila Brasileiro",
            "Japanese Tosa",
            "Perro de Presa Canario",
            "Presa Canario"
    };
    /**
     METHOD:  Dog Construct
     PURPOSE: To build the animal object
     PASSED:
     @param _breed  breed of the animal
     @param _name   name of the animal
     @param _dob    dob of the animal DD MMM YYYY
     @param _gender gender of the animal
     @param _regdue date that reg is due DD MMM YYYY
     @param _microchip microchip id for the pet
     @param _desexed desex status of the pet
     @param _vaccinated vaccine status of the pet
     RETURNS: Dog Object
     EFFECT:  A dog object is built
     */
    Dog(String _breed, String _name, String _gender, String _dob, String _regdue, int _microchip, boolean _desexed, boolean _vaccinated) {
        super(_breed, _name, _gender, _dob, _regdue, _microchip);
        setBreed(_breed);
        this.desexed = _desexed;
        this.vaccinated = _vaccinated;
        setMicrochip(_microchip);

    }

    public boolean isDesexed() {
        return desexed;
    }

    public void setDesexed(boolean desexed) {
        this.desexed = desexed;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }


    @Override
    public void setBreed(String breed) throws IllegalArgumentException {
        if (Arrays.asList(restricted_breeds).contains(breed)){
            throw new IllegalArgumentException("Dog is on the Restricted Breed's list");
        } else {
            this.breed = breed;
        }
    }

    private void setMicrochip(int microchip) throws IllegalArgumentException {
        if (microchip >= 0){
            this.microchip = microchip;
        } else {
            throw new IllegalArgumentException("Microchip should not be null");
        }
    }
    /**
     METHOD:  toString
     PURPOSE: Return the dog object
     PASSED: null
     RETURNS: Animal Object
     EFFECT:  An dog object in text
     */
    @Override
    public String toString() {
        return "Dog [breed=" + breed
                + ", name=" + name
                + ", dob=" + dob
                + ", gender=" + gender
                + ", regdue=" + regdue
                + ", microchip=" + microchip
                + ", desexed=" + desexed
                + ", vaccinated=" + vaccinated
                + ", registrationID=" + registrationID
                + "]";
    }
}
