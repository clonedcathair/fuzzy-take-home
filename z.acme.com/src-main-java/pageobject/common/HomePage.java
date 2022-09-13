package xxx.pageobject.common;

import xxx.pageobject.FuzzyPageObject;
import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.Duration;

public class HomePage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS


    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public HomePage openApplication(User forThisUser) {
        Expected.user = forThisUser;
        switch (Expected.user.getUserType()) {
            case GUEST:
            case RETAIL:
                Expected.baseUrl = getRetailURL();
                Expected.checkoutUrl = getRetailCheckoutURL();
                break;
            case PRO:
                Expected.baseUrl = getProURL();
                Expected.checkoutUrl = getProCheckoutURL();
                break;
            default:
                throw new RuntimeException("[Not Yet Implemented] Invalid user type" + forThisUser);
        }
        getDriver().get(Expected.baseUrl);
        verifyHomePageDisplayed();
        return this;
    }

    private boolean isShownAsCompleted(WebElementFacade itemRow) {
        return itemRow.find(By.tagName("label")).getCssValue("text-decoration").contains("line-through");
    }

    public void toggleAll() {
        evaluateJavascript("arguments[0].click();",$ ("#toggle-all"), $("."));
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    //public AccountStatus statusOf(String todoItem) {
    //    WebElementFacade itemRow = inItemRowFor(todoItem);
    //    return isShownAsCompleted(itemRow) ? TodoStatus.Completed : TodoStatus.Active;
    //}

    //public List<String> displayedItems() {
    //    return findAll(".view").stream()
    //            .map(WebElementFacade::getText)
    //            .collect(Collectors.toList());
    //}

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY
    public HomePage verifyHomePageDisplayed() {
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(NavigationPage.SIGN_IN_DROPDOWN);
        clearTrackingPrivacyEmailSignup();
        return this;
    }
}
