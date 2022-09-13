package xxx.pageobject.checkout;

import xxx.pageobject.FuzzyPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By SHIPPING_ADDRESS_DROPDOWN = By.cssSelector("#shipmentSelector-default");
    private static final By UPDATE_ADDRESS_LINK = By.cssSelector(".btn-show-details");

    private static final By ADD_NEW_LINK = By.cssSelector("#dwfrm_shipping .btn-add-new");

    private static final By FIRST_NAME_INPUT = By.cssSelector("*[id*='FirstName']");
    private static final By LAST_NAME_INPUT = By.cssSelector("*[id*='LastName']");
    private static final By PHONE_NUMBER_INPUT = By.cssSelector("*[id*='PhoneNumber']");
    private static final By SIGNUP_SMS_CHECKBOX = By.cssSelector(".signup-sms-label");

    private static final By ADDRESS_INPUT = By.cssSelector("*[id*='AddressOne']");
    private static final By ADDRESS_DROPDOWN_SUGGESTION = By.cssSelector(".pca-list");
    private static final By ADDRESS2_INPUT = By.cssSelector("*[id*='AddressTwo']");

    private static final By CITY_INPUT = By.cssSelector("*[id*='AddressCity']");
    private static final By STATE_DROPDOWN = By.cssSelector("*[id*='State']");
    private static final By ZIP_CODE_INPUT = By.cssSelector("*[id*='ZipCode']");
    private static final By COUNTRY_DROPDOWN = By.cssSelector("*[id*='Country']");

    private static final By SHIPPING_METHOD_RADIO = By.cssSelector(".card.delivery-form .shipping-content .shipping-address .shipping-method-wrapper .form-check-label.shipping-method-option");
    private static final By THIS_IS_A_GIFT_CHECKBOX = By.xpath("//label[contains(.,'This is a Gift')]");
    private static final By NEXT_PAYMENT_BUTTON = By.xpath("//span[contains(.,'Next: Payment')]");

    private static final By SHIPPING_INSTRUCTIONS_DROPDOWN = By.cssSelector("#shipping-instructions");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public DeliveryPage enterShippingAddress(Address shipping) {
        waitForApp(2);
        if ($(UPDATE_ADDRESS_LINK).isClickable()) {
            $(UPDATE_ADDRESS_LINK).click();
            scrollDown();
            $(FIRST_NAME_INPUT).clear();
            $(LAST_NAME_INPUT).clear();
            $(PHONE_NUMBER_INPUT).clear();
            $(ADDRESS_INPUT).clear();
            $(ADDRESS2_INPUT).clear();
        }

        if (!$(SHIPPING_INSTRUCTIONS_DROPDOWN).isClickable()){
            $(FIRST_NAME_INPUT).sendKeys(shipping.getFirstname() + "Shipping");
            $(LAST_NAME_INPUT).sendKeys(shipping.getLastname());
            $(PHONE_NUMBER_INPUT).sendKeys(shipping.getPhone());
            $(ADDRESS_INPUT).sendKeys(shipping.getAddress1());
            waitForApp(2);
            $(ADDRESS_DROPDOWN_SUGGESTION).click();
            waitForApp(2);
        }
        return this;
    }

    public DeliveryPage selectShippingMethod(Shipping expected) {
        scrollDown();
        waitForApp(5);
        for (WebElementFacade radio : findAll(SHIPPING_METHOD_RADIO)) {
            if (radio.containsText(expected.getMethod())) {
                waitForApp(5);
                clickOn(radio);
                break;
            }
        }
        waitForInProgress();
        return this;
    }

    public DeliveryPage clickNextPayment() {
        scrollDown();
        waitForApp(2);
        new WebDriverWait(getDriver(),10).
                until(ExpectedConditions.visibilityOf($(NEXT_PAYMENT_BUTTON)));
        clickOn($(NEXT_PAYMENT_BUTTON));
        waitForApp(2);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
