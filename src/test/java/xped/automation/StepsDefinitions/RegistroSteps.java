package xped.automation.StepsDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import xped.automation.Pages.Registro;

public class RegistroSteps {

    Registro registroPO = new Registro();

    @And("Ingreso datos Formulario Parte 1 {},{},{},{}")
    public void ingresoDatosFormularioParteUno(String nombres, String appPaterno, String appMaterno, String rut) {
        registroPO.ingresarNombres(nombres);
        registroPO.ingresaAppPaterno(appPaterno);
        registroPO.ingresaAppMaterno(appMaterno);
        registroPO.ingresarRut(rut);
    }

    @And("Ingreso datos Formulario Parte 2 {},{},{}")
    public void ingresoDatosFormularioParteDos(String alias, String clave, String repetirClave) {
        registroPO.ingresarAlias(alias);
        registroPO.ingresarClaveSecreta(clave);
        registroPO.ingresarRepetirClaveSecreta(repetirClave);
    }

    @And("Realizo carga de documentos")
    public void realizoCargaDeDocumentos(){
        registroPO.cargarAdjuntoCedulaIdentidad_y_DocumentoRut();
    }

    @And("Ingreso datos Representante {},{}")
    public void ingresoDatosRepresentante(String direccion, String ciudad){
        registroPO.ingresarDireccion(direccion);
        registroPO.seleccionarCiudad(ciudad);
    }

    @Then("Realizo registro exitoso de usuario")
    public void realizoRegistroExitosoDeUsuario(){

    }
}
