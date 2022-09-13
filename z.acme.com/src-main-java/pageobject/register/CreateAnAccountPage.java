package xxx.pageobject.register;

import fuzzy.interview.model.common.User;
import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;

public class CreateAnAccountPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By FIRST_NAME_INPUT = By.cssSelector("#registration-form-fname");
    private static final By LAST_NAME_INPUT = By.cssSelector("#registration-form-lname");
    private static final By EMAIL_INPUT = By.cssSelector("#registration-form-email");
    private static final By PASSWORD_INPUT = By.cssSelector("#registration-form-password");
    private static final By CONFIRM_PASSWORD_INPUT = By.cssSelector("#registration-form-password-confirm");
    private static final By STAY_UPDATED_CHECKBOX = By.cssSelector("#register > form > .form-group.custom-checkbox > label");
    private static final By CREATE_ACCOUNT_BUTTON = By.cssSelector("#register > form > button");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public CreateAnAccountPage enterRegistration(User user) {
        scrollDown();
        typeOn($(FIRST_NAME_INPUT), user.getFirstname());
        typeOn($(LAST_NAME_INPUT), user.getLastname());
        typeOn($(EMAIL_INPUT), user.getEmail());
        typeOn($(PASSWORD_INPUT), user.getPassword());
        typeOn($(CONFIRM_PASSWORD_INPUT), user.getConfirmPassword());

        // by default Stay Updated checked
        if (!user.getStayUpdated())
            clickOn($(STAY_UPDATED_CHECKBOX));
        return this;
    }

    public CreateAnAccountPage createAccount() {
        clickOn($(CREATE_ACCOUNT_BUTTON));
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
