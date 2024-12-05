package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.GetPassengers;
import com.nttdata.testing.tasks.GetPassengerById;
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

public class PassengerStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint para obtener los pasajeros")
    public void elActorEstableceElEndpointParaObtenerLosPasajeros(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el {actor} envia una solicitud GET a pasajeros")
    public void elActorEnviaUnaSolicitudGETAPasajeros(Actor actor) {
        actor.attemptsTo(GetPassengers.fromEndpoint("/passenger"));
    }

    @When("el actor envia una solicitud GET al pasajero con id {string}")
    public void elActorEnviaUnaSolicitudGETAlPasajeroConId(String id) {
        theActorInTheSpotlight().attemptsTo(GetPassengerById.withId(id));
    }

    @Then("el codigo de respuesta para el pasajero deberia ser {int}")
    public void elCodigoDeRespuestaParaElPasajeroDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(
                seeThat("El código de respuesta para el pasajero",
                        ResponseCode.getStatus(),
                        equalTo(responseCode))
        );
    }
}

