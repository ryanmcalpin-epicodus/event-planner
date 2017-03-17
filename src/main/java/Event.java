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
}
