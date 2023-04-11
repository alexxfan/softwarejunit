
public class Room {

    private String name;
    private int capacity;
    private boolean available;
    private String bookingName;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.available = true;
        this.bookingName = null;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void book(String bookingName) {
        this.bookingName = bookingName;
        this.available = false;
    }

    public void cancelBooking() {
        this.bookingName = null;
        this.available = true;
    }
}
