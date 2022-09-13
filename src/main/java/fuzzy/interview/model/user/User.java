package fuzzy.interview.model.user;

import lombok.Data;

@Data
public class User {

    public final static String DEFAULT_PASSWORD = "secret_sauce";

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password = DEFAULT_PASSWORD;
    private String confirmPassword;

    public static User standardUser() {
        return StandardUser.user();
    }
    public static User lockedOutUser() {
        return LockedOutUser.user();
    }
    public static User problemUser() {
        return ProblemUser.user();
    }
    public static User performanceGlitchUser() {
        return PerformanceGlitchUser.user();
    }
}