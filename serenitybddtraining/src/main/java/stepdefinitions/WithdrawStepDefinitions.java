package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Account;
import models.Money;

public class WithdrawStepDefinitions {

    private Account myAccount;

    @Given("Sayira es un cliente con una cuenta de ahorros")
    public void sayira_es_un_cliente_con_una_cuenta_de_ahorros() {
        myAccount = new Account();
    }
    @Given("en su cuenta tiene un saldo disponible de {money}")
    public void en_su_cuenta_tiene_un_saldo_disponible_de(Money pesos) {
        myAccount.deposit(pesos);
        System.out.println("Saldo inicial: " + myAccount.getBalance());
    }
    @When("el intenta retirar su cuenta de {int}")
    public void el_intenta_retirar_su_cuenta_de(Integer int1) {
    }

    @Then("el deberia obtener {int}")
    public void el_deberia_obtener(Integer int1) {
    }

    @Then("el nuevo saldo de su cuenta deberia ser {int}")
    public void el_nuevo_saldo_de_su_cuenta_deberia_ser(Integer int1) {
    }
}
