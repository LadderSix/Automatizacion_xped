package xped.automation.Pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import xped.automation.util.PropertyReader;

import java.util.List;

public class Registro extends BasePage {

    // Elementos Seccion Identificacion Cliente
    @FindBy(how = How.ID, using = "rolUsuario")
    private WebElement inputRut;

    @FindBy(how = How.ID, using = "nombre")
    private WebElement inputNombres;

    @FindBy(how = How.ID, using = "apellidoPaterno")
    private WebElement inputApellidoPaterno;

    @FindBy(how = How.ID, using = "apellidoMaterno")
    private WebElement inputApellidoMaterno;

    @FindBy(how = How.ID, using = "ClasePerfilCliente")
    private WebElement listaTipoCliente;

    @FindBy(how = How.ID, using = "alias")
    private WebElement inputAlias;

    @FindBy(how = How.ID, using = "claveUsuario")
    private WebElement inputClaveSecreta;

    @FindBy(how = How.ID, using = "claveUsuario2")
    private WebElement inputRepetirClaveSecreta;

    @FindBy(how = How.ID, using = "imagen-representante")
    private WebElement imgRepresentante;

    // Elementos Sección Cargar de archivos adjuntos

    @FindBy(how = How.ID, using = "documentoIdentidad")
    private WebElement btnCargarCedula;

    @FindBy(how = How.ID, using = "documentoRut")
    private WebElement btnCargarRut;

    @FindBy(how = How.ID, using = "imagen-representante-src")
    private WebElement btnImgRepresentante;

    @FindBy(how = How.ID, using = "documentoUsuario")
    private WebElement btnDocumentoUsuario;

    // Elementos Sección Ubicación cliente

    @FindBy(how = How.ID, using = "direccionUsuario")
    private WebElement inputDireccion;

    @FindBy(how = How.ID, using = "ciudadUsuario")
    private WebElement listaCiudad;

    @FindBy(how = How.XPATH, using = "//div[@class=\"field\"]//child::select[@id=\"ciudadUsuario\"]")
    private WebElement selectCiudad;

    @FindBy(how = How.ID, using = "telefonoUsuario")
    private WebElement inputTelefono1;

    @FindBy(how = How.ID, using = "telefonoOtroUsuario")
    private WebElement inputTelefono2;

    @FindBy(how = How.ID, using = "regionUsuario")
    private WebElement listaRegion;

    @FindBy(how = How.ID, using = "comunaUsuario")
    private WebElement listaComuna;

    @FindBy(how = How.ID, using = "correoUsuario")
    private WebElement inputCorreo;

    @FindBy(how = How.ID, using = "correoOtroUsuario")
    private WebElement inputCorreo2;

    @FindBy(how = How.NAME, using = "urlCliente")
    private WebElement inputURLSitio;


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

    public void subirImagenRepresentante() {
        actionClick(btnImgRepresentante, this.driver);
        btnDocumentoUsuario.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

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
        selectOptionByValue(selectCiudad,ciudad);

    }

}
