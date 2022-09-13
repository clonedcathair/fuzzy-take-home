package xxx.model.common;

import _old.proj.ignore.model.usertype.*;
import old.proj.ignore.model.usertype.*;
import xxx.model.usertype.*;
import xxx.model.westadvantage.Membership;
import lombok.Data;

@Data
public class User {

    public final static String DEFAULT_PASSWORD = "SpongeB0b!";

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private Boolean stayUpdated;
    private Membership membership;
    private Address billingAddress;
    private Address shippingAddress;
    private Payment payment;
    private UserType userType;

    public static User garyGuest() {
        return GuestUser.user();
    }
    public static User ronRetail() {
        return RetailUser.user();
    }
    public static User peterPro() {
        return ProUser.user();
    }
    public static User silviaSilver() {
        return SilverUser.user();
    }
    public static User goldieGold() {
        return GoldUser.user();
    }
}