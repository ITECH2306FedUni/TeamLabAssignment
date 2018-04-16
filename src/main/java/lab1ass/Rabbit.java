package lab1ass;

public class Rabbit extends Animal {
    Integer microchip;

    public void setMicrochip(Integer microchip) {
        this.microchip = microchip;
    }
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
