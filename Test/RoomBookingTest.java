//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomBookingTest {

    private RoomBooking roomBooking;

    @BeforeEach
    public void setUp() {
        // Create a new instance of RoomBooking before each test
        roomBooking = new RoomBooking();
    }

    @Test
    public void testAddRoom() {
        // Test that a new room can be added
        int initialSize = roomBooking.getRooms().size();
        roomBooking.addRoom(new Room("Room A", 10));
        int newSize = roomBooking.getRooms().size();
        Assertions.assertEquals(initialSize + 1, newSize, "New room not added");
    }

    @Test
    public void testBookRoom() {
        // Test that a room can be booked
        Room room = new Room("Room B", 8);
        roomBooking.addRoom(room);
        boolean isBooked = roomBooking.bookRoom(room, "John");
        Assertions.assertTrue(isBooked, "Room should be available for booking");
        Assertions.assertFalse(room.isAvailable(), "Room should be booked");
        Assertions.assertEquals("John", room.getBookingName(), "Wrong name of the person who booked the room");
    }

    @Test
    public void testCancelBooking() {
        // Test that a booking can be cancelled
        Room room = new Room("Room C", 6);
        roomBooking.addRoom(room);
        roomBooking.bookRoom(room, "Jane");
        boolean isCancelled = roomBooking.cancelBooking(room);
        Assertions.assertTrue(isCancelled, "Booking should be cancelled");
        Assertions.assertTrue(room.isAvailable(), "Room should be available");
        Assertions.assertNull(room.getBookingName(), "Booking name should be null");
    }
}
