import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    int attendees = 0;

    System.out.println("Welcome to the Event Planner.");
    System.out.println("How many people are attending your event?");
    attendees = myScanner.nextInt();

    while (attendees <= 0) {
      System.out.println("That's not enough people! How many people are ACTUALLY attending your event?");
      attendees = myScanner.nextInt();
    }

    System.out.println("Great.");
  }
}
