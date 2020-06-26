package za.co.absa.features;

import net.thucydides.core.annotations.WithTag;
import za.co.absa.questions.UserTable;
import za.co.absa.tasks.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
public class CaptureUserDate_UsingDataFromLocatDataSourceTest extends BaseFeature{

    public CaptureUserDate_UsingDataFromLocatDataSourceTest(String firstName, String lastName, String userName, String passWord, String customer, String role, String email, String cell) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.customer = customer;
        this.role = role;
        this.email = email;
        this.cell = cell;
    }


    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"FName1","LName1","User1","Pass1","Company AAA","Admin","admin@mail.com","082555"},
                {"FName2","LName2","User2","Pass2","Company BBB","Customer","customer@mail.com","083444"}

        });
    }

    @Test
    @WithTag("localData")
    public void should_validate_that_the_user_is_added_local(){

        givenThat(dataCapturer).wasAbleTo(openTheApplication);

        when(dataCapturer).attemptsTo(AddUsers.withDetails(firstName,lastName,userName,passWord, customer,role,email,cell));

        then(dataCapturer).should(eventually(seeThat(UserTable.value(),containsString(userName))));
    }



}
