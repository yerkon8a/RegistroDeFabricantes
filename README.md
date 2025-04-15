Registro de Fabricantes APIs REST con Spring Boot

CRUD acciones:

        ELiminar Marca , Ingresar Marca, Modificar Marca,  Eliminar Marca
        
        ELiminar Producto , Ingresar Producto, Modificar Producto,  Eliminar Producto

Se utiliza: 

Spring Boot

Lombox

Hibernate

JPA

Postman

Postgres

Tomcat

Patrones de diseño DTO y DAO

Desacoplamiento de capas.

---------------------------------------------------------------------------

Operaciones en Postman:

1. GET para buscar por ID:
Método: GET
URL: http://localhost:8080/api/maker/find/1

2. GET para listar todos (/api/maker/findall):
Método: GET
URL: http://localhost:8080/api/maker/findall

3. POST para crear nuevo fabricante (/api/maker/save):
Método: POST
URL: http://localhost:8080/api/maker/save
Headers:
Content-Type: application/json
Body (raw, JSON):
JSON
{ "nombre": "IBM"}

4. PUT Actualizar Maker (/api/maker/update/{id}):
Método: PUT
URL: http://localhost:8080/api/maker/update/1 
Headers:
Content-Type: application/json
Body (raw, JSON):
JSON
{"nombre": "IBM-US"}

5. DELETE Eliminar Maker (/api/maker/delete/{id}):
Método: DELETE
URL: http://localhost:8080/api/maker/delete/1
--------------------------------------------------------------------
6. GET para buscar por ID (/api/product/find/{id}):
Método: GET
URL: http://localhost:8080/api/product/find/1

7. GET para listar todos (/api/product/findAll):
Método: GET
URL: http://localhost:8080/api/product/findAll

8. POST para crear nuevo producto (/api/product/save):
Método: POST
URL: http://localhost:8080/api/product/save
Headers:
Content-Type: application/json
Body (raw, JSON):
JSON
{
    "nombre": "Mouse",
    "precio": 100.00,
    "maker": {
        "id": 1,
        "nombre": "HP"
    }
}

9. PUT Actualizar producto (/api/product/update/{id}):
Método: PUT
URL: http://localhost:8080/api/product/update/1
Headers:
Content-Type: application/json
Body (raw, JSON):
JSON
{
    "nombre": "Mouse",
    "precio": 120.00,
    "maker": {
        "id": 2,
        "nombre": "HP-2100"
    }
}


10. DELETE Eliminar producto (/api/product/delete/{id}):
Método: DELETE
URL: http://localhost:8080/api/product/delete/1
------------------------------------------------------------------------------
SQL para generar tablas e insert:

-- Creación de la tabla fabricante
CREATE TABLE fabricante (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL
);

-- Creación de la tabla producto
CREATE TABLE producto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    id_fabricante INTEGER NOT NULL,
    FOREIGN KEY (id_fabricante) REFERENCES fabricante(id)
);

-- Inserciones en la tabla fabricante
INSERT INTO fabricante (nombre) VALUES ('Fabricante A');
INSERT INTO fabricante (nombre) VALUES ('Fabricante B');
INSERT INTO fabricante (nombre) VALUES ('Fabricante C');

-- Inserciones en la tabla producto
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 1', 100.50, 1);
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 2', 250.75, 1);
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 3', 50.00, 2);
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 4', 120.20, 2);
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 5', 300.00, 3);
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Producto 6', 80.99, 3);
