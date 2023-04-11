import java.util.ArrayList;
import java.util.List;

public class RoomBooking {

    private List<Room> rooms;

    public RoomBooking() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean bookRoom(Room room, String bookingName) {
        if (room.isAvailable()) {
            room.book(bookingName);
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelBooking(Room room) {
        if (!room.isAvailable()) {
            room.cancelBooking();
            return true;
        } else {
            return false;
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
