package lab1ass;


public class Cat extends Animal {
    Integer microchip;
    
    Cat(String _breed, String _name, String _gender, String _dob, String _regdue, Integer _microchip) {
        super(_breed, _name, _gender, _dob, _regdue, _microchip);
        setMicrochip(_microchip);
    }

    public void setMicrochip(Integer microchip) throws IllegalArgumentException {
        if (microchip != null){
            this.microchip = microchip;
        } else {
            throw new IllegalArgumentException("Microchip should not be null");
        }
    }
    public String toString() {
        return "Cat [breed=" + breed
                + ", name=" + name
                + ", dob=" + dob
                + ", gender=" + gender
                + ", regdue=" + regdue
                + ", microchip=" + microchip
                + ", registrationID=" + registrationID
                + "]";
    }
}
