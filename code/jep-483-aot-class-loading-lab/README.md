# JEP 483 — Ahead-of-Time Class Loading & Linking

## 1. Objetivo

Este laboratorio tiene como objetivo explorar y evaluar **JEP 483 — Ahead-of-Time Class Loading & Linking**, una característica introducida en **Java 24** y disponible en Java 25 (LTS).

JEP 483 permite adelantar parte del trabajo de carga (*Class Loading*) y vinculación (*Class Linking*) de clases que normalmente realiza la JVM durante el arranque de una aplicación.

Mediante una aplicación sencilla desarrollada con **Spring Boot**, realizaremos experimentos para:

1. Comprender cómo funciona Ahead-of-Time Class Loading & Linking.
2. Comparar el arranque tradicional de la JVM con el arranque utilizando una caché AOT.
3. Distinguir las mejoras aportadas por Class Data Sharing (CDS) de las correspondientes a AOT Class Loading & Linking.
4. Medir el tiempo de arranque, el consumo de CPU y la memoria utilizada.
5. Reproducir los experimentos en Windows y Linux.
6. Analizar cómo estas optimizaciones podrían beneficiar a aplicaciones Java desplegadas en contenedores y Kubernetes.

**El propósito no es asumir que AOT siempre mejora el rendimiento, sino medir su comportamiento e identificar en qué condiciones ofrece ventajas.**

Referencia oficial: [OpenJDK — JEP 483](https://openjdk.org/jeps/483).

---

## 2. Entorno de desarrollo y pruebas

Los experimentos se realizarán utilizando Java 25 y Maven en dos sistemas operativos.

| Componente | Windows | Linux |
|---|---|---|
| Sistema operativo | Windows 11 | Linux (kernel 5.14, EL9) |
| Arquitectura | AMD64 | AMD64 |
| Java | Oracle JDK 25 | Oracle JDK 25.0.4 |
| Maven | 3.9.5 | 3.9.11 |
| Codificación | UTF-8 | UTF-8 |
| Compatibilidad con JEP 483 | Sí | Sí |

**Nota:** para mantener la reproducibilidad, utilizaremos el mismo código fuente y la misma versión de Spring Boot en ambos sistemas operativos.

Las cachés AOT se generarán independientemente en cada entorno.

---

## 3. Aplicación de prueba

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

Desde la raíz del proyecto:

```bash
mvn clean install
```

### Ejecución

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

## 4. Próximos experimentos

Una vez validado el funcionamiento de la aplicación, incorporaremos progresivamente los experimentos:

| Experimento | Objetivo | Estado |
|---|---|---|
| 00 — Entorno | Validar Java 25 y Maven en Windows y Linux | Completado |
| 01 — Baseline | Compilar y ejecutar la aplicación sin optimizaciones AOT | En progreso |
| 02 — AOT Cache | Generar y utilizar una caché AOT | Pendiente |
| 03 — CDS vs. AOT | Identificar el beneficio adicional de AOT Class Linking | Pendiente |
| 04 — Benchmark | Medir startup, CPU y memoria | Pendiente |
| 05 — Comparación | Analizar resultados de Windows y Linux | Pendiente |
| 06 — Kubernetes | Evaluar el impacto potencial sobre el tiempo hasta Ready | Pendiente |

Los resultados se documentarán conforme se completen los experimentos.

---

## 5. Consideraciones importantes

**Ahead-of-Time Class Loading & Linking no es lo mismo que compilación nativa.**

JEP 483 no convierte nuestra aplicación Java en un ejecutable nativo. La aplicación continúa ejecutándose sobre la JVM.

La optimización consiste en adelantar determinadas operaciones de carga y vinculación de clases y reutilizar ese trabajo durante arranques posteriores.

También debemos distinguir entre:

- **CDS (Class Data Sharing):** permite compartir y reutilizar metadatos de clases previamente procesados.
- **AOT Class Loading & Linking:** amplía el trabajo que puede realizarse anticipadamente, incluyendo determinadas operaciones de vinculación de clases.

Esta distinción será fundamental para interpretar correctamente los resultados de nuestros experimentos.

---

## Referencias

- [JEP 483 — Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483)
- [Oracle Java SE Support Roadmap](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)