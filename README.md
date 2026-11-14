# Ferretería Industrial

API REST desarrollada con Java y Spring Boot para la gestión de productos de una ferretería industrial.

## 📋 Descripción

Este proyecto consiste en una aplicación web orientada a la gestión de productos de una ferretería industrial.

La aplicación permite realizar operaciones CRUD sobre los productos, facilitando su creación, consulta, actualización y eliminación.

El proyecto fue desarrollado como parte de mi proceso de aprendizaje y práctica con Java, Spring Boot, Spring Data JPA y bases de datos relacionales
siguiendo los pasos de un simulacro de prueba técnica
resuelto en el canal de youtube: https://www.youtube.com/@TodoCode


## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- HTML
- CSS
- Docker
- Git / GitHub

## 🏗️ Arquitectura

El proyecto utiliza una arquitectura basada en capas:

- **Controller:** recibe y gestiona las peticiones HTTP.
- **Service:** contiene la lógica de negocio.
- **Repository:** gestiona el acceso a la base de datos.
- **Model/Entity:** representa las entidades utilizadas por la aplicación.

## ⚙️ Configuración

Para ejecutar el proyecto localmente es necesario contar con:

- Java 21
- MySQL
- Maven

Configurar las siguientes variables de entorno:

```text
DB_URL=jdbc:mysql://localhost:3306/ferreteria
DB_USERNAME=root
DB_PASSWORD=