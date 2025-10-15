# Readme 
Este ejemplo se usó en el newsletter en su edición sobre Compact Object Headers.

Puedes ver el artículo completo aquí:


El ejemplo se usa para mostrar el ahorro de memoria que tiene a partir de java 25, 
con el JSR-, el tamaño de los Headers de cada objeto se ha reducido, y eso hace que se requiera menos memoria para cada uno de ellos.

Para validar, asegurate de que tienes al menos java 25 y una version anterior, en este ejemplo mostramos resultados de ejecutar el código con java 17 y java 25.

## Windows
### Paso 0. Coloca el archivo en una carpeta.
Esa carpeta será tu carpeta de trabajo, al no tener paquete la clase, solo requerimos estar en esa carpeta para compilar y ejecutar.

Para efectos ilustrativos, asumimos que pusimos el archivo en la carpeta:
``` console
D:\tmp\header>
``` 

### Compilar y ejecutar con versión anterior a java 25 (en este ejemplo se usa java 17)

#### Validamos version anterior a java 25
``` console
D:\tmp\header> java -version
java version "17.0.14" 2025-01-21 LTS
Java(TM) SE Runtime Environment (build 17.0.14+8-LTS-191)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.14+8-LTS-191, mixed mode, sharing)
```

#### Compilamos
``` console
D:\tmp\header> javac .\CompactHeaderDemo.java
```
#### Ejecutamos
``` console
D:\tmp\header> java CompactHeaderDemo
Memoria usada: 281 MB
```

### Compilamos y ejecutamos con java 25.

#### Validamos version anterior a java 25
``` console
D:\tmp\header> java -version
java version "25" 2025-09-16 LTS
Java(TM) SE Runtime Environment (build 25+37-LTS-3491)
Java HotSpot(TM) 64-Bit Server VM (build 25+37-LTS-3491, mixed mode, sharing)
```

#### Borramos los class existentes
``` console
D:\tmp\header> rm *.class
```
#### Compilamos
``` console
D:\tmp\header> javac .\CompactHeaderDemo.java
```

#### Ejecutamos
``` console
D:\tmp\header> java CompactHeaderDemo
Memoria usada: 268 MB
```


### Linux
#### Validamos version anterior a java 25
``` console
[rugi@bigoze tmp]$ java -version
java version "17.0.5" 2022-10-18 LTS
Java(TM) SE Runtime Environment (build 17.0.5+9-LTS-191)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.5+9-LTS-191, mixed mode, sharing)

[rugi@bigoze tmp]$ javac CompactHeaderDemo.java 

[rugi@bigoze tmp]$ java CompactHeaderDemo 
Memoria usada: 273 MB
``` 
### Compilamos y ejecutamos con java 25.

#### Validamos version anterior a java 25
``` console

```
