package fuzzy.interview.model.user;

public class PerformanceGlitchUser {

    public static User user() {
        User perfGlitch = new User();
        perfGlitch.setFirstname("FuzzyPerformanceGlitch");
        perfGlitch.setLastname("FuzzyUser");
        perfGlitch.setEmail("performance_glitch_user@qa.fuzzy.com");
        perfGlitch.setUsername("performance_glitch_user");
        return perfGlitch;
    }
}
