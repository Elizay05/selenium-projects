package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class QuestionsStepDefinitions {

    Actor sayira;
    String actualMessage;
    Question<String> actualQuestionMessage;

    @Given("que tengo un dato cualquiera")
    public void que_tengo_un_dato_cualquiera(){
        sayira = Actor.named("sayira");
        actualMessage = "hola mundo";
    }

    @When("quiero obtener una questiom")
    public void quiero_obtener_una_question(){

        actualQuestionMessage = Question.about("el mensaje actual")
                .answeredBy(actor -> actualMessage);

    }

    @Then("puedo hacer una asercion")
    public void puedo_hacer_una_asercion(){
        sayira.should(
                seeThat(actualQuestionMessage, equalTo("hola mundo"))
        );
    }
}
