package xped.automation.Pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import xped.automation.util.PropertyReader;

import java.util.List;

public class Registro extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@id='rolUsuario']")
    private WebElement inputRut;

    @FindBy(how = How.XPATH, using = "//input[@id='nombre']")
    private WebElement inputNombres;

    @FindBy(how = How.XPATH, using = "//input[@id='apellidoPaterno']")
    private WebElement inputApellidoPaterno;

    @FindBy(how = How.XPATH, using = "//input[@id='apellidoMaterno']")
    private WebElement inputApellidoMaterno;

    @FindBy(how = How.XPATH, using = "//select[@name='idClasePerfilCliente']")
    private WebElement listaTipoCliente;

    @FindBy(how = How.XPATH, using = "//a[@id='loadFileXmlIdentidad']")
    private WebElement loadFileCedulaIdentidad;

    @FindBy(how = How.XPATH, using = "//input[@id='documentoIdentidad']")
    private WebElement btnCargarCedula;

    @FindBy(how = How.XPATH, using = "//a[@id='loadFileXmlRut']")
    private WebElement loadFileRut;

    @FindBy(how = How.XPATH, using = "//input[@id='documentoRut']")
    private WebElement btnCargarRut;

    @FindBy(how = How.XPATH, using = "//input[@id='alias']")
    private WebElement inputAlias;

    @FindBy(how = How.XPATH, using = "//input[@id='claveUsuario']")
    private WebElement inputClaveSecreta;

    @FindBy(how = How.XPATH, using = "//input[@id='claveUsuario2']")
    private WebElement inputRepetirClaveSecreta;

    @FindBy(how = How.XPATH, using = "//img[@id='imagen-representante']")
    private WebElement imgRepresentante;

    @FindBy(how = How.XPATH, using = "//input[@id='direccionUsuario']")
    private WebElement inputDireccion;

    @FindBy(how = How.ID, using = "ciudadUsuario")
    private WebElement listaCiudad;

    @FindBy(how = How.XPATH, using = "//input[@id='telefonoUsuario']")
    private WebElement inputTelefono1;

    @FindBy(how = How.XPATH, using = "//input[@id='telefonoOtroUsuario']")
    private WebElement inputTelefono2;

    @FindBy(how = How.XPATH, using = "//select[@id='regionUsuario']")
    private WebElement listaRegion;

    @FindBy(how = How.XPATH, using = "//select[@id='comunaUsuario']")
    private WebElement listaComuna;

    @FindBy(how = How.XPATH, using = "//input[@id='correoUsuario']")
    private WebElement inputCorreo;

    @FindBy(how = How.XPATH, using = "//input[@id='correoOtroUsuario']")
    private WebElement inputCorreo2;

    @FindBy(how = How.XPATH, using = "//input[@name='urlCliente']")
    private WebElement inputURLSitio;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Registrar')]")
    private WebElement btnRegistrarPersona;

    @FindBy(how = How.XPATH, using = "//img[@id='imagen-representante-src']")
    private WebElement btnImgRepresentante;

    @FindBy(how = How.XPATH, using = "//input[@id='documentoUsuario']")
    private WebElement btnDocumentoUsuario;


    public void ingresarNombres(String nombres){
        sendKeys(inputNombres,nombres);
        esperar(3);
    }

    public void ingresaAppPaterno(String appPaterno){
        sendKeys(inputApellidoPaterno,appPaterno);
        esperar(3);
    }

    public void ingresaAppMaterno(String appMaterno){
        sendKeys(inputApellidoMaterno,appMaterno);
        esperar(3);
    }

    public void ingresarRut(String rut){
        sendKeys(inputRut,rut);
        esperar(3);
    }

    public void cargarAdjuntoCedulaIdentidad_y_DocumentoRut() {
        btnCargarCedula.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");
        esperar(3);
        btnCargarRut.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");
        esperar(3);
    }

    public void ingresarAlias(String alias) {
        sendKeys(inputAlias,alias);
        esperar(3);
    }

    public void ingresarClaveSecreta(String clave) {
        sendKeys(inputClaveSecreta,clave);
        esperar(3);
    }

    public void ingresarRepetirClaveSecreta(String repClave) {
        sendKeys(inputRepetirClaveSecreta,repClave);
        esperar(3);
    }

    public void ingresarDireccion(String direccion) {
        sendKeys(inputDireccion,direccion);
        esperar(3);
    }

    public void seleccionarCiudad(String ciudad) {

        selectOptionByValue(listaCiudad,ciudad);
        esperar(3);
    }

}
