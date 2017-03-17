import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    int attendees = 0;
    int foodMultiplier = 0;

    System.out.println("Welcome to the Event Planner.");
    System.out.println("How many people are attending your event?");

    while (attendees == 0) {
      try {
        String attendeesString = myScanner.nextLine();
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


    System.out.println("What kind of food shall we provide? Snacks ($5/head), Meals ($10/head), Fancy Snacks ($15/head), or Fancy Meals ($20/head)?");


    while (foodMultiplier == 0) {
      String foodChoice = myScanner.nextLine().toUpperCase();
      if (foodChoice.equals("SNACKS")) {
        foodMultiplier = 1;
      } else if (foodChoice.equals("MEALS")) {
        foodMultiplier = 2;
      } else if (foodChoice.equals("FANCY SNACKS")) {
        foodMultiplier = 3;
      } else if (foodChoice.equals("FANCY MEALS")) {
        foodMultiplier = 4;
      } else {
        System.out.println("Invalid option. You must choose a valid food option.");
      }
    }
    System.out.println(foodMultiplier);
  }
}
