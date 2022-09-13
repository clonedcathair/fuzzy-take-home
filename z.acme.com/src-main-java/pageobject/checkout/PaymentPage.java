package xxx.pageobject.checkout;

import com.google.common.base.CharMatcher;
import fuzzy.interview.model.common.Payment;
import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By BILLING_ADDRESS_DROPDOWN = By.cssSelector("#billingAddressSelector");
    private static final By FIRST_NAME_INPUT = By.cssSelector("#billingFirstName");
    private static final By LAST_NAME_INPUT = By.cssSelector("#billingLastName");
    private static final By ADDRESS_INPUT = By.cssSelector("#billingAddressOne");
    private static final By ADDRESS2_INPUT = By.cssSelector("#billingAddressTwo");
    private static final By CITY_INPUT = By.cssSelector("#billingAddressCity");
    private static final By STATE_DROPDOWN = By.cssSelector("#billingState");
    private static final By ZIP_CODE_INPUT = By.cssSelector("#billingZipCode");
    private static final By COUNTRY_DROPDOWN = By.cssSelector("#billingCountry");
    private static final By PHONE_NUMBER_INPUT = By.cssSelector("#phoneNumber");
    private static final By UPDATE_ADDRESS_LINK = By.cssSelector("#dwfrm_billing > .billing-address-block > .address-selector-block .btn-show-details");

    private static final By CREDIT_CARD_NUMBER_INPUT = By.cssSelector("#cNumber");
    private static final By CARDHOLDER_NAME_INPUT = By.cssSelector("#cName");
    private static final By EXP_MONTH_DROPDOWN = By.cssSelector("#exp_mmm");
    private static final By EXP_YEAR_DROPDOWN = By.cssSelector("#exp_yyy");
    private static final By SECURITY_CODE_INPUT = By.cssSelector("#secCode");
    
    private static final By NEXT_REVIEW_ORDER_BUTTON = By.cssSelector("#checkout-main .card.payment-form .card-body .next-step-button");
    private static final By PLACE_ORDER_BUTTON = By.xpath("//button[contains(.,'Place Order')]");

    private static final By ESTIMATED_TAX_TEXT = By.cssSelector(".tax-total");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public PaymentPage enterBillingAddress(Address billing) {
        waitForApp(2);
        if ($(UPDATE_ADDRESS_LINK).isClickable()) {
            $(UPDATE_ADDRESS_LINK).click();
            scrollDown();
            $(FIRST_NAME_INPUT).clear();
            $(LAST_NAME_INPUT).clear();
            $(PHONE_NUMBER_INPUT).clear();
            $(ADDRESS_INPUT).clear();
            $(ADDRESS2_INPUT).clear();
            $(CITY_INPUT).clear();
            $(ZIP_CODE_INPUT).clear();
        }
        $(FIRST_NAME_INPUT).sendKeys(billing.getFirstname() + "Billing");
        $(LAST_NAME_INPUT).sendKeys(billing.getLastname());
        $(ADDRESS_INPUT).sendKeys(billing.getAddress1() + Keys.ENTER);
        $(ADDRESS2_INPUT).sendKeys(billing.getAddress2());
        $(CITY_INPUT).sendKeys(billing.getCity());
        new Select($(STATE_DROPDOWN)).selectByVisibleText(billing.getState().getName());
        $(ZIP_CODE_INPUT).sendKeys(billing.getZip());
        $(PHONE_NUMBER_INPUT).sendKeys(billing.getPhone());
        return this;
    }

    public PaymentPage enterPaymentMethod(Payment method) {
        scrollDown(4);
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame_carddetails"));
        waitForApp(3);
        typeSlowlyOn(CREDIT_CARD_NUMBER_INPUT, method.getCardNumber());
        waitForApp(2);
        typeOn($(CARDHOLDER_NAME_INPUT), method.getCardholderName());
        selectOptionOn($(EXP_MONTH_DROPDOWN), method.getExpMonth());
        selectOptionOn($(EXP_YEAR_DROPDOWN), method.getExpYear());
        waitForApp(1);
        typeOn($(SECURITY_CODE_INPUT), method.getCVV());
        waitForApp(1);
        getDriver().switchTo().parentFrame();
        scrollDown();
        return this;
    }

    public PaymentPage clickNextReviewOrder() {
        scrollDown();
        clickOn($(NEXT_REVIEW_ORDER_BUTTON));
        return this;
    }

    public PaymentPage clickPlaceOrder() {
        waitForApp(Duration.ofSeconds(3));
        scrollDown(2);
        clickOn($(PLACE_ORDER_BUTTON));
        return this;
    }

    public double getEstimatedTax() {
        String taxOnPage = $(ESTIMATED_TAX_TEXT).getText();
        String estimatedTax = CharMatcher.inRange('0','9').precomputed().retainFrom(taxOnPage);
        return Double.parseDouble(estimatedTax);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public boolean isOrderTaxed() {
        if (getEstimatedTax() > 0.00)
            return true;
        else
            return false;
    }
}
