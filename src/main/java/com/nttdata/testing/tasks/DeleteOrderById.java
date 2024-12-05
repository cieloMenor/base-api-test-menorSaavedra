package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteOrderById implements Task {

    private final String id;

    public DeleteOrderById(String id) {
        this.id = id;
    }

    public static Performable withId(String id) {
        return instrumented(DeleteOrderById.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/store/order/" + id)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .log().all()));
    }
}

