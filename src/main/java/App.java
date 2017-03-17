import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    int attendees = 0;

    System.out.println("Welcome to the Event Planner.");
    System.out.println("How many people are attending your event?");

    while (attendees == 0) {
      try {
        String attendeesString = myScanner.next();
        attendees = Integer.parseInt(attendeesString);
        if (attendees <= 0) {
          attendees = 0;
          System.out.println("That's not enough people! How many people are ACTUALLY attending your event?");
        } else {
          System.out.println("Great, thanks!");
        }
      } catch (NumberFormatException ex) {
        System.out.println("That's not an number! Try again.");
      }
    }

    System.out.println("You're event will have " + attendees + " guests.");
    // while (attendees <= 0) {
    //   System.out.println("That's not enough people! How many people are ACTUALLY attending your event?");
    //   attendees = Integer.parseInt(myScanner.next());
    // }

  }
}
