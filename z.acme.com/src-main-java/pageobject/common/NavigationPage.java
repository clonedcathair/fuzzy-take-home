package xxx.pageobject.common;

import xxx.pageobject.FuzzyPageObject;
import fuzzy.interview.model.common.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By HELP_LINK = By.cssSelector(".help-header-link");

    private static final By MY_ACCOUNT_LINK = By.xpath("//a[contains(.,'My Account')]");

    public static final By SIGN_IN_DROPDOWN = By.xpath("//span[contains(.,'Sign In')]");
    public static final By HI_USER_TEXT = By.cssSelector(".user-message.wm-lead-label");

    private static final By EMAIL_ADDRESS_INPUT = By.cssSelector("#header-login-email");
    private static final By PASSWORD_INPUT = By.cssSelector("#header-login-password");
    private static final By SIGN_IN_LABEL = By.cssSelector(".wm-lead-label");
    private static final By SIGN_IN_BUTTON = By.cssSelector(".navbar-header .user .create-account-header button");
    private static final By SIGN_OUT_LINK = By.xpath("//a[contains(.,'Sign Out')]");
    private static final By CREATE_AN_ACCOUNT_BUTTON = By.xpath("//a[contains(.,'Create an Account')]");

    private static final By USER_SECTION = By.cssSelector(".user.user-block.nav-item");
    private static final By CART_QUANTITY_TEXT = By.cssSelector(".minicart-quantity");
    private static final By MY_CART_LINK = By.cssSelector(".minicart-inline-link");
    private static final By MY_CART_POPUP = By.cssSelector("nav .navbar-header.order-last > .minicart > .popover.show");
    private static final By CHECKOUT_BUTTON = By.cssSelector("nav .navbar-header.order-last > .minicart > .popover .checkout-continue > div > a");
    private static final By VIEW_CART_BUTTON = By.xpath("//a[contains(.,'View Cart')]");

    private static final By SEARCH_INPUT = By.cssSelector(".search-field");
    private static final By SPYGLASS_ICON = By.cssSelector("#sg-navbar-collapse nav .search > div > form > button");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public NavigationPage clearTrackingPrivacySignup() {
        clearTrackingPrivacyEmailSignup();
        return this;
    }

    public NavigationPage gotoCreateAnAccount() {
        clickOn($(SIGN_IN_DROPDOWN));
        clickOn($(CREATE_AN_ACCOUNT_BUTTON));
        return this;
    }

    public NavigationPage enterCredentials(User user) {
        hoverOver($(MY_ACCOUNT_LINK));
        typeOn($(EMAIL_ADDRESS_INPUT), user.getEmail());
        typeOn($(PASSWORD_INPUT), user.getPassword());
        return this;
    }

    public NavigationPage signIn() {
        clickOn($(SIGN_IN_BUTTON));
        clearTrackingPrivacySignup();
        return this;
    }

    public NavigationPage signOut() {
        hoverOver($(USER_SECTION));
        clickOn($(SIGN_OUT_LINK));
        waitForApp(5);
        return this;
    }

    public boolean cartIsEmpty() {
        return $(CART_QUANTITY_TEXT).getText().trim().equals("0");
    }

    public NavigationPage hoverOverMyCart() {
        hoverOver($(MY_CART_LINK));
        new WebDriverWait(getDriver(),10).
                until(ExpectedConditions.visibilityOf($(MY_CART_POPUP)));
        waitForApp(5);
        return this;
    }

    public NavigationPage search(int sku) {
        search(String.valueOf(sku));
        return this;
    }

    public NavigationPage search(String term) {
        // TODO: Refreshed didn't resolve ElementClickInterceptedException issue
        //typeOn($(SEARCH_INPUT), term);
        //clickOn($(SPYGLASS_ICON));
        typeOn($(SEARCH_INPUT), term + Keys.ENTER);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public NavigationPage verifyUserLoggedIn(String firstname) {
        new WebDriverWait(getDriver(),10).
                until(ExpectedConditions.visibilityOf($(HI_USER_TEXT)));
        assertThat($(HI_USER_TEXT).getText()).as("Invalid Hi <username>").
                contains("Hi " + firstname);
        return this;
    }

    public NavigationPage verifySignInPresent() {
        new WebDriverWait(getDriver(),10).
                until(ExpectedConditions.visibilityOf($(SIGN_IN_LABEL)));
        return this;
    }
}
