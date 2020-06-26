package za.co.absa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import za.co.absa.ui.Way2AutomateLandingPage;

public class OpenTheApplication implements Task {
    private Way2AutomateLandingPage way2AutomateLandingPage;

    @Override
    @Step("Opens wayToAutomate website")
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(Open.browserOn().the(way2AutomateLandingPage));

    }
}
