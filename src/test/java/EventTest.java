import org.junit.*;
import static org.junit.Assert.*;

public class EventTest {

  @Test
  public void getAttendees_addsNumberOfGuests_100() {
    Event testEvent = new Event(100, 1, 0, 0);
    assertEquals(100, testEvent.getAttendees());
  }

  @Test
  public void calculatePrice_addsNumberOfGuestsPrice_500() {
    Event testEvent = new Event(100, 1, 0, 0);
    assertEquals(500, testEvent.calculatePrice());
  }

  @Test
  public void calculatePrice_addsFoodMultiplier_1500() {
    Event testEvent = new Event(100, 3, 0, 0);
    assertEquals(1500, testEvent.calculatePrice());
  }

  @Test
  public void calculatePrice_addsBeverageCost_700() {
    Event testEvent = new Event(100, 1, 2, 0);
    assertEquals(700, testEvent.calculatePrice());
  }

  @Test
  public void calculatePrice_addsEntertainmentCost_800() {
    Event testEvent = new Event(100, 1, 0, 300);
    assertEquals(800, testEvent.calculatePrice());
  }

  @Test
  public void applyCoupon_appliesCouponDiscountOf50_450() {
    Event testEvent = new Event(100, 1, 0, 0);
    assertEquals(450, testEvent.applyCoupon(testEvent.calculatePrice(), "fiftyfree"));
  }

  @Test
  public void applyCoupon_appliesCouponForFreeDrinks_500() {
    Event testEvent = new Event(100, 1, 2, 0);
    assertEquals(500, testEvent.applyCoupon(testEvent.calculatePrice(), "freedrinks"));
  }
}
