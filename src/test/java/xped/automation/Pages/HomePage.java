package xped.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import xped.automation.driverConfig.DriverContext;
import xped.automation.util.MetodosGenericos;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(how = How.XPATH, using = "//body/div[4]")
    private List<WebElement> header;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Cliente')]")
    private WebElement btnCliente;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Usuario')]")
    private WebElement btnUsuario;

    @FindBy(how = How.XPATH, using = "//*[@id='rolUsuarioAdmin']")
    private WebElement inputUsername;

    @FindBy(how = How.XPATH, using = "//*[@id='claveUsuarioAdmin']")
    private WebElement inputPassword;

    @FindBy(how = How.XPATH, using = "//a[@id='codigo_pagina_a']")
    private WebElement btnCodigoPagina;

    @FindBy(how = How.XPATH, using = "//button[@ng-click='ingresarCliente()']")
    private WebElement btnIngresarAdmin;

    @FindBy(how = How.XPATH, using = "//a[@name='registrarCliente']")
    private WebElement btnRegistrarPersona;

    public void ingresoCredenciales(String username, String password){
        MetodosGenericos.accionSenkeys(inputUsername, username);
        MetodosGenericos.accionSenkeys(inputPassword,password);
    }

    public void seleccionarOpcionUsuario(){
        //MetodosGenericos.waitExplicitToBeClicleable(btnUsuario, 10);
        MetodosGenericos.accionClick(btnUsuario);
    }

    public void btnIngresarAdmin(){
        MetodosGenericos.validarEstadoBotones(btnIngresarAdmin);
        MetodosGenericos.accionClick(btnIngresarAdmin);
    }
}
