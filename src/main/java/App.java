import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    int attendees = 0;
    int foodMultiplier = 0;
    int beverageCost = -1;
    int entertainmentCost = -1;

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
    System.out.println("___________________________________");
    System.out.println("You're event will have " + attendees + " guests.");
    System.out.println("___________________________________");


    System.out.println("What kind of food shall we provide?");

    String foodChoice = "";
    while (foodMultiplier == 0) {
      System.out.println("SNACKS ($5/head), MEALS ($10/head), FANCY SNACKS ($15/head), or FANCY MEALS ($20/head)");
      foodChoice = myScanner.nextLine().toUpperCase();
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
    System.out.println("___________________________________");
    System.out.println("You choose " + foodChoice + " as your food option.");
    System.out.println("___________________________________");


    System.out.println("What about tasty beverages?");

    String beverageChoice = "";
    while (beverageCost == -1) {
      System.out.println("SODA ($1/head), BEER AND WINE ($4/head), FULL BAR ($7/head), WATER (free!), or NONE");
      beverageChoice = myScanner.nextLine().toUpperCase();
      if (beverageChoice.equals("SODA")) {
        beverageCost = 1;
      } else if (beverageChoice.equals("BEER AND WINE")) {
        beverageCost = 4;
      } else if (beverageChoice.equals("FULL BAR")) {
        beverageCost = 7;
      } else if (beverageChoice.equals("WATER") || beverageChoice.equals("NONE")) {
        beverageCost = 0;
      } else {
        System.out.println("Invalid option. You must choose a valid beverage option.");
      }
    }
    System.out.println("___________________________________");
    System.out.println("You choose " + beverageChoice + " as your beverage option.");
    System.out.println("___________________________________");


    System.out.println("Finally, what type of entertainment would you like at your event?");

    String entertainmentChoice = "";
    while (entertainmentCost == -1) {
      System.out.println("POP STAR ($30,000), INDIE BAND ($2000), DJ ($500), KARAOKE ($60), or NONE");
      entertainmentChoice = myScanner.nextLine().toUpperCase();
      if (entertainmentChoice.equals("POP STAR")) {
        entertainmentCost = 30000;
      } else if (entertainmentChoice.equals("INDIE BAND")) {
        entertainmentCost = 2000;
      } else if (entertainmentChoice.equals("DJ")) {
        entertainmentCost = 500;
      } else if (entertainmentChoice.equals("KARAOKE")) {
        entertainmentCost = 60;
      } else if (entertainmentChoice.equals("NONE")) {
        entertainmentCost = 0;
      }
    }
    System.out.println("___________________________________");
    System.out.println("You choose " + entertainmentChoice + " as your entertainment option.");
    System.out.println("___________________________________");

    Event newEvent = new Event(attendees, foodMultiplier, beverageCost, entertainmentCost);
    int totalPrice = newEvent.calculatePrice();
    System.out.println("This event sounds amazing! And it's only going to cost you $" + totalPrice + "!");

    System.out.println("Do you have a coupon you would like to use?");
    String couponChoice = "";
    int newTotal = 0;
    while (newTotal == 0) {
      couponChoice = myScanner.nextLine().toUpperCase();
      if (couponChoice.equals("YES") || couponChoice.equals("Y")) {
        System.out.println("Okay, what is the code?");
        String couponCode = myScanner.nextLine();
        newTotal = newEvent.applyCoupon(totalPrice, couponCode);  
        if (newTotal == 0) {
          System.out.println("I'm sorry, that's not a valid coupon code. Would you like to try again?");
        } else {
          System.out.println("Your new total is " + newTotal + ". Wow! What a savings. See you at the event!");
        }
      } else if (couponChoice.equals("NO") || couponChoice.equals("N")) {
        System.out.println("Okay, see you at the event!");
        newTotal = totalPrice;
      } else {
        System.out.println("Invalid option. Enter 'yes' or 'y' for yes, and 'no' or 'n' for no.");
      }
    }
  }
}
