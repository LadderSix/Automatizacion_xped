# Autor: Matias Rojas Arias
# Test para validar registro de cliente
Feature: Valida comportamiento de registros de clientes/usuario

  Background: Ingresar a Web XPED
    Given Ingreso a ambiente

  @test-02
  Scenario Outline: Registro de cliente exitoso

    When Ingreso al formulario de registro
    #And Ingreso datos Identificacion Cliente <nombres>,<appPaterno>,<appMaterno>,<rut>
    #And Realizo carga de documentos
    #And Ingreso datos Identificacion Cliente Parte 2 <alias>,<clave>,<repetirClave>
    And Ingreso datos Ubicacion Cliente <direccion>,<ciudad>
    Then Realizo registro exitoso de usuario

    Examples:
      | nombres            | appPaterno | appMaterno | rut       | alias | clave | repetirClave | direccion       | ciudad     | telefono1 | telefono2 | region | comuna | correo1 | correo2 | urlWeb |
      | matias juan carlos | rojas      | arias      | 175553878 | mati  | 1234  | 1234         | san adolfo 2913 | number:1023 |           |           |        |        |         |         |        |