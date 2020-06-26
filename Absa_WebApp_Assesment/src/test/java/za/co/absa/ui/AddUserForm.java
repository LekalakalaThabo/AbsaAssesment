package za.co.absa.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AddUserForm {
    public static Target FIRST_NAME_FIELD = Target.the("first name field").locatedBy("//input[@name='FirstName']");;
    public static Target LAST_NAME_FIELD = Target.the("last name field").locatedBy("//input[@name='LastName']");;
    public static Target  EMAIL_FIELD = Target.the("email name field").locatedBy("//input[@name='Email']");
    public static Target  PHONE_FIELD = Target.the("password field").locatedBy("//input[@name='Mobilephone']");
    public static Target USER_NAME_FIELD = Target.the("user name field").locatedBy("//input[@name='UserName']");
    public static Target PASSWORD_FIELD = Target.the("password field").locatedBy("//input[@name='Password']");
    public static Target AAA_RADIO_BUTTON = Target.the("AAA radio button").locatedBy("//label[1]//input[1]");
    public static Target BBB_RADIO_BUTTON = Target.the("BBB radio button").locatedBy("//label[2]//input[1]");
    public static Target SALES_ROLE_OPTION = Target.the("sales option").locatedBy("//select[@name='RoleId']/option[1]");
    public static Target CUSTOMER_ROLE_OPTION = Target.the("customer option").locatedBy("//select[@name='RoleId']/option[2]");
    public static Target ADMIN_ROLE_OPTION = Target.the("admin option").locatedBy("//select[@name='RoleId']/option[3]");
    public static Target HEADING = Target.the("form heading").locatedBy("//h3[@class='ng-binding']");
    public static Target CLOSE_BUTTON = Target.the("close button").locatedBy("//button[@class='btn btn-danger']");
    public static Target SAVE_BUTTON = Target.the("save button").locatedBy("//button[@class='btn btn-success']");

    //
}
