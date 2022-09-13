package xxx.pageobject.common;

import xxx.pageobject.FuzzyPageObject;
import fuzzy.interview.model.common.Expected;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class MyCartPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By CART_ITEMS = By.cssSelector("#maincontent .container.cart-page > .row > .main-cards-container > .product-info");
    private static final By REMOVE_X_BUTTON = By.cssSelector(".line-item-header > .remove-line-item > button > span");
    private static final By CONFIRM_YES_BUTTON = By.cssSelector("#removeProductModal .modal-footer .cart-delete-confirmation-btn");
    private static final By CHECKOUT_BUTTON = By.xpath("//a[contains(.,'Checkout')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public MyCartPage emptyCart() {
        List<WebElementFacade> items = findAll(CART_ITEMS);
        for (WebElementFacade item : items) {
            clickOn(item.find(REMOVE_X_BUTTON));
            clickOn($(CONFIRM_YES_BUTTON));
            waitForApp(5);
            refresh();
        }
        return this;
    }

    public MyCartPage viewCart() {
        getDriver().get(Expected.baseUrl + "/cart");
        return this;
    }

    public MyCartPage checkout() {
        viewCart();
        $(CHECKOUT_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}