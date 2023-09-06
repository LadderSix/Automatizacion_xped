package xped.automation.Pages;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import xped.automation.util.PropertyReader;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//body/div[4]")
    private List<WebElement> header;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Cliente')]")
    private WebElement btnCliente;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Usuario')]")
    private WebElement btnUsuario;

    @FindBy(how = How.XPATH, using = "//input[@id='rolUsuarioAdmin']")
    private WebElement inputUsername;

    @FindBy(how = How.XPATH, using = "//input[@id='claveUsuarioAdmin']")
    private WebElement inputPassword;

    @FindBy(how = How.XPATH, using = "//a[@id='codigo_pagina_a']")
    private WebElement btnCodigoPagina;

    @FindBy(how = How.NAME, using = "ingresarCliente")
    private WebElement btnIngresarAdmin;

    @FindBy(how = How.XPATH, using = "//button[@name=\"registrarCliente\"]")
    private WebElement btnRegistrarPersona;

    public void ingresoCredenciales(String username, String password){
        sendKeys(inputUsername, username);
        sendKeys(inputPassword, password);
    }

    public void seleccionarOpcionUsuario(){
        waitForElementToBeClickable(btnUsuario,this.wait);
        actionClick(btnUsuario,this.driver);
    }

    public void btnIngresarAdmin(){
        click(btnIngresarAdmin);
    }
}
