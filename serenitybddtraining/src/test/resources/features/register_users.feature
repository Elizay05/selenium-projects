Feature: Registro de usuarios
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  @conbeforehook
  Scenario: Registro exitoso de usuario

    Given Sayira es un cliente que quiere poder administrar su productos bancarios
    When El envia la información requerida para el registro
    Then El debe obtener una cuenta virtual para poder ingresar cuando lo requiera

  Scenario: Registro exitoso de usuario 2

    Given Sayira es un cliente que quiere poder administrar su productos bancarios
    When El envia la información requerida para el registro
    Then El debe obtener una cuenta virtual para poder ingresar cuando lo requiera