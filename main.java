
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input grades
        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Mathematics grade: ");
        int sub1 = input.nextInt();

        System.out.print("Enter Programming grade: ");
        int sub2 = input.nextInt();

        System.out.print("Enter English grade: ");
        int sub3 = input.nextInt();

        // Calculate average
        double average = (sub1 + sub2 + sub3) / 3.0;

        // Display results
        System.out.println("\n===== STUDENT RESULTS =====");

        System.out.println("Mathematics: " + sub1);
        System.out.println("Programming: " + sub2);
        System.out.println("English: " + sub3);

        System.out.printf("Average Grade: %.2f%n", average);

        // Determine status
        if (average >= 75) {
            System.out.println("Status: PASSED");
        } else {
            System.out.println("Status: FAILED");
        }

        input.close();
    }
}
