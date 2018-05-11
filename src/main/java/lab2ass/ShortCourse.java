package lab2ass;

public class ShortCourse extends Course {
	public ShortCourse (int _studentID, String _name, double _cost, double _price, int _runtime) {
		super(_studentID, _name, _cost, _price, _runtime);
	}

	public int getRuntime () {
		return 3;
	}
}