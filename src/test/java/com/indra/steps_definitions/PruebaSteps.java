package com.indra.steps_definitions;

import com.indra.actions.DatabaseConnection;
import com.indra.actions.ResourceEnlistment;
import com.indra.actions.UninstallCBSServices;
import com.indra.models.DataExcel;
import com.indra.pages.LoginPages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class PruebaSteps {
    @Managed
    WebDriver driver;

    UninstallCBSServices uninstallCBSServices = new UninstallCBSServices();
    DatabaseConnection databaseConnection = new DatabaseConnection();
    DataExcel dataExcel = new DataExcel();
    LoginPages loginPages = new LoginPages(driver);
    ResourceEnlistment enlistment = new ResourceEnlistment();

    @Given("^estoy probando$")
    public void estoyProbando() throws SQLException {
        enlistment.ejecutarTodo();
    }

    @When("^hago algo$")
    public void hagoAlgo() {

    }

    @Then("^deberia poder ver lo que pasa$")
    public void deberiaPoderVerLoQuePasa() {

    }

}


