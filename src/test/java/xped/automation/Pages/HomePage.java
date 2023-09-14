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

    @FindBy(xpath = "//body/div[4]")
    private List<WebElement> header;

    @FindBy(xpath = "//a[contains(text(),'Cliente')]")
    private WebElement btnCliente;

    @FindBy(xpath = "//a[contains(text(),'Usuario')]")
    private WebElement btnUsuario;

    @FindBy(xpath = "//a[@id='codigo_pagina_a']")
    private WebElement btnCodigoPagina;


    public void seleccionarOpcionCliente(){
        MetodosGenericos.validarEstadoBotones(btnUsuario);
        MetodosGenericos.accionClick(btnUsuario);
    }
}
