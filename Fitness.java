import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;




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
                break;
        }
    }

    public static void ViewSchedule(String day) {
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
        } catch (IOException e ) {
            e.printStackTrace();
        }

    }

    static void AddExercise() {
        System.out.println("Which day would you like to change? (1 - Monday, 2 - Tuesday, etc)");
        input = scanner.nextLine();
        ViewSchedule(input);
        System.out.println("\nWhich line would you like to change?")
    }
}