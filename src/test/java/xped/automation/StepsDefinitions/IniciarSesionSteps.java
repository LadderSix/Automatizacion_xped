package xped.automation.StepsDefinitions;

import xped.automation.Pages.HomePage;
import xped.automation.constants.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import xped.automation.constants.Navegador;
import xped.automation.driverConfig.DriverContext;

import static org.junit.Assert.assertEquals;


public class IniciarSesionSteps {

    HomePage homePagePO = new HomePage();

    @Given("Ingreso a ambiente")
    public void ingresoAAmbiente(){
        DriverContext.setUp(Navegador.Chrome, Constant.URL_XPED);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(Constant.URL_XPED, url);
    }

    @When("Presiono en opcion usuario")
    public void presionoEnOpcionUsuario(){
        homePagePO.seleccionarOpcionUsuario();
    }

    @When("Ingreso al formulario de registro")
    public void ingresoAlFormularioDeRegistro(){
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
