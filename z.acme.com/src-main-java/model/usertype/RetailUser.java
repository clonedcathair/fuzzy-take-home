package xxx.model.usertype;

import xxx.model.common.Address;
import xxx.model.common.Payment;
import xxx.model.common.User;

public class RetailUser {
    public static User user() {
        User retail = new User();
        retail.setFirstname("RonRetail");
        retail.setLastname("WMQA");
        retail.setEmail("ronretailwmqa@gmail.com");
        retail.setPassword(User.DEFAULT_PASSWORD);
        retail.setConfirmPassword(User.DEFAULT_PASSWORD);
        retail.setStayUpdated(true);
        retail.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        retail.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        retail.setPayment(Payment.MASTERCARD);
        retail.setUserType(UserType.RETAIL);
        return retail;
    }
}
