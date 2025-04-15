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
