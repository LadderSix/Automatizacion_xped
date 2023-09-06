# Autor: Matias Rojas Arias
# Test para validar inicio se sesión
Feature: Valida comportamiento de inicio de sesion

  @test
  Scenario Outline: Inicio de sesion exitoso
    Given Ingreso a ambiente
    When Presiono en opcion usuario
    And Ingreso mis credenciales <username> y <password>
    Then Accedo con exito al ambiente

    Examples:
    | username  | password |
    | 180450718 | 17101869 |