Feature: Inicio de sesion
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder iniciar sesion
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  Scenario Outline: Cliente intenta inciar sesion con contrasena no valida
    Given Julian es un cliente que quiere iniciar sesion para administrar sus productos
    When el envia la contrasena <contrasena>
    Then el debe ser informado que la contrasena no es valida
    Examples:
      | contrasena | descripcion     |
      | Pie22      | Longitud minima |
      | 25554885   | Solo numeros    |
      | hehasgdjka | Solo letras     |

