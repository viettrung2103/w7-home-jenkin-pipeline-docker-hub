import java.util.*;

public class SportTrackerApp {

    public static List<String> activies = new ArrayList<>();
    public static int totalTime = 0;

    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

//        Create a single-class Java application that allows users to log sports activities,
//        view logged activities, and calculate total time spent on sports for the week.

        while (true) {
            System.out.println("Choose option:");
            System.out.println("1. Log activity");
            System.out.println("2. Show activities history");
            System.out.println("3. Display total time spent on sports:");
            System.out.println("4. Quit");

            int option = Integer.parseInt(scanner.nextLine());
            if (option == 4) {
                System.out.println("Thank for using our application");
                return;
            }
            switch (option) {
                case 1:
                    System.out.println("Enter sport name");
                    String sportName = scanner.nextLine();
                    System.out.println("Enter duration");
                    int duration = Integer.parseInt(scanner.nextLine());
                    long time = System.currentTimeMillis();
                    logActivity(time, sportName, duration);
                    break;
                case 2:
                    System.out.println("History:");
                    displayLogActivity();
                    break;
                case 3:
                    int totalTime = getTotalTimeSpent();
                    System.out.println("Total time: " + totalTime);
                    break;
            }

        }
    }

    public static String logActivity(Long time, String sportName, int duration) {
        String mewActivityStr = time + "-" + sportName + "-" + duration;
//        newActivity.put(sportName, time);
        activies.add(mewActivityStr);
        totalTime += duration;
        return mewActivityStr;
    }

    public static void displayLogActivity() {
        for (String activity : activies) {
            String[] formated = transformActivityString(activity);
            long time = Long.parseLong(formated[0]);
            String activityName = formated[1];
            int duration = Integer.parseInt(formated[2]);
            System.out.println(time + "-" + activityName + "-" + duration);
        }
    }

    public static int getTotalTimeSpent() {
        return totalTime;
    }

    public static String[] transformActivityString(String activityString) {
        String[] formated = activityString.split("-");
        return formated;
    }
}
