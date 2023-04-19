public class Room {
    private int roomId;
    private String roomType; // "computer lab" or "regular room"
    private String location;
    private int capacity;
    private boolean availability;

    public Room(int roomId, String roomType, String location, int capacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.location = location;
        this.capacity = capacity;
        this.availability = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
