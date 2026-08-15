# JMX. La guía perdida. Acceso remoto. Re-edición 2026.
## Alcance.
El presente documento detalla cómo conectarse a un proceso java de manera remota vía JMX, para acceder a su listado de MBeans.

<blockquote>
**Nota:**

_Este documento se publicó en Febrero del 2018 en Oracle Technology Network, lo publico nuevamente para su mejor lectura pues la red OTN ha tenido cambios y algunos artículos dejaron de estar disponibles, incluyendo este._

_Puedes ver una versión en PDF del artículo original aquí:_
<a href="https://github.com/rugi/javaAldia/tree/main/ext/pdf">Respaldo de artículos de JMX en OTN.</a>
</blockquote>

## Requerimientos.
El presente documento asume que se tiene cierta experiencia construyendo aplicaciones usando el lenguaje de programación java, asume también
que el lector tiene experiencia como desarrollador de aplicaciones y conoce en ese nivel un sistema operativo, por ende, sabe ejecutar tareas a nivel
CLI.


En este documento, reutilizaremos el código de la parte 1 de esta serie, modificaremos un MBean y mostraremos como realizar una conexión
remota a un proceso java para administrarlo con JMX.

## Introducción.
En esta parte comenzaremos a acceder a procesos JMX de manera remota utilizando únicamente lo que nos proporciona el estándar.

Hasta el momento, hemos usado JConsole para acceder a un proceso local y así acceder al servidor de MBeans por default que ofrece dicho
proceso, en esta ocasión usaremos JConsole para acceder a un proceso remoto y utilizar así una de las principales bondades de JMX.

Volveremos a utilizar el ejemplo de la primera parte.
