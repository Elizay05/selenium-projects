package tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetNetflixPlans implements Task {

    public static GetNetflixPlans fromApi() {
        return instrumented(GetNetflixPlans.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/plans")
        );

        List<HashMap<String, String>> plans =
                SerenityRest.lastResponse().path("data");

        actor.remember("plans", plans);
    }
}