import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    Event newEvent = new Event(0, 1, 0, 0);

    System.out.println("Welcome to the Event Planner.");
    System.out.println("How many people are attending your event?");

    while (newEvent.getAttendees() == 0) {
      try {
        String attendeesString = myScanner.nextLine();
        newEvent.setAttendees(Integer.parseInt(attendeesString));
        if (newEvent.getAttendees() <= 0) {
          newEvent.setAttendees(0);
          System.out.println("That's not enough people! How many people are ACTUALLY attending your event?");
        } else {
          System.out.println("Great, thanks!");
        }
      } catch (NumberFormatException ex) {
        System.out.println("That's not an number! Try again.");
      }
    }
    System.out.println("-----------------------------------------");
    System.out.println("You're event will have " + newEvent.getAttendees() + " guests.");
    System.out.println("Your current total is " + newEvent.calculatePrice() + ".");
    System.out.println("-----------------------------------------");

    System.out.println("What kind of food shall we provide?");
    String foodChoice = "";
    newEvent.setFoodMultiplier(0);
    while (newEvent.getFoodMultiplier() == 0) {
      System.out.println("SNACKS (free!), MEALS ($5/head), FANCY SNACKS ($10/head), or FANCY MEALS ($15/head)");
      foodChoice = myScanner.nextLine().toUpperCase();
      if (foodChoice.equals("SNACKS")) {
        newEvent.setFoodMultiplier(1);
      } else if (foodChoice.equals("MEALS")) {
        newEvent.setFoodMultiplier(2);
      } else if (foodChoice.equals("FANCY SNACKS")) {
        newEvent.setFoodMultiplier(3);
      } else if (foodChoice.equals("FANCY MEALS")) {
        newEvent.setFoodMultiplier(4);
      } else {
        System.out.println("Invalid option. You must choose a valid food option.");
      }
    }
    System.out.println("-----------------------------------------");
    System.out.println("You choose " + foodChoice + " as your food option.");
    System.out.println("Your current total is " + newEvent.calculatePrice() + ".");
    System.out.println("-----------------------------------------");

    System.out.println("What about tasty beverages?");
    String beverageChoice = "";
    newEvent.setBeverageCost(-1);
    while (newEvent.getBeverageCost() == -1) {
      System.out.println("SODA ($1/head), BEER AND WINE ($4/head), FULL BAR ($7/head), WATER (free!), or NONE");
      beverageChoice = myScanner.nextLine().toUpperCase();
      if (beverageChoice.equals("SODA")) {
        newEvent.setBeverageCost(1);
      } else if (beverageChoice.equals("BEER AND WINE")) {
        newEvent.setBeverageCost(4);
      } else if (beverageChoice.equals("FULL BAR")) {
        newEvent.setBeverageCost(7);
      } else if (beverageChoice.equals("WATER") || beverageChoice.equals("NONE")) {
        newEvent.setBeverageCost(0);
      } else {
        System.out.println("Invalid option. You must choose a valid beverage option.");
      }
    }
    System.out.println("-----------------------------------------");
    System.out.println("You choose " + beverageChoice + " as your beverage option.");
    System.out.println("Your current total is " + newEvent.calculatePrice() + ".");
    System.out.println("-----------------------------------------");


    System.out.println("Finally, what type of entertainment would you like at your event?");
    String entertainmentChoice = "";
    newEvent.setEntertainmentCost(-1);
    while (newEvent.getEntertainmentCost() == -1) {
      System.out.println("POP STAR ($30,000), INDIE BAND ($2000), DJ ($500), KARAOKE ($60), or NONE");
      entertainmentChoice = myScanner.nextLine().toUpperCase();
      if (entertainmentChoice.equals("POP STAR")) {
        newEvent.setEntertainmentCost(30000);
      } else if (entertainmentChoice.equals("INDIE BAND")) {
        newEvent.setEntertainmentCost(2000);
      } else if (entertainmentChoice.equals("DJ")) {
        newEvent.setEntertainmentCost(500);
      } else if (entertainmentChoice.equals("KARAOKE")) {
        newEvent.setEntertainmentCost(60);
      } else if (entertainmentChoice.equals("NONE")) {
        newEvent.setEntertainmentCost(0);
      }
    }
    System.out.println("-----------------------------------------");
    System.out.println("You choose " + entertainmentChoice + " as your entertainment option.");
    int totalPrice = newEvent.calculatePrice();
    System.out.println("This event sounds amazing! And it's only going to cost you $" + totalPrice + "!");
    System.out.println("-----------------------------------------");

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
