# Instituto API - EDA-111

Sistema de gestión estudiantil con Spring Boot.

## Requisitos
- Java 2555+


## Ejecutar el proyecto

```bash
mvn spring-boot:run
```

El servidor inicia en: `http://localhost:8080`

---

## Endpoints

### Parte 1: Calificaciones (Arreglo Unidimensional)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/notas/agregar?valor=85` | Agregar una calificación |
| GET | `/notas` | Mostrar calificaciones aprobadas (>=60) |
| GET | `/notas/todas` | Mostrar todas las calificaciones |
| GET | `/notas/promedio` | Calcular promedio |
| GET | `/notas/max` | Nota máxima |
| GET | `/notas/min` | Nota mínima |

### Parte 2: Aula (Arreglo Bidimensional 5x15)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/aula` | Mostrar matriz del aula |
| GET | `/aula/ocupados` | Cantidad de asientos ocupados |
| GET | `/aula/ocupar?fila=1&columna=2` | Ocupar un asiento |
| GET | `/aula/liberar?fila=1&columna=2` | Liberar un asiento |

**Nota:** filas 0-4, columnas 0-14

### Parte 3: Estudiantes (Lista Enlazada)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/estudiantes/agregar?nombre=Ana&puntaje=95&id=1` | Agregar estudiante |
| GET | `/estudiantes` | Mostrar todos los estudiantes |
| GET | `/estudiantes/ordenados` | Aprobados ordenados de mayor a menor |
| GET | `/estudiantes/buscar/Juan` | Buscar estudiante por nombre |

---

## Ejemplos rápidos

```bash
# Agregar notas
curl http://localhost:8080/notas/agregar?valor=85
curl http://localhost:8080/notas/agregar?valor=45
curl http://localhost:8080/notas/promedio

# Aula
curl http://localhost:8080/aula/ocupar?fila=0&columna=0
curl http://localhost:8080/aula

# Estudiantes
curl "http://localhost:8080/estudiantes/agregar?nombre=Ana&puntaje=95&id=1"
curl "http://localhost:8080/estudiantes/agregar?nombre=Luis&puntaje=55&id=2"
curl http://localhost:8080/estudiantes/ordenados
curl http://localhost:8080/estudiantes/buscar/Ana
```
