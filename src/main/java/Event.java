class Event {

  private int mAttendees;
  private int mFoodMultiplier;
  private int mBeverageCost;

  public Event(int attendees, int foodMultiplier, int beverageCost) {
    mAttendees = attendees;
    mFoodMultiplier = foodMultiplier;
    mBeverageCost = beverageCost;
  }

  public int getAttendees() {
    return mAttendees;
  }

  public int calculatePrice() {
    int price = mAttendees * (5 + mBeverageCost) * mFoodMultiplier;
    return price;
  }
}
