//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomBookingTest {

    private RoomBooking roomBooking;

    @BeforeEach
    public void setUp() {
        //this creates a new instance of a booking before each test
        roomBooking = new RoomBooking();
    }


    @Test
    public void testAddRoom() {
        //this tests that free rooms can be added
        int initialSize = roomBooking.getRooms().size();
        roomBooking.addRoom(new Room("Room F07", 10));
        int newSize = roomBooking.getRooms().size();
        Assertions.assertEquals(initialSize + 1, newSize, "New room not added");
    }

    @Test
    public void testBookRoom() {
        //this tests to see that a room can be booked
        Room room = new Room("Room W10", 8);
        roomBooking.addRoom(room);
        boolean isBooked = roomBooking.bookRoom(room, "Killian Golds");
        Assertions.assertTrue(isBooked, "Room should be available for booking");
//        Assertions.assertFalse(room.isAvailable(), "Room should be booked");
//        Assertions.assertEquals("Killian Golds", room.getBookingName(), "Wrong name of the person who booked the room");
    }

    @Test
    public void testCancelBooking() {
        //this tests that a booking can be cancelled
        Room room = new Room("Room IT201", 14);
        roomBooking.addRoom(room);
        roomBooking.bookRoom(room, "Alex");
        boolean isCancelled = roomBooking.cancelBooking(room);
        Assertions.assertTrue(isCancelled, "Booking should be cancelled");
//        Assertions.assertTrue(room.isAvailable(), "Room should be available");
//        Assertions.assertNull(room.getBookingName(), "Booking name should be null");
    }
}
