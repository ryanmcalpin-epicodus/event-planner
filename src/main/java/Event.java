class Event {

  private int mAttendees;
  private int mFoodMultiplier;
  private int mBeverageCost;
  private int mEntertainmentCost;

  public Event(int attendees, int foodMultiplier, int beverageCost, int entertainmentCost) {
    mAttendees = attendees;
    mFoodMultiplier = foodMultiplier;
    mBeverageCost = beverageCost;
    mEntertainmentCost = entertainmentCost;
  }

  public int getAttendees() {
    return mAttendees;
  }

  public int calculatePrice() {
    int price = mAttendees * (5 + mBeverageCost) * mFoodMultiplier + mEntertainmentCost;
    return price;
  }

  public int applyCoupon(int originalPrice, String couponCodeString) {
    int newPrice = 0;
    if (couponCodeString.equals("fiftyfree") && originalPrice >= 50) {
      newPrice = originalPrice - 50;
    } else if (couponCodeString.equals("halfprice")) {
      float priceFloat = originalPrice;
      newPrice = Math.round(priceFloat / 2);
    } else {
      newPrice = 0;
    }
    return newPrice;
  }
}
