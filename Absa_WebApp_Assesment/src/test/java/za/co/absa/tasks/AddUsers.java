package za.co.absa.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import za.co.absa.ui.AddUserForm;
import za.co.absa.ui.UserTablesPage;

public class AddUsers implements Task {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private String customer;
    private String role;
    private String email;
    private String cell;

    public AddUsers(String firstName, String lastName, String userName, String passWord, String customer, String role, String email, String cell) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.customer = customer;
        this.role = role;
        this.email = email;
        this.cell = cell;
    }

    public static AddUsers withDetails(String firstName, String lastName, String userName, String passWord, String customer, String role, String email, String cell) {
        return Instrumented.instanceOf(AddUsers.class).withProperties(firstName,lastName,userName,passWord, customer,role,email,cell);

    }

    @Override
    @Step("{0} Adds the user #userName to the list")
    public <T extends Actor> void performAs(T dataCapturer) {
        dataCapturer.attemptsTo(
                //WaitUntil.the(UserTablesPage.ADD_USER_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Ensure.that(UserTablesPage.ADD_USER_BUTTON).isDisplayed(),
                Click.on(UserTablesPage.ADD_USER_BUTTON),
                Ensure.that(AddUserForm.HEADING).textContent().isEqualToIgnoringCase("Add User"),
                Enter.theValue(firstName).into(AddUserForm.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(AddUserForm.LAST_NAME_FIELD),
                Enter.theValue(userName).into(AddUserForm.USER_NAME_FIELD),
                Enter.theValue(passWord).into(AddUserForm.PASSWORD_FIELD)
                );

        if(customer.equalsIgnoreCase("Company AAA")){
            dataCapturer.attemptsTo(
                    Click.on(AddUserForm.AAA_RADIO_BUTTON)
            );
        }else
            dataCapturer.attemptsTo(
                    Click.on(AddUserForm.BBB_RADIO_BUTTON)
            );

        if(role.equalsIgnoreCase("Sales Team")){
            dataCapturer.attemptsTo(
                    Click.on(AddUserForm.SALES_ROLE_OPTION)
            );

        }else if(role.equalsIgnoreCase("Customer")){
            dataCapturer.attemptsTo(
                    Click.on(AddUserForm.CUSTOMER_ROLE_OPTION)
            );

        }else if(role.equalsIgnoreCase("Admin")){
            dataCapturer.attemptsTo(
                    Click.on(AddUserForm.ADMIN_ROLE_OPTION)
            );

        }




        dataCapturer.attemptsTo(
                Enter.theValue(email).into(AddUserForm.EMAIL_FIELD),
                Enter.theValue(cell).into(AddUserForm.PHONE_FIELD),
                Click.on(AddUserForm.SAVE_BUTTON)
        );

    }


}
