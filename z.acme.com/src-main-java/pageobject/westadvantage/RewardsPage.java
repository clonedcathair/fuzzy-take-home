package xxx.pageobject.westadvantage;

import fuzzy.interview.model.westadvantage.Membership;
import fuzzy.interview.model.westadvantage.OptionalServices;
import xxx.pageobject.FuzzyPageObject;
import org.openqa.selenium.By;

public class RewardsPage extends FuzzyPageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // SELECTORS
    private static final By GOLD_LOYALTY_BUTTON   = By.xpath("//a[contains(.,'Join West Advantage\n      GOLD – $25/year')]");
    private static final By SILVER_LOYALTY_BUTTON = By.xpath("//a[contains(.,'JOIN WEST ADVANTAGE SILVER – FREE')]");

    private static final By ADDRESS1_INPUT = By.cssSelector("#address1");
    private static final By ADDRESS2_INPUT = By.cssSelector("#address2");
    private static final By CITY_INPUT = By.cssSelector("#city");
    private static final By STATE_DROPDOWN = By.cssSelector("#state");
    private static final By ZIP_CODE_INPUT = By.cssSelector("#zipCode");
    private static final By COUNTRY_DROPDOWN = By.cssSelector("#country");
    private static final By PHONE_NUMBER_INPUT = By.cssSelector("#phone");

    private static final By I_AGREE_CHECKBOX = By.xpath("//label[contains(.,'I Agree')]");

    private static final By TRAILER_ASSIST_CHECKBOX = By.xpath("//label[contains(.,'TRAILER ASSIST')]");
    private static final By UNLIMITED_FRESHWATER_TOWING_CHECKBOX = By.xpath("//label[contains(.,'Unlimited Freshwater Towing')]");
    private static final By UNLIMITED_SALTWATER_FRESHWATER_TOWING_CHECKBOX = By.xpath("//label[contains(.,'Unlimited Saltwater and Freshwater Towing')]");
    private static final By UNLIMITED_GOLD_CHECKBOX = By.xpath("//label[contains(.,'Unlimited Gold Towing')]");

    private static final By PURCHASE_MEMBERSHIP_BUTTON = By.cssSelector(".btn-finalize-enrollment");
    private static final By I_AGREE_TO_WEST_ADVANTAGE_GOLD_CHECKBOX = By.xpath("//span[contains(.,'I AGREE to the West Advantage Gold Rewards Program')]");
    private static final By I_AGREE_TO_WEST_ADVANTAGE_SILVER_CHECKBOX = By.xpath("//span[contains(.,'I AGREE to the West Advantage Silver Rewards Program')]");

    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(.,'Add to Cart')]");

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    public RewardsPage clickJoinWestAdvantage(Membership membership) {
        scrollDown(2);
        switch (membership) {
            case GOLD:   clickOn($(GOLD_LOYALTY_BUTTON));   break;
            case SILVER: clickOn($(SILVER_LOYALTY_BUTTON)); break;
            default:
                throw new RuntimeException("Invalid membership type: " + membership);
        }
        return this;
    }

    public RewardsPage enterAddressPhone() {
        typeOn($(ADDRESS1_INPUT), "500 Westridge Rd");
        typeOn($(ADDRESS2_INPUT), "");
        typeOn($(CITY_INPUT), "Watsonville");
        selectOptionOn($(STATE_DROPDOWN), "California");
        typeOn($(ZIP_CODE_INPUT), "95076");
        selectOptionOn($(COUNTRY_DROPDOWN), "United States");
        typeOn($(PHONE_NUMBER_INPUT), "4085551212");
        return this;
    }

    public RewardsPage selectIAgree() {
        clickOn($(I_AGREE_CHECKBOX));
        return this;
    }

    public RewardsPage clickPurchaseMembership() {
        clickOn($(PURCHASE_MEMBERSHIP_BUTTON));
        return this;
    }

    public RewardsPage selectOptionalServices(OptionalServices services) {
        // TODO: [refactor] make services multi-selectable with OptionalServices...
        switch(services) {
            case TRAILER_ASSIST:
                clickOn($(TRAILER_ASSIST_CHECKBOX));
                break;
            case UNLIMITED_FRESHWATER_TOWING:
                clickOn($(UNLIMITED_FRESHWATER_TOWING_CHECKBOX));
                break;
            case UNLIMITED_SALTWATER_FRESHWATER_TOWING:
                clickOn($(UNLIMITED_SALTWATER_FRESHWATER_TOWING_CHECKBOX));
                break;
            case UNLIMITED_GOLD_TOWING:
                clickOn($(UNLIMITED_GOLD_CHECKBOX));
                break;
            default:
                throw new RuntimeException("Invalid optional service type: " + services);
        }
        return this;
    }

    public RewardsPage clickIAgreeToWestAdvantage(Membership membership) {
        switch(membership) {
            case GOLD:   clickOn($(I_AGREE_TO_WEST_ADVANTAGE_GOLD_CHECKBOX));   break;
            case SILVER: clickOn($(I_AGREE_TO_WEST_ADVANTAGE_SILVER_CHECKBOX)); break;
            default:
                throw new RuntimeException("Invalid membership type: " + membership);
        }
        return this;
    }

    public RewardsPage clickAddToCart() {
        clickOn($(ADD_TO_CART_BUTTON));
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // GETTERS

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFY

}
