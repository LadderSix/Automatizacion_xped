package xped.automation.StepsDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import xped.automation.Pages.RegistroPO;

public class RegistroSteps {

    RegistroPO registroPO = new RegistroPO();

    @And("Ingreso datos Formulario Parte 1 {},{},{},{}")
    public void ingresoDatosFormularioParteUno(String nombres, String appPaterno, String appMaterno, String rut) {
        registroPO.rellenarFormularioIdententificacion(nombres, appPaterno, appMaterno, rut);
    }

    @And("Ingreso datos Formulario Parte 2 {},{},{}")
    public void ingresoDatosFormularioParteDos(String alias, String clave, String repetirClave) {
        registroPO.rellenarFormularioIdententificacion2(alias, clave, repetirClave);
    }

    @And("Realizo carga de documentos")
    public void realizoCargaDeDocumentos(){
        registroPO.cargaDocumentos();
    }

    @And("Ingreso datos Representante {},{}")
    public void ingresoDatosRepresentante(String direccion, String ciudad){
        registroPO.rellenarFormularioRepresentante(direccion,ciudad);

    }

    @Then("Realizo registro exitoso de usuario")
    public void realizoRegistroExitosoDeUsuario(){

    }
}
