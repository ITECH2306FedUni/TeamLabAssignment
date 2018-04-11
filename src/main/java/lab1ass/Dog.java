package lab1ass;

public class Dog extends Animal {
    /**
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _gender gender of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _regdue date that reg is due DD MMM YYYY
     */
	
	String[] restricted_breeds = {
			"Dogo Argentino",
			"Fila Brasileiro",
			"Japanese Tosa",
			"Perro de Presa Canario",
			"Presa Canario"
	};
	boolean desexed;
	
    public Dog(String _breed, String _name, String _gender, String _dob, String _regdue, boolean _desexed) {
        super(_breed, _name, _gender, _dob, _regdue);
        this.desexed = _desexed;
    }
}
