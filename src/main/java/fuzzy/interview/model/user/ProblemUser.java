package fuzzy.interview.model.user;

public class ProblemUser {
    public static User user() {
        User problem = new User();
        problem.setFirstname("FuzzyProblem");
        problem.setLastname("FuzzyUser");
        problem.setEmail("problem_user@qa.fuzzy.com");
        problem.setUsername("problem_user");
        return problem;
    }
}
