import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private int groupId;
    private String groupName;
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int capacity;
    private List<User> participants;
    private User organizer;
    private List<User> waitlist;

    public StudyGroup(int groupId, String groupName, Room room, LocalDateTime startTime, LocalDateTime endTime, int capacity, User organizer) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.organizer = organizer;
        this.participants = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
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

    public int getCapacity() {
        return capacity;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public boolean addParticipant(User user) {
        if (participants.size() < capacity) {
            participants.add(user);
            return true;
        } else {
            addToWaitlist(user);
            return false;
        }
    }

    public boolean removeParticipant(User user) {
        return participants.remove(user);
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getWaitlist() {
        return waitlist;
    }

    public void addToWaitlist(User user) {
        if (!waitlist.contains(user)) {
            waitlist.add(user);
        }
    }

    public boolean removeFromWaitlist(User user) {
        return waitlist.remove(user);
    }

    public boolean isFull() {
        return participants.size() >= capacity;
    }
}
