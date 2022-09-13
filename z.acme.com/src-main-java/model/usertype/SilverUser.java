package xxx.model.usertype;

import xxx.model.common.Address;
import xxx.model.common.Payment;
import xxx.model.common.User;

public class SilverUser {
    public static User user() {
        User silver = new User();
        silver.setFirstname("SilviaSilver");
        silver.setLastname("WMQA");
        silver.setEmail("silviasilverwmqa@gmail.com");
        silver.setPassword(User.DEFAULT_PASSWORD);
        silver.setConfirmPassword(User.DEFAULT_PASSWORD);
        silver.setStayUpdated(false);
        silver.setBillingAddress(Address.CA_WATSONVILLE_WESTRIDGE_DR);
        silver.setShippingAddress(Address.CA_HOLLISTER_BERT_DR);
        silver.setPayment(Payment.MASTERCARD);
        silver.setUserType(UserType.RETAIL);
        return silver;
    }
}
