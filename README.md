# Selenium Projects - Portafolio de Automatización

Este repositorio contiene **dos proyectos Java con Maven** orientados a pruebas automatizadas usando **Serenity BDD**, **Cucumber** y el patrón **Screenplay**.

## Contenido del repositorio

- [`serenitybddtraining`](./serenitybddtraining): proyecto de práctica/entrenamiento con escenarios de negocio, pruebas API y ejemplos de integración con base de datos.
- [`ui-api-serenity-automation`](./ui-api-serenity-automation): proyecto de portafolio con suites separadas para pruebas **UI** y **API** sobre Automation Exercise.

---

## 1) Proyecto `serenitybddtraining`

### ¿Qué es?
Es un laboratorio de aprendizaje de Serenity BDD donde se combinan:

- Escenarios BDD en español (login, registro, retiro, pago de facturas).
- Pruebas API con Screenplay REST.
- Ejemplos de preguntas (`Question`), tareas (`Task`), hechos (`Fact`) y uso de builders.
- Un ejemplo de conexión a base de datos con JPA/Hibernate desde una habilidad (`Ability`).

### Tecnologías principales

- Java 17
- Maven
- Serenity BDD 3.9.8
- Cucumber + JUnit (Jupiter y Vintage)
- Screenplay + Screenplay REST
- Hibernate + MySQL Connector

### Estructura clave

- **Runner Cucumber principal:** `src/test/java/CucumberTestSuite.java`
- **Features:** `src/test/resources/features`
- **Step definitions:** `src/main/java/stepdefinitions`
- **Hooks:** `src/test/java/hooks`
- **Pruebas JUnit 5 de ejemplo:** `src/test/java/SerenityInitialTest.java`

### Qué escenarios cubre

- Inicio de sesión con validaciones de contraseña.
- Registro de usuario.
- Retiro de dinero.
- Pago de servicios/facturas.
- Ejemplos adicionales de pruebas API (usuarios), facts y acceso a BD.

### Cómo ejecutarlo

```bash
cd serenitybddtraining
mvn clean verify
```

> Esto ejecuta pruebas y genera reportes de Serenity en la fase `verify`.

---

## 2) Proyecto `ui-api-serenity-automation`

### ¿Qué es?
Es un proyecto de automatización orientado a portafolio, con cobertura de:

- **Pruebas UI web** (flujos de usuario en Automation Exercise).
- **Pruebas API REST** (validación de endpoints públicos y reglas de negocio).

El proyecto separa sus ejecuciones en dos suites:

- `ApiTestSuite` para pruebas de API.
- `UiTestSuite` para pruebas de interfaz.

### Tecnologías principales

- Java 17
- Maven
- Serenity BDD 4.2.7
- Cucumber + JUnit 4
- Screenplay WebDriver y Screenplay REST

### Configuración importante

- Archivo de configuración: `serenity.conf`
- Browser por defecto: **Chrome** (con flags para ejecución estable en automatización).
- Base URL API: `https://automationexercise.com/api`

### Estructura clave

- **Runners:** `src/test/java/com.portfolio.automation/runners`
- **Features UI:** `src/test/resources/features/ui`
- **Features API:** `src/test/resources/features/api`
- **Step definitions:** `src/test/java/com.portfolio.automation/stepdefinitions`
- **Tasks/Questions/Interactions:** bajo `src/test/java/com.portfolio.automation`

### Cobertura funcional (resumen)

#### UI
Incluye casos como:

- Registro e inicio/cierre de sesión.
- Contact Us form.
- Verificación de productos y detalle de producto.
- Búsqueda de productos.
- Carrito (agregar, eliminar, validar productos).
- Suscripción en home y carrito.
- Flujo de compra/place order.
- Navegación por categorías y marcas.

#### API
Incluye casos como:

- Obtener listado de productos y marcas.
- Buscar productos por criterio.
- Verificar login por API.
- Crear, consultar, actualizar y eliminar cuenta de usuario.
- Validar endpoints no permitidos (métodos incorrectos).

### Cómo ejecutarlo

```bash
cd ui-api-serenity-automation
mvn clean verify
```

> El `maven-surefire-plugin` está configurado para ejecutar clases `*Suite.java`.

---

## Requisitos generales

Antes de ejecutar cualquiera de los dos proyectos:

1. Tener instalado **JDK 17**.
2. Tener instalado **Maven 3.8+**.
3. Tener **Google Chrome** y/o el driver correspondiente disponible para pruebas UI.
4. Tener acceso a internet para los endpoints externos usados en las pruebas.

---

## Recomendación de uso del repositorio

Si estás aprendiendo Serenity/Screenplay:

1. Empieza por `serenitybddtraining` para entender patrón, estructura y ejemplos.
2. Continúa con `ui-api-serenity-automation` para ver una implementación más completa de portafolio (UI + API) con suites separadas.
