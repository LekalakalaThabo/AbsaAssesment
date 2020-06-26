package za.co.absa.features;

import net.thucydides.core.annotations.WithTag;
import za.co.absa.questions.UserTable;
import za.co.absa.tasks.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/TestData/TestData.csv")
public class CaptureUserDate_UsingDataFromCSVTest {
    @Managed()
    public WebDriver theirWebDriver;

    @Steps
    OpenTheApplication openTheApplication;

    private Actor dataCapturer ;

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String customer;
    private String role;
    private String email;
    private String cell;

    @Before
    public void user_can_browse_the_web(){
        dataCapturer = Actor.named("Thabo");
        dataCapturer.can(BrowseTheWeb.with(theirWebDriver));
    }

    @Test
    @WithTag("CSVData")
    public void should_validate_that_the_user_is_added_csv(){
        givenThat(dataCapturer).wasAbleTo(openTheApplication);

        when(dataCapturer).attemptsTo(AddUsers.withDetails(firstName,lastName,userName,passWord, customer,role,email,cell));

        then(dataCapturer).should(eventually(seeThat(UserTable.value(),containsString(userName))));
    }



}
