package xped.automation.StepsDefinitions;

import io.cucumber.java.en.Given;
import xped.automation.constants.Constant;
import xped.automation.constants.Navegador;
import xped.automation.driverConfig.DriverContext;

import static org.junit.Assert.assertEquals;

public class BackgroundSteps {

    @Given("Ingreso a ambiente")
    public void ingresoAAmbiente(){
        DriverContext.setUp(Navegador.Chrome, Constant.URL_XPED);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(Constant.URL_XPED, url);
    }
}
