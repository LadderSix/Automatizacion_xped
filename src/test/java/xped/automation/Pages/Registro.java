package xped.automation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import xped.automation.driverConfig.DriverContext;
import xped.automation.util.MetodosGenericos;


import java.util.List;

public class Registro{
    private WebDriver driver;

    public Registro(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver, this);

    }

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
        MetodosGenericos.accionSenkeys(inputNombres,nombres);

    }

    public void ingresaAppPaterno(String appPaterno){
        MetodosGenericos.accionSenkeys(inputApellidoPaterno,appPaterno);
    }

    public void ingresaAppMaterno(String appMaterno){
        MetodosGenericos.accionSenkeys(inputApellidoMaterno,appMaterno);
    }

    public void ingresarRut(String rut){
        MetodosGenericos.accionSenkeys(inputRut,rut);

    }

    public void cargarAdjuntoCedulaIdentidad_y_DocumentoRut() {
        btnCargarCedula.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

        btnCargarRut.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

    }

    public void subirImagenRepresentante() {
        MetodosGenericos.accionClick(btnImgRepresentante);
        btnDocumentoUsuario.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

    }

    public void ingresarAlias(String alias) {
        MetodosGenericos.accionSenkeys(inputAlias,alias);

    }

    public void ingresarClaveSecreta(String clave) {
        MetodosGenericos.accionSenkeys(inputClaveSecreta,clave);
    }

    public void ingresarRepetirClaveSecreta(String repClave) {
        MetodosGenericos.accionSenkeys(inputRepetirClaveSecreta,repClave);
    }

    public void ingresarDireccion(String direccion) {
        MetodosGenericos.accionSenkeys(inputDireccion,direccion);
    }

    public void seleccionarCiudad(String ciudad) {
        MetodosGenericos.selectOptionByValue(listaCiudad,ciudad);


    }

}
