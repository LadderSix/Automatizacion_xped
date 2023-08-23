# Autor: Matias Rojas Arias
#
# Test para validar inicio se sesión
Feature: Valida comportamiento de registros de clientes/usuario

  @test
  Scenario Outline: Registro de cliente exitoso
    Given Ingreso a ambiente
    When Ingreso al formulario de registro
    And Ingreso datos Formulario Parte 1 <nombres>,<appPaterno>,<appMaterno>,<rut>
    And Realizo carga de documentos
    And Ingreso datos Formulario Parte 2 <alias>,<clave>,<repetirClave>
    And Ingreso datos Representante <direccion>,<ciudad>
    Then Realizo registro exitoso de usuario

    Examples:
      | nombres            | appPaterno | appMaterno | rut       | alias | clave | repetirClave | direccion       | ciudad    | telefono1 | telefono2 | region | comuna | correo1 | correo2 | urlWeb |
      | matias juan carlos | rojas      | arias      | 175553878 | mati  | 1234  | 1234         | san adolfo 2913 | Melipilla |           |           |        |        |         |         |        |