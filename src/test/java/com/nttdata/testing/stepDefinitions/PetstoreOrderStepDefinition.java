package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.GetOrderById;
import com.nttdata.testing.tasks.DeleteOrderById;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetstoreOrderStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint de la Petstore API")
    public void elActorEstableceElEndpointDeLaPetstoreAPI(Actor actor) {
        actor.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("el actor envia una solicitud GET para la orden con id {string}")
    public void elActorEnviaUnaSolicitudGETParaLaOrdenConId(String id) {
        theActorInTheSpotlight().attemptsTo(GetOrderById.withId(id));
    }

    @When("el actor envia una solicitud DELETE para la orden con id {string}")
    public void elActorEnviaUnaSolicitudDELETEParaLaOrdenConId(String id) {
        theActorInTheSpotlight().attemptsTo(DeleteOrderById.withId(id));
    }

    @Then("el codigo de respuesta para la orden deberia ser {int}")
    public void elCodigoDeRespuestaParaLaOrdenDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(
                seeThat("El código de respuesta",
                        ResponseCode.getStatus(),
                        equalTo(responseCode))
        );
    }
}

