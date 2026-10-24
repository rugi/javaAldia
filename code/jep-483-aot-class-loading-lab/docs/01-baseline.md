## Baseline

Para realizar los experimentos utilizaremos una aplicación REST desarrollada con **Spring Boot 3.5.4** y Java 25.

La aplicación expondrá un único endpoint:

```http
GET /products
```

Este endpoint devolverá una lista de productos almacenados en memoria.

No utilizaremos bases de datos ni servicios externos, con el propósito de evitar que factores como conexiones de red, inicialización de pools o latencia de infraestructura interfieran en las mediciones.

### ¿Por qué Spring Boot?

Aunque nuestra aplicación tendrá pocas clases propias, Spring Boot necesita cargar e inicializar numerosas clases del framework, del servidor HTTP y de otras bibliotecas durante su arranque.

Esto proporciona un escenario práctico para observar el comportamiento de la JVM y evaluar las optimizaciones de JEP 483.

### Con esto probamos el siguiente código

La aplicación estará organizada en cuatro componentes principales:

| Clase | Responsabilidad |
|---|---|
| `AotApplication` | Iniciar la aplicación Spring Boot |
| `Product` | Representar un producto |
| `ProductService` | Proporcionar los productos almacenados en memoria |
| `ProductController` | Exponer el endpoint REST `/products` |

El código fuente se encuentra en:

```text
src/main/java/dev/rugi/aot/
```

### Compilación

Desde la raíz de esta carpeta (tanto en linux como en windows):

```bash
mvn clean install
```

### Ejecución

Tanto en linux como en windows:
```bash
java -jar target/jep-483-lab-1.0.0.jar
```

### Verificación

Con la aplicación ejecutándose:

```bash
curl http://localhost:8383/products
```

En Windows PowerShell:

```powershell
curl.exe http://localhost:8383/products
```

Respuesta esperada:

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 15000.00
  },
  {
    "id": 2,
    "name": "Monitor",
    "price": 4500.00
  },
  {
    "id": 3,
    "name": "Keyboard",
    "price": 1200.00
  }
]
```

---
