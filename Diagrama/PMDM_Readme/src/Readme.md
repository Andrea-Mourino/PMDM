
```mermaid
stateDiagram-v2

    [*] --> Inicio

    Inicio --> GenerandoSecuencia
    GenerandoSecuencia --> MostrandoSecuencia
    MostrandoSecuencia --> EsperandoInput

    EsperandoInput --> GenerandoSecuencia: Secuencia correcta
    EsperandoInput --> Fin: Secuencia incorrecta

    Fin --> [*]
