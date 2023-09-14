package xped.automation.StepsDefinitions;

import xped.automation.Pages.HomePage;
import xped.automation.Pages.ZonaClientePage;
import xped.automation.constants.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import xped.automation.constants.Navegador;
import xped.automation.driverConfig.DriverContext;

import static org.junit.Assert.assertEquals;


public class ZonaClienteSteps {
    ZonaClientePage zonaClientePage = new ZonaClientePage();

    @When("Ingreso al formulario de registro")
    public void ingresoAlFormularioDeRegistro(){
    }

    @And("Ingreso mis credenciales {} y {}")
    public void ingresoMisCredeciales(String username, String password){
        zonaClientePage.ingresoCredenciales(username, password);
    }

    @Then("Accedo con exito al ambiente")
    public void accedoConExitoAlAmbiente(){
        zonaClientePage.btnIngresarAdmin();
    }
}
