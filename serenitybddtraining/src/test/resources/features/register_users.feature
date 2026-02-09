Feature: Registro de usuarios
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  Scenario: Registro exitoso de usuario

    Given Sayira es un cliente que quiere poder administrar su productos bancarios
    When El envia la información requerida para el registro
    Then El debe obtener una cuenta virtual para poder ingresar cuando lo requiera