package lab1ass;

public class Dog extends Animal {
    /**
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _gender gender of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _regdue date that reg is due DD MMM YYYY
     * @param _desexed whether on not the pet is desexed or not
     */
    boolean desexed;
    boolean vaccinated;
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
        this.desexed = _desexed;
        this.vaccinated = _vaccinated;
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
                + ", registrationID=" + registrationID
                + "]";
    }
}
