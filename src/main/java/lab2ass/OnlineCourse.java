package lab2ass;

public class OnlineCourse extends Course {
	public OnlineCourse (int _studentID, String _name, double _cost, double _price, int _runtime) {
		super(_studentID, _name, _cost, _price, _runtime);
	}

	@Override
	public double getCost() {
		return 0;
	}
}