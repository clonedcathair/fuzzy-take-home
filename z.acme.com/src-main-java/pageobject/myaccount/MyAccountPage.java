package xxx.pageobject.myaccount;

import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;

public class MyAccountPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By HI_USER = By.cssSelector(".user-message.wm-lead-label");
    private static final By WELCOME_USER = By.cssSelector("#maincontent .account-page-bg.pt-5 .mt-sm-5.text-capitalize");

    private static final By JOIN_REWARDS_PROGRAM_LINK = By.xpath("//a[contains(.,'Join Rewards Program')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public MyAccountPage clickJoinRewardsProgram() {
        clickOn($(JOIN_REWARDS_PROGRAM_LINK));
        scrollDown();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS
    public String hiUser() {
        return getTextOn($(HI_USER));
    }

    public String welcomeBackMessage() {
        return getTextOn($(WELCOME_USER));
    }

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
