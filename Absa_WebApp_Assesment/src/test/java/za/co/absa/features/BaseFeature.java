package za.co.absa.features;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import za.co.absa.tasks.OpenTheApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseFeature {
    @Managed()
    public WebDriver theirWebDriver;

    @Steps
    protected OpenTheApplication openTheApplication;

    protected Actor dataCapturer ;

    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String passWord;
    protected String customer;
    protected String role;
    protected String email;
    protected String cell;


    @Before
    public void user_can_browse_the_web(){
        dataCapturer = Actor.named("Thabo");
        dataCapturer.can(BrowseTheWeb.with(theirWebDriver));
        userName = userName+"_"+new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

    }
}
