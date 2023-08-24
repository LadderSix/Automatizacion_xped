package xped.automation.StepsDefinitions;

import xped.automation.Pages.BasePage;
import xped.automation.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import xped.automation.util.PropertyReader;

public class IniciarSesionSteps {


    HomePage homePagePO = new HomePage();

    @Given("Ingreso a ambiente")
    public void ingresoAAmbiente(){
        homePagePO.navigateToUrl(PropertyReader.getProperty("url"));
    }

    @When("Presiono en opcion usuario")
    public void presionoEnOpcionUsuario(){
        homePagePO.seleccionarOpcionUsuario();
    }

    @When("Ingreso al formulario de registro")
    public void ingresoAlFormularioDeRegistro(){
        homePagePO.navigateToUrl(PropertyReader.getProperty("urlRegistro"));
    }

    @And("Ingreso mis credenciales {} y {}")
    public void ingresoMisCredeciales(String username, String password){
        homePagePO.ingresoCredenciales(username, password);
    }

    @Then("Accedo con exito al ambiente")
    public void accedoConExitoAlAmbiente(){
        homePagePO.btnIngresarAdmin();
    }
}
