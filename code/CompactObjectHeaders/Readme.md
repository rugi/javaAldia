# Readme 
Este ejemplo se usó en el newsletter en su edición sobre Compact Object Headers.

Puedes ver el artículo completo aquí:


El ejemplo se usa para mostrar el ahorro de memoria que tiene a partir de java 25, 
con el JSR-, el tamaño de los Headers de cada objeto se ha reducido, y eso hace que se requiera menos memoria para cada uno de ellos.

Para validar, asegurate de que tienes al menos java 25 y una version anterior, en este ejemplo mostramos resultados de ejecutar el código con java 17 y java 25.

## Paso 1. Compilar y ejecutar con versión anterior a java 25 (en este ejemplo se usa java 17)
### Windows
''' console
D:\tmp\header> D:\opt\Java\jdk-17\bin\java -version
java version "17.0.14" 2025-01-21 LTS
Java(TM) SE Runtime Environment (build 17.0.14+8-LTS-191)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.14+8-LTS-191, mixed mode, sharing)

D:\tmp\header> D:\opt\Java\jdk-17\bin\javac .\CompactHeaderDemo.java

D:\tmp\header> D:\opt\Java\jdk-17\bin\java CompactHeaderDemo
Memoria usada: 281 MB
'''
### Linux

## Paso 2. Compilar y ejecutar con java 25.
### Windows

### Linux

## Paso 3. Comparar resultados.
