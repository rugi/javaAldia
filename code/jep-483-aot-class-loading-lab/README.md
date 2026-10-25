# JEP 483 — Ahead-of-Time Class Loading & Linking
---

Este material forma parte de la presentación: "".
Para: JCONF Guatemala 2026.
CD de Guatemala.

---

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

## 2. Próximos experimentos

Una vez validado el funcionamiento de la aplicación, incorporaremos progresivamente los experimentos:

| Experimento | Objetivo | Estado |
|---|---|---|
| <a href="docs/00-entorno.md">00 — Entorno</a> | Validar Java 25 y Maven en Windows y Linux | Completado |
| <a href="docs/01-baseline.md">01 — Baseline</a> | Compilar y ejecutar la aplicación sin una caché AOT específica. | Completado |
| <a href="docs/02-aot-cache.md">02 — AOT Cache</a> | Generar y utilizar una caché AOT | Completado |
| <a href="docs/03-cds-vs-aot.md">03 — CDS vs. AOT</a> | Identificar el beneficio adicional de AOT Class Linking | Pendiente |
| <a href="docs/04-benchmark.md">04 — Benchmark</a> | Medir startup, CPU y memoria | Pendiente |
| <a href="docs/05-comparacion.md">05 — Comparación</a> | Analizar resultados de Windows y Linux | Pendiente |
| <a href="docs/06-kubernetes.md">06 — Kubernetes</a> | Evaluar el impacto potencial sobre el tiempo hasta Ready | Pendiente |

Los resultados se documentarán conforme se completen los experimentos.

---

## 3. Consideraciones importantes

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
