package com.nttdata.testing.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCode implements Question<Integer> {

    public static Question<Integer> getStatus() {
        return new ResponseCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
    //Permite recuperar el código de respuesta HTTP, como 200, 404, 500, etc., para validarlo en las pruebas.
}
