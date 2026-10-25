## Entorno de desarrollo y pruebas

Los experimentos se realizarán utilizando Java 25 y Maven en dos sistemas operativos.

| Componente | Windows | Linux |
|---|---|---|
| Sistema operativo | Windows 11 | Linux (kernel 5.14, EL9) |
| Arquitectura | AMD64 | AMD64 |
| Java | Oracle JDK 25 | Oracle JDK 25.0.4 |
| Maven | 3.9.5 | 3.9.11 |
| Codificación | UTF-8 | UTF-8 |
| Compatibilidad con JEP 483 | Sí | Sí |

**Nota 1:** para mantener la reproducibilidad, utilizaremos el mismo código fuente y la misma versión de Spring Boot en ambos sistemas operativos.

**Nota 2:** No son exactamente la misma versión, la idea es que al momento de hacer el benchmark comparativo tengamos la misma, pero, por ahora nos sirve para avanzar.

Las cachés AOT se generarán independientemente en cada entorno.

---
Puedes validar tus versiones así:

### Windows
JDK (debe ser el JDK no solo el JRE).

#### Java

``` powershell
%>  java -version
java version "25" 2025-09-16 LTS
Java(TM) SE Runtime Environment (build 25+37-LTS-3491)
Java HotSpot(TM) 64-Bit Server VM (build 25+37-LTS-3491, mixed mode, sharin
```

``` powershell
%>  javac --full-version   
javac full version "25+37-LTS-3491"
``` 

#### Maven
``` powershell

%> mvn --version                                                                                                                        
Apache Maven 3.9.5 (57804ffe001d7215b5e7bcb531cf83df38f93546)
Maven home: D:\opt\apache\apache-maven-3.9.5
Java version: 25, vendor: Oracle Corporation, runtime: D:\opt\Java\java-25
Default locale: es_MX, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
``` 

### Linux

#### Java
``` shell
~ »java -version                                                                                                                                                                         
java version "25.0.4" 2026-07-21 LTS
Java(TM) SE Runtime Environment (build 25.0.4+7-LTS-189)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.4+7-LTS-189, mixed mode, sharing)
```

``` shell
~ »  javac --full-version  

javac full version "25.0.4+7-LTS-189"
``` 

### Maven
``` shell
~ » mvn --version 
Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
Maven home: /home/rugi/.sdkman/candidates/maven/current
Java version: 25.0.4, vendor: Oracle Corporation, runtime: /home/rugi/.sdkman/candidates/java/25.0.4-oracle
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.14.0-596.el9.x86_64", arch: "amd64", family: "unix"
``` 
