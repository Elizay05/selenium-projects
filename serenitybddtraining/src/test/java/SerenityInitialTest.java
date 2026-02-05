import facts.NetflixPlans;
import models.users.Datum;
import models.users.RegisterUserInfo;
import models.users.UpdateUserInfo;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetNetflixPlans;
import tasks.GetUsers;
import tasks.RegisterUser;
import tasks.UpdateUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SerenityJUnit5Extension.class)
public class SerenityInitialTest {

    private static final String baseUrl = "http://localhost:5000/api";

    @Test
    public void getUsersTest() {

        Actor sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));

        sayira.attemptsTo(
                GetUsers.fromPage(1)
        );

        sayira.should(
                seeThat("the response code was", ResponseCode.was(), equalTo(200))
        );

        Datum user = new GetUsersQuestion().answeredBy(sayira)
                .getData().stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);

        sayira.should(
                seeThat("the user is not null", act -> user, notNullValue())
        );

        sayira.should(
                seeThat("the user email", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("the user avatar", act -> user.getAvatar(), equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
        );
    }

    @Test
    public void registerUserTest(){

        Actor sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));

        RegisterUserInfo registerUserInfo = new RegisterUserInfo();
        registerUserInfo.setName("morpheus");
        registerUserInfo.setJob("leader");
        registerUserInfo.setEmail("tracey.ramos@reqres.in");
        registerUserInfo.setPassword("serenity");

        sayira.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)
        );

        sayira.should(
                seeThat("the response code was", ResponseCode.was(), equalTo(200))
        );
    }

    @Test
    public void updateUserTest(){

        Actor sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));

        UpdateUserInfo updateUserInfo = new UpdateUserInfo();
        updateUserInfo.setName("morpheus");
        updateUserInfo.setJob("zion resident");

        sayira.attemptsTo(
                UpdateUser.withInfo(2, updateUserInfo)
        );

        sayira.should(
                seeThat("the response code was", ResponseCode.was(), equalTo(200))
        );
    }

    @Test
    public void factTest() {

        Actor sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));

        sayira.attemptsTo(
                GetNetflixPlans.fromApi()
        );

        sayira.has(
                new NetflixPlans()
        );
    }
}
