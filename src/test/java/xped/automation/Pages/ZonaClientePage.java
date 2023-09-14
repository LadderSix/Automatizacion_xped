package xped.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import xped.automation.driverConfig.DriverContext;
import xped.automation.util.MetodosGenericos;

public class ZonaClientePage {
    private WebDriver driver;

    public ZonaClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//*[@id='rolUsuarioAdmin']")
    private WebElement inputUsername;

    @FindBy(xpath = "//*[@id='claveUsuarioAdmin']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@ng-click='ingresarCliente()']")
    private WebElement btnIngresarAdmin;

    @FindBy(xpath = "//a[@name='registrarCliente']")
    private WebElement btnRegistrarPersona;

    public void ingresoCredenciales(String username, String password){
        MetodosGenericos.accionSenkeys(inputUsername, username);
        MetodosGenericos.accionSenkeys(inputPassword,password);
    }

    public void btnIngresarAdmin(){
        MetodosGenericos.validarEstadoBotones(btnIngresarAdmin);
        MetodosGenericos.accionClick(btnIngresarAdmin);
    }
}
