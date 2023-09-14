package xped.automation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import xped.automation.driverConfig.DriverContext;
import xped.automation.util.MetodosGenericos;

public class RegistroPage {

    private WebDriver driver;

    public RegistroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver, this);

    }

    // Elementos Seccion Identificacion Cliente
    @FindBy(id = "rolUsuario")
    private WebElement inputRut;

    @FindBy(id = "nombre")
    private WebElement inputNombres;

    @FindBy(id = "apellidoPaterno")
    private WebElement inputApellidoPaterno;

    @FindBy(id = "apellidoMaterno")
    private WebElement inputApellidoMaterno;

    @FindBy(id = "ClasePerfilCliente")
    private WebElement listaTipoCliente;

    @FindBy(id = "alias")
    private WebElement inputAlias;

    @FindBy(id = "claveUsuario")
    private WebElement inputClaveSecreta;

    @FindBy(id = "claveUsuario2")
    private WebElement inputRepetirClaveSecreta;

    @FindBy(id = "imagen-representante")
    private WebElement imgRepresentante;

    // Elementos Sección Cargar de archivos adjuntos

    @FindBy(id = "documentoIdentidad")
    private WebElement btnCargarCedula;

    @FindBy(id = "documentoRut")
    private WebElement btnCargarRut;

    @FindBy(id = "imagen-representante-src")
    private WebElement btnImgRepresentante;

    @FindBy(id = "documentoUsuario")
    private WebElement btnDocumentoUsuario;

    // Elementos Sección Ubicación cliente

    @FindBy(id = "direccionUsuario")
    private WebElement inputDireccion;

    @FindBy(id = "ciudadUsuario")
    private WebElement listaCiudad;

    @FindBy(xpath = "//div[@class=\"field\"]//child::select[@id=\"ciudadUsuario\"]")
    private WebElement selectCiudad;

    @FindBy(id = "telefonoUsuario")
    private WebElement inputTelefono1;

    @FindBy(id = "telefonoOtroUsuario")
    private WebElement inputTelefono2;

    @FindBy(id = "regionUsuario")
    private WebElement listaRegion;

    @FindBy(id = "comunaUsuario")
    private WebElement listaComuna;

    @FindBy(id = "correoUsuario")
    private WebElement inputCorreo;

    @FindBy(id = "correoOtroUsuario")
    private WebElement inputCorreo2;

    @FindBy(name = "urlCliente")
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
