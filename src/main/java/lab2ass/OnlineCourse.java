package lab2ass;

/**
 * The Online Course Class
 *
 * @author RAWR-XD (Nine)
 * @version 1.0
 */
public class OnlineCourse extends Course {
    OnlineCourse(int _studentID, String _name, double _cost, double _price, int _runtime) {
        super(_studentID, _name, _cost, _price, _runtime);
    }

    @Override
    public double getCost() {
        return 0;
    }
}