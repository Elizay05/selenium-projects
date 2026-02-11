package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.users.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseCode;
import tasks.RegisterUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDefinitions {

    private static final String baseUrl = "http://localhost:5000/api";
    Actor sayira;

    @Given("Sayira es un cliente que quiere poder administrar su productos bancarios")
    public void sayiraEsUnClienteQueQuierePoderAdministrarSuProductosBancarios() {
        sayira = Actor.named("Sayira the tester")
                .whoCan(CallAnApi.at(baseUrl));
    }

    @When("El envia la información requerida para el registro")
    public void elEnviaLaInformaciónRequeridaParaElRegistro() {
        /*
        RegisterUserInfo registerUserInfo = new RegisterUserInfo();
        registerUserInfo.setName("morpheus");
        registerUserInfo.setJob("leader");
        registerUserInfo.setEmail("tracey.ramos@reqres.in");
        registerUserInfo.setPassword("serenity");
        */

        sayira.attemptsTo(
                RegisterUser
                        .withName("morpheus")
                        .andEmail("tracey.ramos@reqres.in")
                        .andPassword("serenity")
                        .andJob("leader")
        );
    }

    @Then("El debe obtener una cuenta virtual para poder ingresar cuando lo requiera")
    public void elDebeObtenerUnaCuentaVirtualParaPoderIngresarCuandoLoRequiera() {
        sayira.should(
                seeThat("the response code was", ResponseCode.was(), equalTo(200))
        );
    }
}
