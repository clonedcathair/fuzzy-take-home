package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import fuzzy.interview.pageobject.common.HomePage;
import fuzzy.interview.pageobject.product.MyAccountPage;
import fuzzy.interview.pageobject.register.CreateAnAccountPage;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountSteps extends AbstractSteps {

    NavigationPage navigationPage;
    HomePage homePage;
    MyAccountPage myAccountPage;
    CreateAnAccountPage createAnAccountPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public CreateAccountSteps starts_on_create_account_page(User forThisUser) {
        Expected.user = forThisUser;
        homePage.openApplication(forThisUser);
        navigationPage.gotoCreateAnAccount();

        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public CreateAccountSteps creates_an_account() {
        createAnAccountPage.
                enterRegistration(Expected.user).
                createAccount();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public CreateAccountSteps should_see_welcome_user(String firstname) {
        String expectedWelcome = String.format("Welcome, %s.", firstname);
        assertThat(myAccountPage.welcomeBackMessage()).isEqualTo(expectedWelcome);
        return this;
    }

    public void should_see_that_success_alert_says(String expectedPlaceholderText) {
        //assertThat(todoListPage.placeholderText()).isEqualTo(expectedPlaceholderText);
    }

    public void should_see_that_that_following_items_are_marked_as_complete(String... items) {
        //asList(items).forEach(this::should_see_that_that_following_item_is_marked_as_complete);
    }
}
