import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RoomBookingTest {

    // Declare member variables
    private User user;
    private StudyGroup studyGroup;
    private Room room;

    // This method is run before each test method
    @BeforeEach
    void setUp() {
        // Create a user object with some test data
        user = new User(1, "Killian Golds", "KG@example.com", "student", "Killian.jpg");
        // Create a room object with some test data
        room = new Room(1, "computer lab", "SETU Campus 1", 2);
        // Create a start time and end time for a study group
        LocalDateTime startTime = LocalDateTime.parse("2023-04-20T10:00:00");
        LocalDateTime endTime = LocalDateTime.parse("2023-04-20T12:00:00");
        // Create a study group object with some test data
        studyGroup = new StudyGroup(1, "Group 1", room, startTime, endTime, 2, user);
    }

    @ParameterizedTest
    @CsvSource({
            "1, computer lab, Campus 1, 2, 2023-04-20T10:00:00, 2023-04-20T12:00:00",
            "2, regular room, Campus 2, 4, 2023-04-21T14:00:00, 2023-04-21T16:00:00"
    })
    void testBookRoomIndividual(int roomId, String roomType, String location, int capacity, String start, String end) {
        Room room = new Room(roomId, roomType, location, capacity);
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        RoomBooking roomBooking = new RoomBooking(1, user, room, startTime, endTime);
        roomBooking.bookRoom();
        assertFalse(room.getAvailability());
    }

    @ParameterizedTest
    @CsvSource({
            "1, computer lab, Campus 1, 2, 2023-04-20T10:00:00, 2023-04-20T12:00:00",
            "2, regular room, Campus 2, 4, 2023-04-21T14:00:00, 2023-04-21T16:00:00"
    })
    void testCancelBookingIndividual(int roomId, String roomType, String location, int capacity, String start, String end) {
        Room room = new Room(roomId, roomType, location, capacity);
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        RoomBooking roomBooking = new RoomBooking(1, user, room, startTime, endTime);
        roomBooking.cancelBooking();
        assertTrue(room.getAvailability());
    }

    @ParameterizedTest
    @CsvSource({
            "1, computer lab, Campus 1, 2, 2023-04-20T10:00:00, 2023-04-20T12:00:00",
            "2, regular room, Campus 2, 4, 2023-04-21T14:00:00, 2023-04-21T16:00:00"
    })
    void testBookRoomStudyGroup(int roomId, String roomType, String location, int capacity, String start, String end) {
        Room room = new Room(roomId, roomType, location, capacity);
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        RoomBooking roomBooking = new RoomBooking(1, studyGroup, room, startTime, endTime);
        roomBooking.bookRoom();
        assertFalse(room.getAvailability());
    }

    @ParameterizedTest
    @CsvSource({
            "1, computer lab, Campus 1, 2, 2023-04-20T10:00:00, 2023-04-20T12:00:00",
            "2, regular room, Campus 2, 4, 2023-04-21T14:00:00, 2023-04-21T16:00:00"
    })
    void testCancelBookingStudyGroup(int roomId, String roomType, String location, int capacity, String start, String end) {
        Room room = new Room(roomId, roomType, location, capacity);
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        RoomBooking roomBooking = new RoomBooking(1, studyGroup, room, startTime, endTime);
        roomBooking.cancelBooking();
        assertTrue(room.getAvailability());
    }
}