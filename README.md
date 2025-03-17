# 🎓 Gestión ULP

**GestionUlp** es una aplicación de escritorio desarrollada en **Java** para la gestión de alumnos, materias e inscripciones en una universidad. Facilita la administración de estudiantes, asignaturas y calificaciones mediante una interfaz gráfica intuitiva.

---

## 📌 Características

- 📋 **Gestión de alumnos**: Alta, edición y eliminación de registros.
- 📚 **Administración de materias**: Agregar, modificar y eliminar asignaturas.
- 📝 **Inscripciones**: Matriculación de alumnos en materias con validaciones.
- 🎓 **Consulta de calificaciones**: Visualización de notas por materia y alumno.
- 🖥️ **Interfaz gráfica**: Aplicación construida con **Java Swing** para una experiencia interactiva.
- 🔗 **Conexión a base de datos**: Integración con un sistema de almacenamiento para persistencia de datos.

---

## 🛠️ Tecnologías utilizadas

- **Java**: Desarrollo de lógica y estructura de la aplicación.
- **Swing**: Creación de la interfaz gráfica.
- **JDBC**: Conexión con base de datos.
- **NetBeans**: Entorno de desarrollo utilizado.

---

## 📁 Estructura del Proyecto

```bash
GestionUlp/
│── src/
│   ├── Data/                    # Clases de acceso a datos (DAO)
│   │   ├── AlumnoData.java
│   │   ├── MateriaData.java
│   │   ├── InscripcionData.java
│   │   ├── Conexion.java
│   ├── VistaGeneral/            # Interfaz principal
│   │   ├── MenuPrincipal.java
│   ├── VistaAlumnos/            # Gestión de alumnos
│   │   ├── vistaAgregarAlumno.java
│   │   ├── editarAlumno.java
│   │   ├── eliminarAlumno.java
│   ├── VistaMaterias/           # Gestión de materias
│   │   ├── agregarMateria.java
│   │   ├── editarMateria.java
│   │   ├── eliminarMateria.java
│   ├── VistaInscripciones/      # Inscripciones de alumnos en materias
│   │   ├── inscripciones.java
│   ├── VistaAlumnoYMateria/     # Consultas de alumnos y materias
│   │   ├── Calificaciones.java
│   │   ├── VerMateriasDeUnAlumno.java
│   │   ├── VerAlumnosDeUnaMateria.java
│   ├── pruebaappulp/            # Clases de modelo
│   │   ├── Alumno.java
│   │   ├── Materia.java
│   │   ├── Inscripcion.java
│   │   ├── PruebaAppUlp.java
│── build.xml                    # Configuración de compilación con Apache Ant
│── manifest.mf                   # Archivo de manifiesto
│── dist/                         # Carpeta de distribución
│── nbproject/                    # Configuración de NetBeans
```

---

## 🚀 Instalación y Uso

### 1️⃣ Descargar el repositorio

```sh
git clone https://github.com/Fermin2049/GestionUlp.git
```

### 2️⃣ Abrir en NetBeans

- Importar el proyecto en **NetBeans**.

### 3️⃣ Configurar la base de datos

- Modificar la clase `Conexion.java` con los datos de acceso a la base de datos.

### 4️⃣ Ejecutar la aplicación

- Compilar y ejecutar desde **NetBeans** o generar un `.jar` para ejecución independiente.

---

![image](https://github.com/user-attachments/assets/f62b9191-4a6f-4b85-84f6-c5e96dcda23f)


## 📜 Licencia

Este proyecto es de uso libre bajo la licencia **MIT**.

