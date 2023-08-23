package xped.automation.StepsDefinitions;

import xped.automation.Pages.HomePagePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IniciarSesionSteps {


    HomePagePO homePagePO = new HomePagePO();

    @Given("Ingreso a ambiente")
    public void ingresoAAmbiente(){
        homePagePO.abrirWeb();
    }

    @When("Presiono en opcion usuario")
    public void presionoEnOpcionUsuario(){
        homePagePO.seleccionarOpcionUsuario();
    }

    @When("Ingreso al formulario de registro")
    public void ingresoAlFormularioDeRegistro(){
        homePagePO.btnRegistrarCliente();
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
