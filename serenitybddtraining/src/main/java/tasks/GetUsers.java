package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    private final int pageNumber;

    public GetUsers(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public static Performable fromPage(int pageNumber) {
        return instrumented(GetUsers.class, pageNumber);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users?page=" + pageNumber).with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .header("header1", "Value1")
                )
        );
    }
}
