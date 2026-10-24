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

Debemos ver que todo esté OK.

```bash
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.853 s
[INFO] Finished at: 2026-10-24T21:50:26Z
[INFO] ------------------------------------------------------------------------
``` 

### Ejecución

Tanto en linux como en windows:

```bash
java -jar target/jep-483-lab-1.0.0.jar
```
Debemos ver que, la app está lista para recibir peticiones, igualmente, podremos ver el tiempo de inicio, esto es importante para lo que queremos validar.

```bash
 » java -jar target/jep-483-lab-1.0.0.jar                                                                         

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.4)

2026-10-24T21:52:33.560Z  INFO 349438 --- [jep-483-lab] [           main] dev.rugi.aot.AotApplication              : Starting AotApplication v1.0.0 using Java 25.0.4 with PID 349438 (/home/rugi/code/github/javaAlDia/javaAldia/code/jep-483-aot-class-loading-lab/target/jep-483-lab-1.0.0.jar started by rugi in /home/rugi/code/github/javaAlDia/javaAldia/code/jep-483-aot-class-loading-lab)
2026-10-24T21:52:33.565Z  INFO 349438 --- [jep-483-lab] [           main] dev.rugi.aot.AotApplication              : No active profile set, falling back to 1 default profile: "default"
2026-10-24T21:52:35.406Z  INFO 349438 --- [jep-483-lab] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8383 (http)
2026-10-24T21:52:35.444Z  INFO 349438 --- [jep-483-lab] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-10-24T21:52:35.445Z  INFO 349438 --- [jep-483-lab] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.43]
2026-10-24T21:52:35.504Z  INFO 349438 --- [jep-483-lab] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-10-24T21:52:35.506Z  INFO 349438 --- [jep-483-lab] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1841 ms
2026-10-24T21:52:36.235Z  INFO 349438 --- [jep-483-lab] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8383 (http) with context path '/'
2026-10-24T21:52:36.262Z  INFO 349438 --- [jep-483-lab] [           main] dev.rugi.aot.AotApplication              : Started AotApplication in 3.49 seconds (process running for 4.299)
```

Estas son las 2 lineas que debemos buscar:

```bash
2026-10-24T21:52:36.235Z  INFO 349438 --- [jep-483-lab] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8383 (http) with context path '/'
2026-10-24T21:52:36.262Z  INFO 349438 --- [jep-483-lab] [           main] dev.rugi.aot.AotApplication              : Started AotApplication in 3.49 seconds (process running for 4.299)
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
