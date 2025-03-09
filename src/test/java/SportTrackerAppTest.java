import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SportTrackerAppTest {

    @BeforeEach
    public void setup() {
        SportTrackerApp.activies.clear();
        SportTrackerApp.totalTime = 0;
    }

    @Test
    void logActivityTest() {
        long time = System.currentTimeMillis();
        String sportName = "Running";
        int duration = 30;
        String expected = time + "-" + sportName + "-" + duration;
        String result = SportTrackerApp.logActivity(time, sportName, duration);
        assertEquals(expected, result);
        assertEquals(expected, SportTrackerApp.activies.getFirst());

    }



    //    @Disabled
    @Test
    void displayLogActivityTest() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        long time = System.currentTimeMillis();
        SportTrackerApp.logActivity(time, "Running", 30);
        SportTrackerApp.logActivity(time, "Swimming", 45);
//        String expectedStr1 = time+"-"+"-"+
        List<String> activies = SportTrackerApp.activies;
        assertEquals(2, activies.size());
        assertTrue(activies.get(0).contains("Running"));
        assertTrue(activies.get(1).contains("Swimming"));
        SportTrackerApp.displayLogActivity();
        String output = outputStream.toString();
        assertTrue(output.contains(time + "-Running-30"));
        assertTrue(output.contains(time + "-Swimming-45"));
    }


    //    @Disabled
    @Test
    void getTotalTimeSpentTest() {
        long time = System.currentTimeMillis();
        SportTrackerApp.logActivity(time, "Running", 30);
        SportTrackerApp.logActivity(time, "Swimming", 45);
        int totalTime = SportTrackerApp.getTotalTimeSpent();
//        List<String> activies = SportTrackerApp.activies;
        assertEquals(30 + 45, totalTime);
    }

    //    @Disabled
    @Test
    void transformActivityStringTest() {
        String activityString = "123-Swimming-20";
        String[] result = SportTrackerApp.transformActivityString(activityString);
        assertEquals("123", result[0]);
        assertEquals("Swimming", result[1]);
        assertEquals("20", result[2]);
    }
}