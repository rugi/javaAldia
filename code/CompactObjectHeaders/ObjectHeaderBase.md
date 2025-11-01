# Partes de un Object Header

``` mermaid
graph TD
    A["🧱 Object Header"] --> B["Mark Word"]
    A --> C["Class Pointer (Klass Pointer)"]

    subgraph B1["Mark Word"]
        B2["🔹 HashCode"]
        B3["🔹 Estado de bloqueo (Lock State)"]
        B4["🔹 Información del GC"]
        B5["🔹 Edad del objeto"]
        B6["🔹 Bits de biased locking"]
    end

    subgraph C1["Class Pointer"]
        C2["➡️ Referencia a la metadata de la clase"]
    end

    style A fill:#1f2937,stroke:#111,color:#fff,fontWeight:bold
    style B1 fill:#3b82f6,stroke:#1e40af,color:#fff
    style C1 fill:#10b981,stroke:#064e3b,color:#fff
``` 
