import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
import com.google.gson.Gson;


public class AccountManager {
    static Scannner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the fitness tracker, what would you like to do? (1 - Login, 2 - Register)");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                Login();
                Fitness.Tracker();
        }

    }
    //public static void Login();
}
*/

public class Fitness {
    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {
        System.out.println("Welcome to the fitness tracker, what would you like to do? (1 - See schedule, 2 - Schedule An Exercise)");
        input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Which day's would you like to look at? (1 - Monday, 2 - Tuesday, etc)");
                input = scanner.nextLine();
                ViewSchedule(input);
                break;
            case "2":
                AddExercise();
        }
    }

    public static File ViewSchedule(String day) {
        switch (day) {
            default:
                day = "Wednesday";
                break;
            case "1":
                day = "Monday";
                break;
            case "2":
                day = "Tuesday";
                break;
            case "3":
                day = "Wednesday";
                break;
            case "4":
                day = "Thursday";
                break;
            case "5":
                day = "Friday";
        }

        try {
            File file = new File("Test\\" + day + ".txt");
            Scanner scanner = new Scanner(file);
            File test = new File("Monday 2.txt");
            FileWriter writer = new FileWriter(test);
            writer.write("Hello hello hello \n hello");
            writer.close();
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }

    return new File("test.txt");
    }

    static void AddExercise() {
        System.out.println("Which day would you like to change? (1 - Monday, 2 - Tuesday, etc)");
        input = scanner.nextLine();
        File file = ViewSchedule(input);
        System.out.println("\nWhich line would you like to change? (Type the next line number to add)");
        int line = scanner.nextInt();
        scanner.nextLine();
        // Get user's exercise
        String reps;
        String sets;
        String weight;
        System.out.println("Which exercise?");
        input = scanner.nextLine();
        System.out.println("How many sets?");
        sets = scanner.nextLine();
        System.out.println("How many reps?");
        reps = scanner.nextLine();
        System.out.println("How much weight?");
        weight = scanner.nextLine();
        OverWriteLine(line, "- " + sets + " x " + reps + " x " + weight + " " + input, file);
    }

    static void OverWriteLine(int line, String message, File file) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner meh = new Scanner(file);
            while (meh.hasNextLine()) {
                lines.add(meh.nextLine());
            }
            if (line - 1 == lines.size()) {
                lines.add(message);
            }
            else if (line - 1 < lines.size()) {
                lines.set(line - 1, message);
            }
            FileWriter writer = new FileWriter(file);
            for (String i : lines) {
                writer.write(i + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}