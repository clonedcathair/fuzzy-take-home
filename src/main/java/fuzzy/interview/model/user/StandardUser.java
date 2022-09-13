package fuzzy.interview.model.user;

public class StandardUser {

    public static User user() {
        User standard = new User();
        standard.setFirstname("FuzzyStandard");
        standard.setLastname("FuzzyUser");
        standard.setEmail("standard_user@qa.fuzzy.com");
        standard.setUsername("standard_user");
        return standard;
    }

    public static User randomUser() {
        long unique = System.currentTimeMillis();

        User randomStdUser = new User();
        randomStdUser.setFirstname("FuzzyStandardRandom" + unique);
        randomStdUser.setLastname("FuzzyUser");
        randomStdUser.setEmail("standard_user_" + unique + "@qa.fuzzy.com");
        return randomStdUser;
    }
}
