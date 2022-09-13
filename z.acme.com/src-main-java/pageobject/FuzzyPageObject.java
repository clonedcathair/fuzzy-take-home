package xxx.pageobject;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class FuzzyPageObject extends PageObject {

    protected final Logger LOGGER = Logger.getLogger(String.valueOf(this));

    EnvironmentVariables environmentVariables;

    private final String CHECKOUT_REF = "/on/demandware.store/Sites-WestMarine-Site/en_US/Checkout-Begin";

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    protected static final By TRACKING_CONSENT_NO_BUTTON = By.cssSelector("#consent-tracking button.decline");
    protected static final By PRIVACY_DISCLAIMER_CLOSE_BUTTON = By.cssSelector("#privacyDisclaimer > .secondary.privacy-disclaimer-accept");
    protected static final By EMAIL_SIGNUP_X_BUTTON = By.cssSelector("#email-signup-modal > div > div > button > span");
    protected static final By IN_PROGRESS_SPINNER = By.cssSelector(".veil");
    protected static final By IN_PROGRESS_SPINNER_FIXED = By.cssSelector(".veil.position-fixed");

    // -----------------------------------------------------------------------------------------------------------------
    // COMMON ACTIONS
    protected String getRetailURL() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
    }

    protected String getProURL() {
        return getRetailURL().replace("wm", "wmpro");
    }

    protected String getRetailCheckoutURL() {
        return getRetailURL() + CHECKOUT_REF;
    }

    protected String getProCheckoutURL() {
        return getProURL() + CHECKOUT_REF;
    }

    protected void waitForInProgress() {
        $(IN_PROGRESS_SPINNER).waitUntilNotVisible();
    }

    protected void clearTrackingPrivacyEmailSignup() {
        dismissEmailSignup();
        dismissTrackingConsent();
        dismissPrivacyDisclaimer();
        waitForApp(2);
    }

    protected void dismissEmailSignup() {
        if (popupFound(EMAIL_SIGNUP_X_BUTTON))
            clickOn($(EMAIL_SIGNUP_X_BUTTON));
    }

    protected void dismissTrackingConsent() {
        if (popupFound(TRACKING_CONSENT_NO_BUTTON))
            clickOn($(TRACKING_CONSENT_NO_BUTTON));
    }

    protected void dismissPrivacyDisclaimer() {
        if (popupFound(PRIVACY_DISCLAIMER_CLOSE_BUTTON))
            clickOn($(PRIVACY_DISCLAIMER_CLOSE_BUTTON));
    }

    private boolean popupFound(By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(getDriver(),3).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch(Exception ex) {
            LOGGER.info("Popup not found: " + by.toString() + "==> " +  ex.getMessage());
        }

        return (element == null) ? false : element.isDisplayed();
    }

    protected void goTo(String url) {
        getDriver().get(url);
    }

    protected void refresh() {
        getDriver().navigate().refresh();
    }

    protected WebElement waitForRefresh(WebElement forElement) {
        WebElement element = new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.refreshed( ExpectedConditions.elementToBeClickable(forElement) ));
        return new WebDriverWait(getDriver(), 30).
                until( ExpectedConditions.visibilityOf(element) );
    }

    protected void waitForApp(int timeOutInSeconds) {
        waitForApp(Duration.ofSeconds(timeOutInSeconds));
    }

    protected void waitForApp(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        }
        catch(InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    protected void scrollDown() {
        scrollDown(1);
    }

    protected void scrollDown(int howMany) {
        IntStream.range(0, howMany).forEach(i -> scrollBy(0, 250));
    }

    /**
     *
     * @param X  pixels to the right
     * @param Y  pixels to scroll down
     */
    protected void scrollBy(final int X, final int Y) {
        ((JavascriptExecutor) getDriver()).executeScript(String.format("window.scrollBy(%s, %s)", X, Y));
    }

    protected void hoverOver(WebElement element) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.visibilityOf(element));
        new Actions(getDriver()).moveToElement(element).perform();
    }

    protected void typeSlowlyOn(By by, String enter) {
        for (char c : enter.toCharArray()) {
            waitForRefresh(find(by));
            find(by).sendKeys(String.valueOf(c));
            waitForApp(Duration.ofMillis(50));
        }
    }

    protected void selectOptionOn(WebElement element, String byText) {
        // TODO: later add option to select byValue as needed
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(element));
        new Select($(element)).selectByVisibleText(byText);
    }

    protected void typeOn(WebElement element, String enter) {
        typeOn(element, (CharSequence) enter);
    }

    protected void typeOn(WebElement element, CharSequence... charSequences) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(element));
        $(element).type(charSequences);
    }

    protected String getTextOn(WebElement element) {
        new WebDriverWait(getDriver(),30).
                until(ExpectedConditions.visibilityOf($(element)));
        return $(element).getText();
    }
}
