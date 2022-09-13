package fuzzy.interview.pageobject;

import fuzzy.interview.model.product.Product;
import fuzzy.interview.model.product.SortedBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends FuzzyPO {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By HEADER_TEXT = By.cssSelector(".title");
    private static final By SORT_DROPDOWN = By.cssSelector(".product_sort_container");
    private static final By PRODUCT_IMAGE = By.cssSelector("#item_4_img_link > img");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private static final By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
    private static final By PRICE_TEXT = By.cssSelector(".inventory_item_price");
    private static final By CART_COUNT_TEXT = By.cssSelector(".shopping_cart_badge");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public ProductPage sort(SortedBy by) {
        new Select($(SORT_DROPDOWN)).selectByVisibleText(by.getText());
        return this;
    }

    public ProductPage addToCart(Product product) {
        // TODO: product param not being used, or implemented, for sake of time
        // TODO: just click the first Add to cart button found on page
        findAll(By.cssSelector(".inventory_item")).stream().findAny().get()
                .findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public ProductPage removeFromCart(Product product) {
        // TODO: product param not being used, or implemented, for sake of time
        // TODO: just click the first Remove button found on page
        findAll(By.cssSelector(".inventory_item")).stream().findAny().get()
                .findElement(REMOVE_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    public String getHeaderText() {
        return $(HEADER_TEXT).getText();
    }

    public String getImageSrc() {
        new WebDriverWait(getDriver(),5).
                until(ExpectedConditions.visibilityOf($(PRODUCT_IMAGE)));
        return findFirst(PRODUCT_IMAGE).get().getAttribute("src");
    }

    public ListOfWebElementFacades getPrices() {
        return findAll(PRICE_TEXT);
    }

    public int getCartCount() {
        if (findAll(CART_COUNT_TEXT).isEmpty())
            return 0;
        return Integer.valueOf($(CART_COUNT_TEXT).getText());
    }

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY


}
