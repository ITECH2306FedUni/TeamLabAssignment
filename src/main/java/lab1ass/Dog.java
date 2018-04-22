package lab1ass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Calendar;

/**
 * The Dog Class
 * @author  RAWR-XD
 * @version 1.0
 */
public class Dog extends Animal {
    private boolean desexed;
    private boolean vaccinated;
    private int microchip;
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
     * To build the animal object
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     * @param _microchip microchip id for the pet
     * @param _desexed desex status of the pet
     * @param _vaccinated vaccine status of the pet
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
    @Override
    public double calcRates () {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

        Calendar regoDate = Calendar.getInstance();
        try {
            regoDate.setTime(format.parse(this.regdue));
        } catch (ParseException e) {
        }

        long regoYear = regoDate.get(Calendar.YEAR);
        System.out.println(regoYear);
        double fee = 20.00;
        if(!isDesexed()){
            fee = fee * 1.33;
        }
        long currentYear = Year.now().getValue();
        if (regoYear == currentYear) {
            return fee;
        }
        for (int i = 0; i < currentYear - regoYear; i++) {
            fee = fee - (fee*0.01);
        }
        return fee;
    }
    /**
     * Return the animal object
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
