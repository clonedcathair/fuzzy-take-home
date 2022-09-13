package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.Product;
import fuzzy.interview.pageobject.common.HomePage;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps extends AbstractSteps {

    HomePage homePage;
    NavigationPage navigationPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public SearchSteps starts_on_home_page(User forThisUser) {
        Expected.user = forThisUser;
        homePage.openApplication(forThisUser);

        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public SearchSteps starts_on_my_account_page(User user) {
        Expected.user = user;
        homePage.openApplication(user);
        if (!(UserType.GUEST == user.getUserType())) {
            navigationPage.
                    enterCredentials(Expected.user).
                    signIn().
                    verifyUserLoggedIn(Expected.user.getFirstname());
        }
        return this;
    }

    public SearchSteps searches_for_product(String criteria) {
        navigationPage.search(criteria);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    @Step
    public SearchSteps should_see_product_in_results(Product expected) {
        String displayedPrice = String.format("$%s", expected.getPrice());
        // TODO: [REFACTOR_CODE] use streams to filter product tiles, risk is name, manuf, price can be
        // TODO: associated with other tiles and match that first falsely passing this test
        assertThat( homePage.containsAllText(expected.getManuf().name(), expected.getName(), displayedPrice) ).
                as("Product not found in results").
                isTrue();
        return this;
    }

}
