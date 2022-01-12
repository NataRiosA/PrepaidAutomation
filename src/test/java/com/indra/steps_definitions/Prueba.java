package com.indra.steps_definitions;

import com.indra.actions.UninstallCBSServices;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Prueba {
    @Managed
    WebDriver driver;
    UninstallCBSServices uninstallCBSServices = new UninstallCBSServices(driver);
    @Given("^estoy probando$")
    public void estoyProbando() {
        uninstallCBSServices.performLineCleaning();

    }

    @When("^hago algo$")
    public void hagoAlgo() {

    }

    @Then("^deberia poder ver lo que pasa$")
    public void deberiaPoderVerLoQuePasa() {

    }

}
