import java.time.LocalDateTime;

public class RoomBooking {
    private int bookingId;
    private User user; // for individual user bookings
    private StudyGroup studyGroup; // for study group bookings
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Constructor for individual user bookings
    public RoomBooking(int bookingId, User user, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.studyGroup = null;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Constructor for study group bookings
    public RoomBooking(int bookingId, StudyGroup studyGroup, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.bookingId = bookingId;
        this.user = null;
        this.studyGroup = studyGroup;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void bookRoom() {
        if (room.getAvailability()) {
            room.setAvailability(false);
            System.out.println("Room successfully booked!");
        } else {
            System.out.println("Room is not available for booking.");
        }
    }

    public void cancelBooking() {
        if (!room.getAvailability()) {
            room.setAvailability(true);
            System.out.println("Booking successfully cancelled!");
        } else {
            System.out.println("Room is not currently booked.");
        }
    }
}
