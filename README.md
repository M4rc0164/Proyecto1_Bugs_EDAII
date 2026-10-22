# Sistema de Gestiónn y Análisis de Reportes de Bugs
### Estructuras de Datos y Algoritmos II. FI UNAM

### Equipo 1.

**Integrantes:**
- Benavides Cantero Sian
- González Ayax 
- Rosas Flores Marco Saúl

Programa orientado a la administración, ordenamiento y recuperación de reportes de bugs en memoria principal.



### Restricciones
- **Persistencia en memoria:** No se emplean archivos en disco, bases de datos, excepciones ni hilos.
- **Implementación manual:** Algoritmos de ordenamiento interno y búsqueda programados manualmente.
- **Carga inicial:** Población automática de al menos 200 reportes antes de la interacción del usuario.

### Estructura del Proyecto
- `Reporte/`: Código fuente en LaTeX (`.tex`) y reporte técnico compilado (`.pdf`).
- `CodigoFuente/src/`:
  - `modelo/`: Entidad `Bug.java` con función Hash.
  - `datos/`: `AlmacenBugs.java` (colección lineal y tabla hash con resolución de colisiones) y `GeneradorBugs.java`.
  - `algoritmos/`: `ModuloOrdenamiento.java` (Counting Sort, QuickSort, HeapSort) y `ModuloBusqueda.java` (búsqueda binaria, lineal y por hash).
  - `interfaz/`: `Principal.java` (menú itneractivo con usuario).
- `Documentacion/`: Material de apoyo, diagramas y bitácoras de trabajo/planeación.