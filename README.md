
# Sistema de Gestión de Talleres de Motocicletas (Backend)

El Sistema de Gestión de Talleres de Motocicletas es una aplicación backend diseñada para administrar usuarios, motocicletas y su mantenimiento dentro de un taller de reparación de motocicletas. Está construido utilizando Spring Boot 3.2.1, incorpora Spring Security 6.0.8 y utiliza Java 17. El sistema se conecta inicialmente a una base de datos MySQL. Los usuarios pueden iniciar sesión, y el proyecto permite crear, consultar y eliminar usuarios. Cada usuario está asociado con una o varias motocicletas, y cada motocicleta está vinculada a sus servicios correspondientes.


## Funcionalidades
#### Gestión de Usuarios:
 + Crear, leer y eliminar usuarios.
 + Roles de usuario: Tres roles distintos, cada uno con permisos específicos.
#### Gestión de Motocicletas:
 + Asociar usuarios con motocicletas.
 + Administrar detalles de las motocicletas (por ejemplo, marca, modelo, año).
#### Gestión de Servicios:
 + Vincular motocicletas con sus servicios correspondientes (mantenimiento, reparaciones, etc.).
## Requisitos Previos
 + **Java 17:** Asegúrate de tener Java 17 instalado.
 + **Base de Datos MySQL:** Configura una base de datos MySQL y ajusta las propiedades de la aplicación en consecuencia.
 + **Spring Boot:** Familiarízate con los conceptos de Spring Boot.
## Instalación y Configuración
    1. Clona este repositorio en tu máquina local.
    2. Configura el archivo application.properties con las credenciales de tu base de datos MySQL.
    3. Compila el proyecto utilizando Maven o la herramienta de compilación que prefieras.
    4. Ejecuta la aplicación.
## Uso
    1. Inicia la aplicacion desde el archivo main.
    2. Accede a la aplicación a través del puerto http://localhost:8080/swagger-ui/index.html
    3. Inicia sesión utilizando credenciales válidas.
    4. Crea, consulta o elimina usuarios y gestiona las motocicletas.
## Estructura REST
El Sistema de Gestión de Talleres de Motocicletas sigue una arquitectura RESTful y utiliza **Swagger** para documentar y visualizar sus API.. A continuación, algunos detalles adicionales:

#### Endpoints REST:
 + Los endpoints de la API siguen las convenciones REST, como /user, /bike, etc.
 + Utiliza los métodos HTTP estándar (GET, POST, DELETE) para interactuar con los recursos.
#### Formato de Respuestas:
 + Las respuestas de la API se envían en formato JSON. 
 + Los códigos de estado HTTP indican el resultado de la operación (por ejemplo, 200 OK, 404 Not Found).
#### Seguridad:
 + La autenticación y autorización se gestionan mediante Spring Security y tokens JWT.
