package za.co.absa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import za.co.absa.ui.UserTablesPage;

public class UserTable implements Question<String> {
    public static Question<String> value() {
        return new UserTable();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UserTablesPage.ADD_USER_BUTTON).viewedBy(actor).asString();
    }
}
