package xxx.pageobject.giftcard;

import xxx.pageobject.FuzzyPageObject;
import fuzzy.interview.model.product.intangible.EGiftCard;
import org.openqa.selenium.By;

public class EGiftCardPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final String DOLLAR_DENOM_BUTTON = "#maincontent .gift-form span[data-attr-value='%s']";

    private static final By CUSTOM_AMOUNT_INPUT = By.cssSelector("#gc-amount");
    private static final By RECIPIENTS_NAME_INPUT = By.cssSelector("#gcRecipientName");
    private static final By RECIPIENTS_EMAIL_ADDRESS_INPUT = By.cssSelector("#gcRecipientEmail");
    private static final By PERSONAL_MESSAGE_INPUT = By.cssSelector("#gcMessage");

    private static final By YOUR_NAME_INPUT = By.cssSelector("#gcYourName");
    private static final By YOUR_EMAIL_ADDRESS_INPUT = By.cssSelector("#gcYourEmail");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("#maincontent .prices-add-to-cart-actions .add-to-cart-check");
    private static final By SHOP_NOW_BUTTON = By.xpath("//a[contains(.,'Shop Now')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public EGiftCardPage selectAmount(EGiftCard product) {
        scrollDown(3);
        // manually set the desired amount if custom amount
        return (EGiftCard.DOLLAR_CUSTOM.getSKU().equals(product.getSKU())) ?
                enterCustomAmount(product.getAmount()) :
                clickAmount(product.getAmount());
    }

    public EGiftCardPage enterCustomAmount(String amount) {
        typeOn($(CUSTOM_AMOUNT_INPUT), amount);
        return this;
    }

    public EGiftCardPage clickAmount(String amount) {
        final By SWATCH = By.cssSelector(String.format(DOLLAR_DENOM_BUTTON, amount));
        clickOn($(SWATCH));
        return this;
    }

    public EGiftCardPage enterRecipientsName(String name) {
        typeOn($(RECIPIENTS_NAME_INPUT), name);
        return this;
    }

    public EGiftCardPage enterRecipientsEmailAddress(String email) {
        typeOn($(RECIPIENTS_EMAIL_ADDRESS_INPUT), email);
        return this;
    }

    public EGiftCardPage addPersonalMessage(String message) {
        typeOn($(PERSONAL_MESSAGE_INPUT), message);
        return this;
    }

    public EGiftCardPage enterYourName(String name) {
        typeOn($(YOUR_NAME_INPUT), name);
        return this;
    }

    public EGiftCardPage enterYourEmailAddress(String email) {
        typeOn($(YOUR_EMAIL_ADDRESS_INPUT), email);
        return this;
    }

    public EGiftCardPage addToCart() {
        waitForApp(5);
        clickOn($(ADD_TO_CART_BUTTON));
        waitForApp(5);
        return this;
    }

    public EGiftCardPage shopNow() {
        scrollDown(3);
        clickOn(findAll(SHOP_NOW_BUTTON).get(0));
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
