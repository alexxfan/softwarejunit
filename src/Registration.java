public class Registration {
    private Login loginSystem;

    public Registration(Login loginSystem) {
        this.loginSystem = loginSystem;
    }

    public User registerUser(int userId, String username, String email, String userType, String profilePicture, String password) {
        User newUser = new User(userId, username, email, userType, profilePicture, password);
        loginSystem.addUser(newUser);
        return newUser;
    }
}
