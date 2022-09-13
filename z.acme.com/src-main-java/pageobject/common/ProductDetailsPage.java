package xxx.pageobject.common;

import fuzzy.interview.model.product.apparel.Color;
import fuzzy.interview.model.product.apparel.Size;
import fuzzy.interview.model.product.bachelor.Warranty;
import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsPage extends FuzzyPageObject {

    protected final Logger LOGGER = Logger.getLogger(String.valueOf(this));

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final String COLOR_BUTTON = "#maincontent .product-info-panel .product-attribute button[aria-describedby='%s']";

    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(.,'Add to Cart')]");
    private static final By MESSAGE_POPUP = By.cssSelector("body > .add-to-cart-messages.mx-auto.position-fixed");
    private static final By PRODUCT_DROPDOWN = By.cssSelector("#child_relation-1");
    private static final By PLUS_BUTTON = By.cssSelector("#plus");
    private static final By MINUS_BUTTON = By.cssSelector("#minus");
    private static final By AVAILABILITY_TEXT = By.cssSelector(".product-availability");
    private static final By SIZE_DROPDOWN = By.cssSelector("#size-1");

    private static final By ONE_YEAR_PLUS_CHECKBOX = By.xpath("//label[contains(.,'1 Year PLUS Product Protection Plan')]");
    private static final By TWO_YEAR_PLUS_CHECKBOX = By.xpath("//label[contains(.,'2 Year PLUS Product Protection Plan')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public ProductDetailsPage selectProductOption(String option) {
        selectOptionOn($(PRODUCT_DROPDOWN), option);
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.textToBePresentInElementLocated(AVAILABILITY_TEXT, "In Stock"));
        return this;
    }

    public ProductDetailsPage increaseQuantityTo(int howMany) {
        IntStream.range(0, howMany - 1).forEach(i -> increaseQuantity());
        return this;
    }

    public ProductDetailsPage increaseQuantity() {
        clickOn($(PLUS_BUTTON));
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER));
        return this;
    }

    public ProductDetailsPage decreaseQuantity() {
        clickOn($(MINUS_BUTTON));
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER));
        return this;
    }

    public ProductDetailsPage clickColor(Color expected) {
        final By COLOR_SWATCH = By.cssSelector( String.format(COLOR_BUTTON, expected.getName().toUpperCase()) );
        clickOn($(COLOR_SWATCH));
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER));
        return this;
    }

    public ProductDetailsPage selectSize(Size expected) {
        selectOptionOn($(SIZE_DROPDOWN), expected.getLabel());
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER));
        return this;
    }

    public ProductDetailsPage addToCart() {
        waitForApp(5);
        clickOn($(ADD_TO_CART_BUTTON));
        // check confirm message after clicking Add to Cart
        verifyMessage("Product added to cart");
        return this;
    }

    public ProductDetailsPage selectWarranty(Warranty expected) {
        if (expected != null)
            switch (expected) {
                //case NO_WARRANTY: break;
                case ONE_YEAR_PLUS: clickOn($(ONE_YEAR_PLUS_CHECKBOX)); break;
                //case TWO_YEAR_PLUS: clickOn($(TWO_YEAR_PLUS_CHECKBOX)); break;
                default:
                    throw new RuntimeException("Unknowm warranty type: " + expected);
            }
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public ProductDetailsPage verifyMessage(String expected) {
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_POPUP));
        assertThat($(MESSAGE_POPUP).getText()).as("Invalid message displayed").
                isEqualTo(expected);
        waitForApp(5);
        return this;
    }
}
