import java.time.LocalDateTime;

public class User {
    private int userId;
    private String username;
    private String email;
    private String userType; // student or lecturer
    private String profilePicture;
    private String password;
    private int warningsCount;
    private int bookingSuspensions;
    private LocalDateTime lastCancellationDate;

    public User(int userId, String username, String email, String userType, String profilePicture, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.userType = userType;
        this.profilePicture = profilePicture;
        this.warningsCount = 0;
        this.bookingSuspensions = 0;
        this.lastCancellationDate = null;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public int getWarningsCount() {
        return warningsCount;
    }

    public void addWarning() {
        this.warningsCount++;
    }

    public void removeWarning() {
        if (this.warningsCount > 0) {
            this.warningsCount--;
        }
    }

    public int getBookingSuspensions() {
        return bookingSuspensions;
    }

    public void addBookingSuspension() {
        this.bookingSuspensions++;
    }

    public LocalDateTime getLastCancellationDate() {
        return lastCancellationDate;
    }

    public void setLastCancellationDate(LocalDateTime lastCancellationDate) {
        this.lastCancellationDate = lastCancellationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
