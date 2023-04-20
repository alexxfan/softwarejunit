import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, User> usersByEmail;

    public Login() {
        this.usersByEmail = new HashMap<>();
    }

    public void addUser(User user) {
        usersByEmail.put(user.getEmail(), user);
    }

    public boolean validateLogin(String email, String password) {
        User user = usersByEmail.get(email);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

