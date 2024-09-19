# Restaurant Management System

Este proyecto es un sistema de gestión de restaurante que permite gestionar platos y mesas. El sistema implementa las operaciones CRUD para ambas entidades y utiliza Spring Boot, JPA y MySQL.

## Descripción del Proyecto

Este sistema permite a los administradores de un restaurante:
- Agregar, consultar, actualizar y eliminar **platos** en el menú.
- Administrar el estado de las **mesas** (disponibilidad) en el sistema.

El proyecto utiliza Spring Boot para la implementación de las operaciones CRUD y la conexión a la base de datos MySQL. Las entidades están mapeadas utilizando JPA y las transacciones son gestionadas automáticamente.

## Requisitos del Sistema

- **Java 17**
- **MySQL 8.0**
- **Maven 3.6+**
- **Postman** o cualquier cliente REST para probar la API.

### 2. Configurar la base de datos MySQL
Crea una base de datos en MySQL:

```bash
CREATE DATABASE restaurant_management;
```

Importa el archivo restaurant_management.sql para obtener la estructura de las tablas y datos iniciales:

```bash
mysql -u root -p restaurant_management < restaurant_management.sql
```

### 3. Configuración de application.properties
Configura los detalles de conexión a la base de datos MySQL en el archivo src/main/resources/application.properties:

properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_management
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### 4. Ejecutar la Aplicación
Una vez que hayas configurado la base de datos y actualizado el archivo application.properties, puedes ejecutar la aplicación:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en http://localhost:8080.

## Estructura del Proyecto
El proyecto sigue la estructura típica de Spring Boot:


```bash
restaurant-management/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/restaurant/management/
 │   │   │   ├── controller/        # Controladores REST
 │   │   │   ├── model/             # Entidades (Plato, Mesa)
 │   │   │   ├── repository/        # Repositorios JPA
 │   │   │   ├── service/           # Lógica de negocio
 │   │   │   └── RestaurantManagementApplication.java  # Clase principal
 │   │   └── resources/
 │   │       ├── application.properties  # Configuración de la base de datos
 │   │       └── static/  # Archivos estáticos (no utilizados en este proyecto)
 ├── pom.xml    # Configuración de Maven
 └── README.md  # Este archivo
 ```

## Operaciones CRUD
### Platos

- GET /api/platos: Obtener todos los platos.
- GET /api/platos/{id}: Obtener un plato por ID.
- POST /api/platos: Agregar un nuevo plato.
- PUT /api/platos/{id}: Actualizar un plato existente.
- DELETE /api/platos/{id}: Eliminar un plato.
### Mesas

- GET /api/mesas: Obtener todas las mesas.
- GET /api/mesas/{id}: Obtener una mesa por ID.
- POST /api/mesas: Agregar una nueva mesa.
- PUT /api/mesas/{id}: Actualizar una mesa existente.
- DELETE /api/mesas/{id}: Eliminar una mesa.

## Decisiones de Diseño

1. Uso de Spring Boot: Se eligió Spring Boot por su capacidad para crear aplicaciones web rápidamente con integración sencilla de JPA y manejo de transacciones.
2. JPA para el mapeo de entidades: Se utilizó JPA para mapear las entidades Plato y Mesa a tablas en la base de datos MySQL, lo que facilita la creación, lectura, actualización y eliminación de registros.
3. MySQL como base de datos: Se seleccionó MySQL como base de datos por su robustez y facilidad de integración con Spring Boot.

## Problemas Encontrados

1. Conexión a la Base de Datos:
Durante el desarrollo, se encontró un problema relacionado con la conexión a MySQL. Se resolvió actualizando la dependencia del conector de MySQL en el archivo pom.xml y configurando correctamente el application.properties.
2. Manejo de Transacciones:
Asegurarse de que cada operación CRUD esté correctamente gestionada en términos de transacciones fue esencial para evitar inconsistencias en la base de datos. Spring Boot maneja las transacciones de forma automática con JPA, lo cual simplificó el proceso.
Exportación de la Base de Datos
El archivo de exportación de la base de datos (restaurant_management.sql) está incluido en el proyecto. Contiene la estructura de las tablas y algunos datos iniciales para realizar pruebas.

## Conclusión
El proyecto implementa un sistema de gestión de restaurante simple que permite realizar operaciones CRUD sobre platos y mesas. Utilizando Spring Boot y JPA, se logró un sistema robusto y eficiente que conecta adecuadamente con una base de datos MySQL. Durante el desarrollo se tomaron decisiones clave de diseño que facilitaron el mantenimiento y escalabilidad del sistema.

Este sistema es una base sólida para expandir futuras funcionalidades como la gestión de órdenes o la integración con un sistema de facturación.