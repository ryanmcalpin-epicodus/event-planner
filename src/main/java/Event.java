class Event {

  private int mAttendees;
  private int mFoodMultiplier;

  public Event(int attendees, int foodMultiplier) {
    mAttendees = attendees;
    mFoodMultiplier = foodMultiplier;
  }

  public int getAttendees() {
    return mAttendees;
  }

  public int calculatePrice() {
    int price = mAttendees * 5 * mFoodMultiplier;
    return price;
  }
}
