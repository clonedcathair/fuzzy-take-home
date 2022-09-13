package xxx.pageobject.checkout;

import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInformationPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By PO_NUMBER_INPUT      = By.cssSelector("#shippingPoNumber");
    private static final By NEXT_DELIVERY_BUTTON = By.xpath("//span[contains(.,'Next: Delivery')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public AccountInformationPage enterPONumber() {
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(IN_PROGRESS_SPINNER));
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.elementToBeClickable(PO_NUMBER_INPUT));
        $(PO_NUMBER_INPUT).sendKeys("PO" + System.currentTimeMillis());
        $(NEXT_DELIVERY_BUTTON).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY


}
