package fuzzy.interview.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.user.User;
import fuzzy.interview.pageobject.LoginPage;
import fuzzy.interview.pageobject.MenuPage;
import fuzzy.interview.pageobject.ProductPage;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends AbstractSteps {

    EnvironmentVariables environmentVariables;
    LoginPage loginPage;
    MenuPage menuPage;
    ProductPage productPage;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public LoginSteps on_the_login_page() {
        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        loginPage.openPage();
        return this;
    }

    public LoginSteps login_as(User user) {
        Expected.user = user;
        loginPage.signin();
        return this;
    }

    public LoginSteps should_see_the_product_page() {
        assertThat(productPage.getHeaderText()).as("Incorrect product page header title").
                isEqualTo("PRODUCTS");
        return this;
    }

    public LoginSteps should_not_see_the_product_page() {
        loginPage.verifyLoginPageDisplayed();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public LoginSteps and_error_message_displayed_as(String message) {
        if (message != null)
            loginPage.verifyErrorDisplays(message);
        return this;
    }

    public LoginSteps check_image_src_for(User user1, User user2) {
        assertThat(check_image_src_for(user1)).as("Mismatched image src between users: " + user1.getUsername() + ", " +  user2.getUsername()).
                isEqualTo(check_image_src_for(user2));
        return this;
    }

    private String check_image_src_for(User user) {
        LOGGER.info("Get image for user: " + user.getUsername());
        on_the_login_page().login_as(user);
        String src = productPage.getImageSrc();

        LOGGER.info("Image src found: " + src);
        menuPage.signout();
        return src;
    }
}
