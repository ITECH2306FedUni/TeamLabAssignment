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
    public void setBreed(String breed) {
        if (Arrays.asList(restricted_breeds).contains(breed)){
            // restriced breed
            // TODO handling
        } else {
            this.breed = breed;
        }
    }

    public void setMicrochip(Integer microchip) {
        if (microchip != null){
            this.microchip = microchip;
        } // TODO handling
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
