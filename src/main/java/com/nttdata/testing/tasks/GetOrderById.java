package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetOrderById implements Task {

    private final String id;

    public GetOrderById(String id) {
        this.id = id;
    }

    public static Performable withId(String id) {
        return instrumented(GetOrderById.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/store/order/" + id)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .log().all()));
    }
}

