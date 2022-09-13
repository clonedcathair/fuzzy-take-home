package xxx.pageobject.common;

import xxx.pageobject.FuzzyPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.fail;

public class SearchResultsPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By PRODUCTS_LINK = By.cssSelector("#product-tab");
    private static final By ARTICLES_LINK = By.cssSelector("#articles-tab");

    private static final By SHOWING_RESULTS_FOR_TEXT = By.cssSelector(".result-count");
    private static final By PRODUCTS_TILES = By.cssSelector("#product-search-results .product-tile");
    private static final By PRODUCT_TILE = By.cssSelector(".tile-image");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public SearchResultsPage selectFirstProduct() {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.visibilityOfElementLocated(SHOWING_RESULTS_FOR_TEXT));
        clickOn(findAll(PRODUCTS_TILES).get(0));
        return this;
    }

    public SearchResultsPage selectProductOption(String containingText) {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.visibilityOfElementLocated(SHOWING_RESULTS_FOR_TEXT));
        Optional<WebElementFacade> found = findAll(PRODUCTS_TILES).stream()
                .filter(tile -> tile.find(PRODUCT_TILE).containsText(containingText))
                .findAny();
        if (!found.isPresent())
            fail("Could not find product in search results containing: " + containingText);
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    public List<String> displayed() {
        return findAll(".view").stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
