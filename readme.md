# Prueba técnica valposystem -- Luis Céspedes

## Objetivo
En este caso consistiría en crear una aplicación web utilizando Framework Spring Boot y Angular. La aplicación debe proporcionar una API RESTful que permita realizar las operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad Personas con los siguientes campos:

-   id (Integer)
-   rutDni (String)
-   nombres (String)
-   apellidoPaterno (String)
-   apellidoMaterno (String)
-   nombreCalle (String)
-   numero (Integer)
-   restoDireccion (String)
-   correo (String)
-   fechaNacimiento (Date)

# Iniciar el servicio REST

Para ello se puede utilizar en la raíz del proyecto el comando de terminal `mvnw spring-boot:run`. En este caso, se dejó el puerto por defecto (8080).
# Base de datos
Para la realización de este proyecto se utilizó la base de datos en memoria "H2".
# Endpoints

La aplicación cuenta con un único endpoint con los distintos verbos, el cual es el siguiente: `localhost:8080/api/person`. A continuación, muestro ejemplos para hacer pruebas con algún programa que sea capaz de enviar solicitudes http, en mi caso, Postman.

## GET

    localhost:8080/api/person/
devuelve la lista de todos los empleados en la base de datos
![enter image description here](https://i.ibb.co/wMg2VHy/1.png)
## POST
```
localhost:8080/api/person/
```
body de ejemplo:
```
{
"rutDni":  "194746652",
"nombres":  "luis",
"apellidoPaterno":  "Céspedes",
"apellidoMaterno":  "sepulveda",
"nombreCalle":  "24 sur",
"numero":  1136,
"restoDireccion":  "villa francia",
"correo":  "lcespedes@gmail.com",
"fechaNacimiento":  "1990-01-01"
}
```
![enter image description here](https://i.ibb.co/hmmwDc9/2.png)
Devuelve código de estado 201 en caso de éxito, 409 en caso de que exista alguna persona con el mismo RUT, 400 en caso de que falten datos en la consulta (también se valida el RUT).

## GET Buscar por id
```
localhost:8080/api/person/{id}
```

consulta de ejemplo
```
localhost:8080/api/person/3
```
![enter image description here](https://i.ibb.co/z8Krrmz/3.png)
## DELETE
```
localhost:8080/api/person/{id}
```
![enter image description here](https://i.ibb.co/7JYXjsn/4.png)
Devuelve código de estado 200 en caso de eliminarlo exitosamente, 400 si no se envía el parámetro id, 403 si el id no corresponde a una persona registrada.
## PUT
```
localhost:8080/api/person/{id}
```
Body de ejemplo:
```
{
"rutDni":  "111111111",
"nombres":  "update",
"apellidoPaterno":  "update",
"apellidoMaterno":  "update",
"nombreCalle":  "update",
"numero":  123,
"restoDireccion":  "update",
"correo":  "update"
}
```
Cabe señalar que dicha consulta también puede cambiar en su totalidad o parcialmente un registro, por ejemplo, si no se desea cambiar la fecha de nacimiento simplemente no se envía.


# Notas

Cabe señalar que el front se levanta con el servidor web de la librería "spring-boot-starter-web". Dentro del proyecto, el front en Angular se copian los archivos de la build de esta misma en la carpeta static del proyecto de Spring Boot.

# Docker
El proyecto cuenta con un Dockerfile para una sencilla puesta en marcha. Dejo los comandos necesarios para crear la imagen.

    docker build -t valposystem .

## Correr contenedor

    docker run -d --name valposystem-container -p 8080:8080 valposystem 

> Reemplazar 8080 por los puertos deseados. Además, primero correr el comando "package de maven". , 

