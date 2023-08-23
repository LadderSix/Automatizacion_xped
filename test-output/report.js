$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("iniciarSesion.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Autor: Matias Rojas Arias"
    },
    {
      "line": 2,
      "value": "#"
    },
    {
      "line": 3,
      "value": "# Test para validar inicio se sesión"
    }
  ],
  "line": 4,
  "name": "Valida comportamiento de inicio de sesion",
  "description": "",
  "id": "valida-comportamiento-de-inicio-de-sesion",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Inicio de sesion exitoso",
  "description": "",
  "id": "valida-comportamiento-de-inicio-de-sesion;inicio-de-sesion-exitoso",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Ingreso a ambiente",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Presiono en opcion usuario",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Ingreso mis credenciales \u003cusername\u003e y \u003cpassword\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "valida-comportamiento-de-inicio-de-sesion;inicio-de-sesion-exitoso;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 12,
      "id": "valida-comportamiento-de-inicio-de-sesion;inicio-de-sesion-exitoso;;1"
    },
    {
      "cells": [
        "18.045.071-8",
        "17101869"
      ],
      "line": 13,
      "id": "valida-comportamiento-de-inicio-de-sesion;inicio-de-sesion-exitoso;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Inicio de sesion exitoso",
  "description": "",
  "id": "valida-comportamiento-de-inicio-de-sesion;inicio-de-sesion-exitoso;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Ingreso a ambiente",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Presiono en opcion usuario",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Ingreso mis credenciales 18.045.071-8 y 17101869",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});