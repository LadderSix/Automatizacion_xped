# Autor: Matias Rojas Arias
# Test para validar inicio se sesión
Feature: Valida comportamiento de inicio de sesion

  Background: Ingresar a Web XPED
    Given Ingreso a ambiente

  @test-01
  Scenario Outline: Inicio de sesion exitoso
    When Presiono en opcion usuario
    And Ingreso mis credenciales <username> y <password>
    Then Accedo con exito al ambiente

    Examples:
    | username  | password |
    | 180450718 | 17101869 |