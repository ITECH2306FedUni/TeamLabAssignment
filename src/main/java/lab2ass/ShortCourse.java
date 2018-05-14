package lab2ass;
/**
 * The ShortCourse Class
 * @author  RAWR-XD (Nine)
 * @version 1.0
 */
public class ShortCourse extends Course {
	ShortCourse(int _studentID, String _name, double _cost, double _price, int _runtime) {
		super(_studentID, _name, _cost, _price, _runtime);
	}

	public int getRuntime () {
		return 3;
	}
}