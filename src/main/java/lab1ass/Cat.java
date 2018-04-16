package lab1ass;

public class Cat extends Animal {
    Integer microchip;

    public void setMicrochip(Integer microchip) {
        if (microchip != null){
            this.microchip = microchip;
        } // TODO handling
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
