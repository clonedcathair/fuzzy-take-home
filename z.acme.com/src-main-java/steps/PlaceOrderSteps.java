package xxx.steps;

import fuzzy.interview.model.common.Expected;
import fuzzy.interview.model.common.User;
import fuzzy.interview.model.product.apparel.Apparel;
import fuzzy.interview.model.product.bachelor.Bachelor;
import fuzzy.interview.model.product.intangible.EGiftCard;
import fuzzy.interview.model.product.intangible.GiftCard;
import fuzzy.interview.model.westadvantage.Membership;
import fuzzy.interview.pageobject.checkout.AccountInformationPage;
import fuzzy.interview.pageobject.checkout.DeliveryPage;
import fuzzy.interview.pageobject.checkout.PaymentPage;
import fuzzy.interview.pageobject.common.*;
import fuzzy.interview.pageobject.giftcard.EGiftCardPage;
import fuzzy.interview.pageobject.giftcard.GiftCardPage;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceOrderSteps extends AbstractSteps {

    HomePage homePage;
    NavigationPage navigationPage;
    MyCartPage myCartPage;
    GiftCardPage giftCardPage;
    EGiftCardPage eGiftCardPage;
    DeliveryPage deliveryPage;
    PaymentPage paymentPage;
    ReceiptPage receiptPage;
    ProductDetailsPage productDetailsPage;
    SearchResultsPage searchResultsPage;
    AccountInformationPage accountInformationPage;

    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS
    public PlaceOrderSteps starts_on_my_account_page(User forThisUser) {
        Expected.user = forThisUser;
        homePage.openApplication(forThisUser);
        navigationPage.
                enterCredentials(forThisUser).
                signIn().
                verifyUserLoggedIn(forThisUser.getFirstname());
        myCartPage.viewCart();
        myCartPage.emptyCart();
        return this;
    }

    public PlaceOrderSteps place_order_for(GiftCard asProductType) {
        Expected.giftCard = asProductType;
        navigationPage.search("gift card");

        // add item to cart
        giftCardPage.
                shopNow().
                selectAmount(Expected.giftCard).
                addPersonalMessage(Expected.giftCard.getMessage()).
                addToCart();

        // checkout shopping cart
        myCartPage.checkout();
        deliveryPage.
                enterShippingAddress(Expected.user.getShippingAddress()).
                selectShippingMethod(Shipping.FREE_SHIPPING).
                clickNextPayment();

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps place_order_for(EGiftCard asProductType) {
        Expected.eGiftCard = asProductType;
        navigationPage.search("gift card");

        // add item to cart
        eGiftCardPage.
                shopNow().
                selectAmount(Expected.eGiftCard).
                enterRecipientsName("WMQA TestRecipient").
                enterRecipientsEmailAddress(Expected.user.getEmail()).
                addPersonalMessage(Expected.eGiftCard.getMessage()).
                enterYourName(Expected.user.getFirstname()).
                enterYourEmailAddress(Expected.user.getEmail()).
                addToCart();

        // checkout shopping cart
        myCartPage.checkout();
        paymentPage.enterBillingAddress(Expected.user.getBillingAddress());

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps place_order_for(Bachelor asProductType) {
        Expected.bachelor = asProductType;
        navigationPage.search(Expected.bachelor.getSKU());

        // add item to cart and checkout
        productDetailsPage.
                selectWarranty(Expected.bachelor.getWarranty()).
                addToCart();
        myCartPage.checkout();

        // enter shipping address
        deliveryPage.
                enterShippingAddress(Expected.user.getShippingAddress()).
                selectShippingMethod(Shipping.HAZARDOUS_STANDARD).
                clickNextPayment();

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps place_order_for(Family asProductType) {
        Expected.family = asProductType;
        navigationPage.search(Expected.family.getName());
        searchResultsPage.selectFirstProduct();

        // add item to cart and checkout
        productDetailsPage.
                selectProductOption(Expected.family.getOption()).
                increaseQuantityTo(5).
                addToCart();
        myCartPage.checkout();

        // enter shipping address
        deliveryPage.
                enterShippingAddress(Expected.user.getShippingAddress()).
                clickNextPayment();

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps place_order_for(Apparel asProductType) {
        Expected.apparel = asProductType;
        navigationPage.search(asProductType.getSKU());

        // add item to cart and checkout
        productDetailsPage.
                clickColor(Expected.apparel.getColor()).
                selectSize(Expected.apparel.getSize()).
                increaseQuantity().
                addToCart();
        myCartPage.checkout();

        // enter shipping address
        deliveryPage.
                enterShippingAddress(Expected.user.getShippingAddress()).
                clickNextPayment();

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps place_order_for(Membership membership) {
        Expected.membership = membership;

        // checkout shopping cart
        myCartPage.checkout();
        deliveryPage.
                selectShippingMethod(Shipping.FREE_SHIPPING).
                clickNextPayment();

        // home stretch, submit order
        paymentPage.
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder().
                clickPlaceOrder();
        return this;
    }

    public PlaceOrderSteps checkout_to_payment_summary_with(Bachelor asProductType) {
        Expected.bachelor = asProductType;
        navigationPage.search(Expected.bachelor.getSKU());

        // add item to cart and checkout
        productDetailsPage.
                selectWarranty(Expected.bachelor.getWarranty()).
                addToCart();
        myCartPage.checkout();

        // enter po number if pro user
        if (UserType.PRO == Expected.user.getUserType())
            accountInformationPage.enterPONumber();

        // enter shipping address
        deliveryPage.
                enterShippingAddress(Expected.user.getShippingAddress()).
                clickNextPayment();
        return this;
    }

    public PlaceOrderSteps checkout_to_payment_summary_with(EGiftCard asProductType) {
        Expected.eGiftCard = asProductType;
        navigationPage.search("gift card");

        // add item to cart
        eGiftCardPage.
                shopNow().
                selectAmount(Expected.eGiftCard).
                enterRecipientsName("WMQA TestRecipient").
                enterRecipientsEmailAddress(Expected.user.getEmail()).
                addPersonalMessage(Expected.eGiftCard.getMessage()).
                enterYourName(Expected.user.getFirstname()).
                enterYourEmailAddress(Expected.user.getEmail()).
                addToCart();

        // checkout shopping cart
        myCartPage.checkout();
        paymentPage.
                enterBillingAddress(Expected.user.getBillingAddress()).
                enterPaymentMethod(Expected.user.getPayment()).
                clickNextReviewOrder();
        return this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // ASSERTIONS
    public PlaceOrderSteps should_see_on_receipt() {
        receiptPage.
                verifyNoErrorDisplayed().
                verifyReceiptDisplayed().
                verifyOrderNumber().
                verifyThankYou(Expected.user.getEmail());
        return this;
    }

    public PlaceOrderSteps subtotal(double expected) {
        //receiptPage.verifySubTotal(String.valueOf(expected));
        return this;
    }
    public PlaceOrderSteps shipping(double expected) {
        //receiptPage.verifyShipping(String.valueOf(expected));
        return this;
    }
    public PlaceOrderSteps estimated_tax(double expected) {
        //receiptPage.verifyEstimatedTax(String.valueOf(expected));
        return this;
    }

    public PlaceOrderSteps order_total(double expected) {
        receiptPage.verifyOrderTotal(String.valueOf(expected));
        return this;
    }
    public PlaceOrderSteps order_total(String expected) {
        receiptPage.verifyOrderTotal(expected);
        return this;
    }

    public PlaceOrderSteps should_see_payment_summary_with_no_tax() {
        assertThat(paymentPage.isOrderTaxed()).as("Order should NOT be taxed").isFalse();
        return this;
    }

    public PlaceOrderSteps should_see_payment_summary_with_tax() {
        assertThat(paymentPage.isOrderTaxed()).as("Order should be taxed").isTrue();
        return this;
    }
}
