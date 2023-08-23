package xped.automation.Pages;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import xped.automation.util.PropertyReader;

import javax.lang.model.element.Element;
import java.util.List;

public class HomePagePO extends BasePage {

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

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Cliente')]")
    private WebElement btnIngresarAdmin;

    @FindBy(how = How.XPATH, using = "//a[@name=\"registrarCliente\"]")
    private WebElement btnRegistrarPersona;


    public void abrirWeb() {
        navigateToUrl(PropertyReader.getProperty("url"));
        esperar(3);
    }

    public void ingresoCredenciales(String username, String password){
        sendKeys(inputUsername, username);
        esperar(1);
        sendKeys(inputPassword, password);
        esperar(1);
        System.out.println("credenciales ok");
    }

    public void seleccionarOpcionUsuario(){
        String response = "Cliente";
        try {
            for(WebElement a : header){
                System.out.println(a.getText());
                if(a.toString().equals(response)){
                    actionClick(a,this.driver);

                    //JavascriptExecutor jsEx = (JavascriptExecutor) driver;
                    //jsEx.executeScript("arguments[0].click",btnCliente);
                    //waitForElementToBeClickable(btnCliente, this.wait);
                    //click(btnCliente);
                    break;
                }
            }
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
            System.out.println("Elemento interceptado: " + e.getMessage());
        }
    }

    public void btnIngresarAdmin(){
        try{
            if(isDisplayedAndClickable(btnIngresarAdmin)){
                click(btnIngresarAdmin);
                System.out.println("click ok");
            }

        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
            System.out.println("Elemento interceptado: " + e.getMessage());
        }
    }

    public void btnRegistrarCliente(){
        navigateToUrl(PropertyReader.getProperty("urlRegistro"));
    }
}
