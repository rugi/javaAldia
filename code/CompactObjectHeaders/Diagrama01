``` mermaid
flowchart TB
    subgraph Stack["Stack (referencias)"]
        R1["Ref -> Obj (Java 21)"]
        R2["Ref -> Obj (Java 25)"]
    end

    subgraph Heap21["Heap - Java 21 Object Layout (~16 bytes header + fields)"]
        subgraph Obj1
            H21["Header (~16B)\nMark Word + Klass Ptr"]:::header
            F21["Fields\n(int id, long saldo, ...)"]:::fields
        end
    end

    subgraph Heap25["Heap - Java 25 Object Layout (~8 bytes header + fields)"]
        subgraph Obj2
            H25["Compact Header (~8B)\nMark Word + Compressed Klass Ptr"]:::header
            F25["Fields\n(int id, long saldo, ...)"]:::fields
        end
    end

    R1 --> H21
    R2 --> H25

    classDef header fill:#ffd,stroke:#333
    classDef fields fill:#dfd,stroke:#333
``` 
