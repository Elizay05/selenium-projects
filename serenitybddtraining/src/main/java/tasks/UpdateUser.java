package tasks;

import interactions.Put;
import io.restassured.http.ContentType;
import models.users.UpdateUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final int userId;
    private final UpdateUserInfo userInfo;

    public UpdateUser(int userId, UpdateUserInfo userInfo) {
        this.userId = userId;
        this.userInfo = userInfo;
    }


    public static Performable withInfo(int userId, UpdateUserInfo userInfo) {
        return instrumented(UpdateUser.class, userId, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/users/" + userId).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
