package fuzzy.interview.model.user;

public class LockedOutUser {

    public static User user() {
        User lockedOutUser = new User();
        lockedOutUser.setFirstname("FuzzyLockedOut");
        lockedOutUser.setLastname("FuzzyUser");
        lockedOutUser.setEmail("locked_out_user@qa.fuzzy.com");
        lockedOutUser.setUsername("locked_out_user");
        return lockedOutUser;
    }
}
