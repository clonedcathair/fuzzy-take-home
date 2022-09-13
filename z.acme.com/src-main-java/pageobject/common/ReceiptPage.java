package xxx.pageobject.common;

import xxx.pageobject.FuzzyPageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ReceiptPage extends FuzzyPageObject {

    private static final String RECEIPT_PARENT = "#maincontent .receipt.checkout-page ";

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By ALERT_ERROR_TEXT = By.cssSelector("#checkout-main .checkout-container .alert-danger .error-message-text");

    private static final By CARD_TITLE_TEXT = By.cssSelector(RECEIPT_PARENT + ".card.confirm-details .card-header");
    private static final By ORDER_NUMBER_TEXT = By.cssSelector(RECEIPT_PARENT + ".card.confirm-details .card-body .summary-details.order-number");
    private static final By THANK_YOU_TEXT = By.cssSelector(RECEIPT_PARENT + ".col-md-4.order-md-2 > div.row > div");
    private static final By ORDER_TOTAL_TEXT = By.cssSelector(RECEIPT_PARENT + ".order-md-2 .order-summary-wrapper .card-body.order-total-summary .row.grand-total-wrapper .grand-total-sum");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public ReceiptPage verifyNoErrorDisplayed() {
        new WebDriverWait(getDriver(),30).
                until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER_FIXED));
        try {
            if ($(ALERT_ERROR_TEXT).isDisplayed())
                fail("Error displayed: " + $(ALERT_ERROR_TEXT).getText());
        }
        catch(NoSuchElementException | StaleElementReferenceException e) {
            final String REASON = "No error found on page because error element has " + e.getMessage();
            LOGGER.info(REASON + "\n, This is expected, awesome lets proceed!!");
        }
        return this;
    }

    public ReceiptPage verifyReceiptDisplayed() {
        new WebDriverWait(getDriver(),30).
                until(ExpectedConditions.visibilityOf($(CARD_TITLE_TEXT)));
        assertThat($(CARD_TITLE_TEXT).getText()).as("Receipt not displayed").
                isEqualTo("Receipt");
        return this;
    }

    public ReceiptPage verifyOrderNumber() {
        scrollDown(2);
        assertThat($(ORDER_NUMBER_TEXT).getText()).as("Invalid Order Number").
                containsOnlyDigits();
        return this;
    }

    public ReceiptPage verifyThankYou(String email) {
        assertThat($(THANK_YOU_TEXT).getText()).as("Invalid Thank You confirmation").
                contains("Thank You").
                contains("You will receive an email confirmation shortly at " + email);
        return this;
    }

    public ReceiptPage verifyOrderTotal(String expectedOrderTotal) {
        assertThat($(ORDER_TOTAL_TEXT).getText()).as("Invalid Order Total").
                contains(expectedOrderTotal);
        return this;
    }

    public ReceiptPage verifyContainsAllText(String... expected) {
        SoftAssertions softly = new SoftAssertions();
        for (String expect : expected)
            softly.assertThat(getDriver().getPageSource()).as("Expected not found in Receipt").
                    containsOnlyOnce(expect);
        softly.assertAll();
        return this;
    }
}
