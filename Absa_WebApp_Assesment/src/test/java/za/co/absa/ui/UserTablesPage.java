package za.co.absa.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UserTablesPage {
    public static Target  USENAME_VALUE = Target.the("UserName Value").locatedBy("//tr[1]//td[3]");
    public static  Target ADD_USER_BUTTON = Target.the("add user button").locatedBy("//button[@class='btn btn-link pull-right']");
}
