package xped.automation.StepsDefinitions;

import io.cucumber.java.en.When;
import xped.automation.Pages.HomePage;

public class HomePageSteps {

    HomePage homePagePO = new HomePage();

    @When("Presiono en opcion usuario")
    public void presionoEnOpcionUsuario(){
        homePagePO.seleccionarOpcionCliente();
    }
}
