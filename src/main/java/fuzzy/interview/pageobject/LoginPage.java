package fuzzy.interview.pageobject;

import fuzzy.interview.model.common.Expected;
import org.openqa.selenium.By;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends FuzzyPO {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By USERNAME_INPUT = By.cssSelector("#user-name");
    private static final By PASSWORD_INPUT = By.cssSelector("#password");
    private static final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private static final By ERROR_TEXT = By.cssSelector(".error-message-container");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public LoginPage openPage() {
        getDriver().get(getURL());
        verifyLoginPageDisplayed();
        return this;
    }

    public ProductPage signin() {
        $(USERNAME_INPUT).sendKeys(Expected.user.getUsername());
        $(PASSWORD_INPUT).sendKeys(Expected.user.getPassword());
        $(LOGIN_BUTTON).click();
        return new ProductPage();
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public LoginPage verifyLoginPageDisplayed() {
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(USERNAME_INPUT);
        withTimeoutOf(Duration.ofSeconds(1)).waitFor(PASSWORD_INPUT);
        withTimeoutOf(Duration.ofSeconds(1)).waitFor(LOGIN_BUTTON);
        return this;
    }

    public LoginPage verifyErrorDisplays(String message) {
        assertThat($(ERROR_TEXT).getText()).as("Incorrect error displayed").
                isEqualTo(message);
        return this;
    }
}
