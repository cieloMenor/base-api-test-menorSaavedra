package com.nttdata.testing;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features", //donde estan los features
        glue = "com.nttdata.testing", //para buscar los stepdefinitions
        tags = "@PetstoreOrder")//ejecutar escenario
public class RunnerTest {

}
