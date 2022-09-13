package fuzzy.interview.pageobject;

import org.openqa.selenium.By;

public class MenuPage extends FuzzyPO {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By BURGER_ICON = By.cssSelector("#react-burger-menu-btn");
    private static final By LOGOUT_MENU = By.cssSelector("#logout_sidebar_link");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public MenuPage signout() {
        $(BURGER_ICON).click();
        $(LOGOUT_MENU).click();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS


    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY


}
