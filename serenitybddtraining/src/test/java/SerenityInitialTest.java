import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.ResponseCode;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class SerenityInitialTest {

    private static final String baseUrl = "http://localhost:5000/api";

    @Test
    public void getUsers(){

        Actor sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));

        sayira.attemptsTo(
                GetUsers.fromPage(3)
        );

        sayira.should(
                seeThat("the response code was", ResponseCode.was(), equalTo(200))
        );
    }
}
