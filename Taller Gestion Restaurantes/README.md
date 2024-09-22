# Sistema de Gestión de Restaurantes

## Descripción del Proyecto

Este proyecto es un sistema de gestión para restaurantes que permite llevar el control de los **platos** ofrecidos en el menú y la **gestión de mesas** ocupadas. El sistema permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) tanto para los platos del menú como para las mesas del restaurante. Las entidades están mapeadas a una base de datos MySQL utilizando **Spring Data JPA** y el proyecto sigue una arquitectura basada en capas con separación de responsabilidades.

## Herramientas Utilizadas

- **Java 17**: Versión del JDK utilizada.
- **Spring Boot**: Framework para desarrollar aplicaciones Java de forma rápida y sencilla.
- **Spring Data JPA**: Para la interacción con la base de datos y la gestión de las entidades.
- **MySQL**: Sistema gestor de bases de datos utilizado para persistir la información.
- **Maven**: Sistema de gestión de dependencias y construcción del proyecto.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE) recomendado.

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas con las siguientes carpetas principales:

- **controller**: Contiene los controladores que gestionan las peticiones HTTP.
- **model**: Contiene las entidades `Plato` y `Mesa` que representan las tablas en la base de datos.
- **repository**: Contiene las interfaces que extienden `JpaRepository`, permitiendo realizar las operaciones CRUD.
- **service**: Contiene la lógica del negocio y coordina las operaciones CRUD a través de los repositorios.

```
restaurant-management/
│
├── src/main/java/com/restaurant/management/
│   ├── controller/
│   │   ├── PlatoController.java
│   │   ├── MesaController.java
│   ├── model/
│   │   ├── Plato.java
│   │   ├── Mesa.java
│   ├── repository/
│   │   ├── PlatoRepository.java
│   │   ├── MesaRepository.java
│   ├── service/
│   │   ├── PlatoService.java
│   │   ├── MesaService.java
│   ├── RestaurantManagementApplication.java
│
├── src/main/resources/
│   ├── application.properties
│
├── pom.xml
└── README.md
```

## Configuración de la Base de Datos

1. **Crear la Base de Datos en MySQL**:
   Ejecuta el siguiente script SQL para crear la base de datos y las tablas necesarias:

   ```sql
   create database restaurant_management;
   use restaurant_management;

   create table Plato (
       id int auto_increment primary key,
       nombre varchar(100) not null ,
       precio decimal(10, 2) not null ,
       disponibilidad boolean not null 
   );

   create table Mesa (
       id int auto_increment primary key,
       numero_mesa int not null unique,
       ocupada boolean not null 
   );
   ```

2. **Configurar la Conexión a la Base de Datos**:
   En el archivo `src/main/resources/application.properties`, configura la conexión a MySQL con tus credenciales:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_management
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

## Dependencias Necesarias (pom.xml)

El archivo `pom.xml` debe incluir las siguientes dependencias para Spring Boot, JPA y MySQL:

```xml
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Driver de MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Dependencia para las pruebas -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Ejecución del Proyecto

1. **Compilar y Ejecutar**:
   Desde el directorio raíz del proyecto, ejecuta el siguiente comando para compilar y ejecutar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

2. **Acceder a la Aplicación**:
   El servidor estará disponible en `http://localhost:8080`. Desde aquí, puedes realizar las operaciones CRUD usando herramientas como **Postman** o tu navegador.

## Operaciones CRUD

1. **Crear un Plato o Mesa**:
   - **Plato**:
     - Método: `POST`
     - URL: `http://localhost:8080/api/platos`
     - Body (JSON):
       ```json
       {
           "nombre": "Ensalada César",
           "precio": 12.99,
           "disponibilidad": true
       }
       ```
   - **Mesa**:
     - Método: `POST`
     - URL: `http://localhost:8080/api/mesas`
     - Body (JSON):
       ```json
       {
           "numeroMesa": 5,
           "ocupada": false
       }
       ```

2. **Consultar Platos o Mesas**:
   - **Plato**:
     - Método: `GET`
     - URL: `http://localhost:8080/api/platos`
   - **Mesa**:
     - Método: `GET`
     - URL: `http://localhost:8080/api/mesas`

3. **Actualizar un Plato o Mesa**:
   - **Plato**:
     - Método: `PUT`
     - URL: `http://localhost:8080/api/platos/{id}`
     - Body (JSON):
       ```json
       {
           "nombre": "Ensalada Mixta",
           "precio": 10.99,
           "disponibilidad": true
       }
       ```
   - **Mesa**:
     - Método: `PUT`
     - URL: `http://localhost:8080/api/mesas/{id}`
     - Body (JSON):
       ```json
       {
           "numeroMesa": 5,
           "ocupada": true
       }
       ```

4. **Eliminar un Plato o Mesa**:
   - **Plato**:
     - Método: `DELETE`
     - URL: `http://localhost:8080/api/platos/{id}`
   - **Mesa**:
     - Método: `DELETE`
     - URL: `http://localhost:8080/api/mesas/{id}`

## Posibles Problemas y Soluciones

1. **Error de Conexión a MySQL**:
   - Asegúrate de que MySQL está ejecutándose y que las credenciales en `application.properties` son correctas.
   - Si el error persiste, verifica que has creado la base de datos `restaurant_management` correctamente.

2. **Error 404 al Hacer Peticiones**:
   - Asegúrate de que los endpoints en el controlador están bien definidos y que estás utilizando las rutas correctas.

3. **Hibernate No Crea las Tablas Automáticamente**:
   - Verifica que la propiedad `spring.jpa.hibernate.ddl-auto=update` esté configurada en `application.properties`. Esta propiedad asegura que Hibernate crea o actualiza las tablas al arrancar la aplicación.

4. **Problemas con Transacciones**:
   - Si enfrentas problemas con transacciones, asegúrate de que las operaciones CRUD están correctamente anotadas con `@Transactional` en los servicios.

## Informe del Proceso de Desarrollo

Durante el desarrollo del sistema de gestión de restaurantes, se decidio utilizar **Spring Boot** por su capacidad de acelerar el desarrollo de aplicaciones Java. Se utilizó **Spring Data JPA** para interactuar con la base de datos, lo que permitió evitar escribir consultas SQL manualmente y enfocarnos en la lógica de negocio.

La arquitectura del proyecto fue diseñada con separación de responsabilidades en mente, siguiendo las mejores prácticas de diseño en capas.

El principal desafío fue configurar correctamente la conexión a MySQL y manejar las transacciones. Además, algunos errores comunes incluyeron conflictos de versiones en las dependencias, lo que se resolvió ajustando las versiones en el archivo `pom.xml`.
