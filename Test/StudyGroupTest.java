import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class StudyGroupTest {

    // Declare instance variables for test
    private StudyGroup studyGroup;
    private User organizer;
    private User participant1;
    private User participant2;

    // Before each test, initialize the instance variables
    @BeforeEach
    void setUp() {
        organizer = new User(1, "Organizer", "organizer@example.com", "student", "organizer.jpg");
        participant1 = new User(2, "Participant1", "participant1@example.com", "student", "participant1.jpg");
        participant2 = new User(3, "Participant2", "participant2@example.com", "student", "participant2.jpg");
        Room room = new Room("Computer Lab", 2);
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = startTime.plusHours(2);
        studyGroup = new StudyGroup(1, "Study Group 1", room, startTime, endTime, 2, organizer);
    }

    // Test adding a participant to the study group
    @Test
    void testAddParticipant() {
        assertTrue(studyGroup.addParticipant(participant1));
        assertEquals(1, studyGroup.getParticipants().size());
    }

    // Test adding a participant when the study group is already full
    @Test
    void testAddParticipantWhenFull() {
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        assertFalse(studyGroup.addParticipant(new User(4, "Participant3", "participant3@example.com", "student", "participant3.jpg")));
        assertEquals(2, studyGroup.getParticipants().size());
    }

    // Test removing a participant from the study group
    @Test
    void testRemoveParticipant() {
        studyGroup.addParticipant(participant1);
        assertTrue(studyGroup.removeParticipant(participant1));
        assertEquals(0, studyGroup.getParticipants().size());
    }

    // Test adding a participant to the waitlist
    @Test
    void testAddToWaitlist() {
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        studyGroup.addToWaitlist(new User(4, "Participant3", "participant3@example.com", "student", "participant3.jpg"));
        assertEquals(1, studyGroup.getWaitlist().size());
    }

    // Test removing a participant from the waitlist
    @Test
    void testRemoveFromWaitlist() {
        User participant3 = new User(4, "Participant3", "participant3@example.com", "student", "participant3.jpg");
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        studyGroup.addToWaitlist(participant3);
        assertTrue(studyGroup.removeFromWaitlist(participant3));
        assertEquals(0, studyGroup.getWaitlist().size());
    }

    // Test if the study group is full
    @Test
    void testIsFull() {
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        assertTrue(studyGroup.isFull());
    }
}
