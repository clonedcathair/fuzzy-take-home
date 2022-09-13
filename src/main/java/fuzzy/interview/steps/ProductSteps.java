package fuzzy.interview.steps;

import fuzzy.interview.model.product.Product;
import fuzzy.interview.model.product.SortedBy;
import fuzzy.interview.pageobject.LoginPage;
import fuzzy.interview.pageobject.ProductPage;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.user.User;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps extends AbstractSteps {

    EnvironmentVariables environmentVariables;
    LoginPage loginPage;
    ProductPage productPage;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public ProductSteps on_product_page(User forThisUser) {
        Expected.user = forThisUser;
        loginPage.openPage().signin();

        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return this;
    }

    public ProductSteps when_product_is(SortedBy by) {
        productPage.sort(by);
        return this;
    }

    public ProductSteps add_any_product_to_cart() {
        productPage.addToCart(Product.getAny());
        return this;
    }

    public ProductSteps remove_any_from_the_cart() {
        productPage.removeFromCart(Product.getAny());
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public ProductSteps should_see_first_product_with_the_price_of(double price) {
        String expectedPrice = String.format("$%s", price);
        String actualPrice = productPage.getPrices().get(0).getText();
        assertThat(actualPrice).as("Incorrect product price")
                .isEqualTo(expectedPrice);
        return this;
    }

    public ProductSteps should_see_cart_count_of(int expected) {
        assertThat(productPage.getCartCount()).as("Incorrect cart count").
                isEqualTo(expected);
        return this;
    }
}
