package lab2ass;

public class OnlineCourse extends Course {
	public OnlineCourse (int _studentID, String _name, float _price, int _runtime) {
		super(_studentID, _name, _price, _runtime);
	}

	@Override
	public float getCost() {
		return 0;
	}
}