package lab1ass.Test;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class CityTestRunner {
    public static void runTests(String[] args) {
        Result result = JUnitCore.runClasses(PersonTest.class, PetTest.class, CourseTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
