package lab1ass;


import java.util.Arrays;

public class Dog extends Animal {
    boolean desexed;
    boolean vaccinated;
    Integer microchip;
    String[] restricted_breeds = {
            "American Pit Bull Terrier",
            "Pit Bull Terrier",
            "Dogo Argentino,",
            "Fila Brasileiro",
            "Japanese Tosa",
            "Perro de Presa Canario",
            "Presa Canario"
    };
    
    Dog(String _breed, String _name, String _gender, String _dob, String _regdue, Integer _microchip, boolean _desexed, boolean _vaccinated) {
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

    public void setMicrochip(Integer microchip) throws IllegalArgumentException {
        if (microchip != null){
            this.microchip = microchip;
        } else {
            throw new IllegalArgumentException("Microchip should not be null");
        }
    }

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
