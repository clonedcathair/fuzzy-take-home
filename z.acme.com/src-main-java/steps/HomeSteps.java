package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import fuzzy.interview.pageobject.common.HomePage;
import fuzzy.interview.pageobject.product.MyAccountPage;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeSteps extends AbstractSteps {

    HomePage homePage;
    NavigationPage navigationPage;
    MyAccountPage myAccountPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public HomeSteps starts_on_home_page(User forThisUser) {
        Expected.user = forThisUser;
        homePage.openApplication(forThisUser);

        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public HomeSteps signin_from_dropdown_as(User user) {
        navigationPage.
                enterCredentials(user).
                signIn();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public HomeSteps should_see_hi_user(String firstname) {
        assertThat(myAccountPage.hiUser()).isEqualTo(String.format("Hi %s", firstname));
        return this;
    }
}
