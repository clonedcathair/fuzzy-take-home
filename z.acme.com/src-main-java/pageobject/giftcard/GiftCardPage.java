package xxx.pageobject.giftcard;

import fuzzy.interview.model.product.intangible.GiftCard;
import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;

public class GiftCardPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final String DOLLAR_DENOM_BUTTON = "#maincontent .physical-gift-card button[data-value='%s']";

    private static final By CUSTOM_AMOUNT_INPUT = By.cssSelector("#gc-amount");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("#maincontent .prices-add-to-cart-actions .add-to-cart-check");
    private static final By PERSONAL_MESSAGE_INPUT = By.cssSelector("#gcMessage");
    private static final By SHOP_NOW_BUTTON = By.xpath("//a[contains(.,'Shop Now')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public GiftCardPage selectAmount(GiftCard asProductType) {
        scrollDown(2);
        // manually set the desired amount if custom amount
        return (GiftCard.DOLLAR_CUSTOM.getSKU().equals(asProductType.getSKU())) ?
                enterCustomAmount(asProductType.getAmount()) :
                clickAmount(asProductType.getAmount());
    }

    public GiftCardPage enterCustomAmount(String amount) {
        typeOn($(CUSTOM_AMOUNT_INPUT), amount);
        return this;
    }

    public GiftCardPage clickAmount(String amount) {
        final String SWATCH = String.format(DOLLAR_DENOM_BUTTON, amount);
        clickOn($(SWATCH));
        return this;
    }

    public GiftCardPage addPersonalMessage(String message) {
        typeOn($(PERSONAL_MESSAGE_INPUT), message);
        return this;
    }

    public GiftCardPage addToCart() {
        clickOn($(ADD_TO_CART_BUTTON));
        return this;
    }

    public GiftCardPage shopNow() {
        scrollDown(3);
        clickOn(findAll(SHOP_NOW_BUTTON).get(1));
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
