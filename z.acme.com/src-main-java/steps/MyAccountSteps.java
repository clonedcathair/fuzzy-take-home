package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import fuzzy.interview.pageobject.common.HomePage;

public class MyAccountSteps extends AbstractSteps {

    HomePage homePage;
    NavigationPage navigationPage;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public MyAccountSteps starts_on_my_account_page(User forThisUser) {
        Expected.user = forThisUser;
        homePage.openApplication(forThisUser);
        navigationPage.
                enterCredentials(forThisUser).
                signIn();
        return this;
    }

    public MyAccountSteps signs_out() {
        navigationPage.
                signOut().
                clearTrackingPrivacySignup();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public MyAccountSteps should_see_sign_in() {
        navigationPage.verifySignInPresent();
        return this;
    }
}
