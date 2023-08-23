package xped.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.runtime.model.WebDriverValue;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import xped.automation.util.PropertyReader;

import java.util.List;

public class RegistroPO extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@id='rolUsuario']")
    private WebElement inputRut;

    @FindBy(how = How.XPATH, using = "//input[@id='nombre']")
    private WebElement inputNombres;

    @FindBy(how = How.XPATH, using = "//input[@id='apellidoPaterno']")
    private WebElement inputApellidoPaterno;

    @FindBy(how = How.XPATH, using = "//input[@id='apellidoMaterno']")
    private WebElement inputApellidoMaterno;

    @FindBy(how = How.XPATH, using = "//select[@name='idClasePerfilCliente']")
    private List<WebElement> listaTipoCliente;

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

    @FindBy(how = How.XPATH, using = "//select[@id='ciudadUsuario']")
    private WebElement listaCiudad;

    @FindBy(how = How.XPATH, using = "//input[@id='telefonoUsuario']")
    private WebElement inputTelefono1;

    @FindBy(how = How.XPATH, using = "//input[@id='telefonoOtroUsuario']")
    private WebElement inputTelefono2;

    @FindBy(how = How.XPATH, using = "//select[@id='regionUsuario']")
    private List<WebElement> listaRegion;

    @FindBy(how = How.XPATH, using = "//select[@id='comunaUsuario']")
    private List<WebElement> listaComuna;

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


    public void rellenarFormularioIdententificacion(String nombres, String appPaterno, String appMaterno,
                                             String rut){
        try{
            if(this.driver.getCurrentUrl().equals(PropertyReader.getProperty("urlRegistro"))){
                sendKeys(inputNombres,nombres);
                esperar(1);
                sendKeys(inputApellidoPaterno,appPaterno);
                esperar(1);
                sendKeys(inputApellidoMaterno,appMaterno);
                esperar(1);
                sendKeys(inputRut,rut);
                System.out.println("nombres, apellido y rut cargados!");
            }

        }catch (ElementNotInteractableException eni){
            eni.printStackTrace();
            System.out.println("No puede interactuar con el elemento: " + eni.getMessage());
        }
    }

    public void cargaDocumentos(){
        try {
            esperar(5);
            btnCargarCedula.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

            esperar(5);
            btnCargarRut.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\foto.jpg");

            esperar(5);
            btnImgRepresentante.click();

            if(isDisplayedAndClickable(btnDocumentoUsuario)){
                btnDocumentoUsuario.sendKeys("C:\\Users\\matias.rojas\\OneDrive - TSOFT\\Documentos\\Automaton_TestUploadsFiles\\fotoPerfil.jpg");
            }
            System.out.println("Documentos cargados!");

        } catch (ElementNotInteractableException eni) {
            eni.printStackTrace();
            System.out.println("No puede interactuar con el elemento: " + eni.getMessage());
        }

    }

    public void rellenarFormularioIdententificacion2(String alias, String clave, String repetirClave){
        try{
            if(this.driver.getCurrentUrl().equals(PropertyReader.getProperty("urlRegistro"))){
                sendKeys(inputAlias,alias);
                esperar(1);
                sendKeys(inputClaveSecreta,clave);
                esperar(1);
                sendKeys(inputRepetirClaveSecreta,repetirClave);
                System.out.println("alias, clave cargados!");
            }

        }catch (ElementNotInteractableException eni){
            eni.printStackTrace();
            System.out.println("No puede interactuar con el elemento: " + eni.getMessage());
        }

    }

    public void rellenarFormularioRepresentante(String direccion, String ciudad){
        try{
            if(this.driver.getCurrentUrl().equals(PropertyReader.getProperty("urlRegistro"))){
                sendKeys(inputDireccion, direccion);

                esperar(15);

                Select select = new Select(listaCiudad);
                select.selectByVisibleText(ciudad);

                esperar(2);

                /*sendKeys(inputTelefono1, telefono1);
                esperar(1);
                sendKeys(inputTelefono2, telefono2);
                esperar(1);

                for(WebElement opcion : listaRegion){
                    System.out.println(opcion.getText());

                    if(opcion.getText().equals(region)){
                        opcion.click();
                        break;
                    }

                }
                esperar(2);

                for(WebElement opcion : listaComuna){
                    System.out.println(opcion.getText());

                    if(opcion.getText().equals(comuna)){
                        opcion.click();
                        break;
                    }

                }
                esperar(2);

                sendKeys(inputCorreo, correo1);
                esperar(1);
                sendKeys(inputCorreo2, correo2);
                esperar(1);
                sendKeys(inputURLSitio, urlWeb);*/

            }

        }catch (ElementNotInteractableException eni){
            eni.printStackTrace();
            System.out.println("No puede interactuar con el elemento: " + eni.getMessage());
        }
    }

}
