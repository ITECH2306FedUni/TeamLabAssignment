/**
 *
 */
package lab1ass;

/**
 * @author RAWR xD
 */
public class Person {
    String name;  // name of person
    String address; // address of person
    String postcode; // postcode of person's address
    String city; // city of person's address
    Animal pet; // associate a pet that is an Animal object with the Person
    Course currentCourse;

    // constructor - create Person given name, address and a Pet object
    /**
     * @param name
     * @param address
     * @param city
     * @param pet
     */
    public Person(String name, String address, String city, Animal pet) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.pet = pet;
    }

    // constructor - create Person given address, name and postcode

    /**
     * @param _address
     * @param _name
     * @param _postcode
     * @param _city
     */
    Person(String _address, String _name, String _postcode, String _city) {
        this.setAddress(_address);
        this.setName(_name);
        this.setPostcode(_postcode);
        this.setCity(_city);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String _name) {
        this.name = _name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String _address) {
        this.address = _address;
    }

    /**
     * @param postcode the postcode to set
     */
    private void setPostcode(String _postcode) {
        this.postcode = _postcode;

    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @param _pet the pet animal to associate
     */
    void addAPet(Animal _pet) {
        this.pet = _pet;
    }

    void enrollInCourse(Course _currentCourse) {
        this.currentCourse = _currentCourse;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", postcode=" + postcode +
                ",\n pet=" + pet + "]";
    }


}
