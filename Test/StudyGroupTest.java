import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        organizer = new User(1, "Alex Fann", "alex@example.com", "student", "alex.jpg");
        participant1 = new User(2, "Killian Golds", "killian@example.com", "student", "killian.jpg");
        participant2 = new User(3, "Dean Sinnot", "dean@example.com", "student", "dean.jpg");
        Room room = new Room(1, "Computer Lab", "SETU Campus 1", 2);
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = startTime.plusHours(2);
        studyGroup = new StudyGroup(1, "Study Group 1", room, startTime, endTime, 2, organizer);
    }

    // Test adding a participant to the study group
    @ParameterizedTest
    @CsvSource({
            "1, killian@example.com",
            "2, dean@example.com"
    })
    void testAddParticipant(int userId, String email) {
        User participant = new User(userId, "Participant", email, "student", "participant.jpg");
        assertTrue(studyGroup.addParticipant(participant));
        assertEquals(1, studyGroup.getParticipants().size());
    }

    // Test adding a participant when the study group is already full
    @ParameterizedTest
    @CsvSource({
            "1, killian@example.com",
            "2, dean@example.com",
            "3, participant3@example.com"
    })
    void testAddParticipantWhenFull(int userId, String email) {
        User participant = new User(userId, "Participant", email, "student", "participant.jpg");
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        assertFalse(studyGroup.addParticipant(participant));
        assertEquals(2, studyGroup.getParticipants().size());
    }

    // Test removing a participant from the study group
    @ParameterizedTest
    @CsvSource({
            "1, killian@example.com",
            "2, dean@example.com"
    })
    void testRemoveParticipant(int userId, String email) {
        User participant = new User(userId, "Participant", email, "student", "participant.jpg");
        studyGroup.addParticipant(participant);
        assertTrue(studyGroup.removeParticipant(participant));
        assertEquals(0, studyGroup.getParticipants().size());
    }

    // Test adding a participant to the waitlist
    @ParameterizedTest
    @CsvSource({
            "1, killian@example.com",
            "2, dean@example.com",
            "3, participant3@example.com"
    })
    void testAddToWaitlist(int userId, String email) {
        User participant = new User(userId, "Participant", email, "student", "participant.jpg");
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        studyGroup.addToWaitlist(participant);
        assertEquals(1, studyGroup.getWaitlist().size());
    }

    // Test removing a participant from the waitlist
    @ParameterizedTest
    @CsvSource({
            "1, killian@example.com",
            "2, dean@example.com",
            "3, participant3@example.com"
    })
    void testRemoveFromWaitlist(int userId, String email) {
        User participant = new User(userId, "Participant", email, "student", "participant.jpg");
        studyGroup.addParticipant(participant1);
        studyGroup.addParticipant(participant2);
        studyGroup.addToWaitlist(participant);
        assertTrue(studyGroup.removeFromWaitlist(participant));
        assertEquals(0, studyGroup.getWaitlist().size());
    }

    // Test whether the study group is full based on the number of participants
    @ParameterizedTest
    @CsvSource({
            "0, false",
            "1, false",
            "2, true"
    })
    void testIsFull(int numberOfParticipants, boolean expectedIsFull) {
        // Add a specified number of participants to the study group
        for (int i = 0; i < numberOfParticipants; i++) {
            User participant = new User(i + 10, "Participant" + i, "participant" + i + "@example.com", "student", "participant" + i + ".jpg");
            studyGroup.addParticipant(participant);
        }
        // Check whether the study group is full based on the expected value
        assertEquals(expectedIsFull, studyGroup.isFull());
    }
}



