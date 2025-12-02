# 🎬 Sistema de Gestión Sakila - JavaFX

Sistema CRUD moderno para la gestión de la base de datos Sakila, desarrollado con JavaFX siguiendo el patrón arquitectónico MVC (Model-View-Controller).

## 📋 Descripción

Aplicación de escritorio para gestionar películas de la base de datos Sakila con una interfaz gráfica moderna, intuitiva y visualmente atractiva. El sistema implementa operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar) con diseño Material Design.

## 🎨 Características

- ✨ **Interfaz Moderna**: Diseño con Material Design, gradientes y animaciones suaves
- 🎯 **Navegación por Pestañas**: Acceso rápido a módulos (Clientes, Películas, Inventario, Reportes)
- 📊 **Tabla Dinámica**: Visualización de películas con búsqueda y selección
- ✏️ **Formulario CRUD**: Panel lateral para crear, actualizar y eliminar películas
- 🎨 **Paleta de Colores Vibrante**: Tema oscuro profesional con acentos de color
- ✅ **Validación de Datos**: Validación en tiempo real de formularios

## 🏗️ Estructura del Proyecto

```
finalproyect/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sakila/
│   │   │           ├── SakilaApp.java              # Aplicación principal
│   │   │           ├── controller/
│   │   │           │   └── FilmController.java     # Controlador JavaFX
│   │   │           └── model/
│   │   │               └── Film.java               # Modelo de datos
│   │   └── resources/
│   │       ├── fxml/
│   │       │   └── FilmView.fxml                  # Vista FXML
│   │       └── css/
│   │           └── styles.css                     # Estilos CSS modernos
└── README.md
```

## 🔧 Tecnologías

- **Java**: JDK 11 o superior
- **JavaFX**: Framework de interfaz gráfica
- **FXML**: Descripción declarativa de la UI
- **CSS**: Estilos personalizados con Material Design
- **Patrón MVC**: Arquitectura de software

## 📦 Requisitos Previos

1. **JDK 11 o superior** instalado
2. **JavaFX SDK** (si no está incluido en tu JDK)
3. IDE recomendado: IntelliJ IDEA, Eclipse o NetBeans

## 🚀 Compilación y Ejecución

### Opción 1: Con Maven (Recomendado)

Si tienes Maven configurado, crea un archivo `pom.xml` con las dependencias de JavaFX:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>20.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>20.0.1</version>
    </dependency>
</dependencies>
```

Luego ejecuta:

```bash
mvn clean javafx:run
```

### Opción 2: Compilación Manual

1. **Descargar JavaFX SDK** desde [openjfx.io](https://openjfx.io/)

2. **Compilar** (ajusta las rutas según tu sistema):

```bash
javac --module-path "ruta/a/javafx-sdk/lib" \
      --add-modules javafx.controls,javafx.fxml \
      -d out \
      src/main/java/com/sakila/**/*.java
```

3. **Ejecutar**:

```bash
java --module-path "ruta/a/javafx-sdk/lib" \
     --add-modules javafx.controls,javafx.fxml \
     -cp out com.sakila.SakilaApp
```

### Opción 3: Desde el IDE

**IntelliJ IDEA:**
1. File → Project Structure → Libraries → Add JavaFX SDK
2. Run → Edit Configurations → Add VM Options:
   ```
   --module-path "ruta/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
   ```
3. Run `SakilaApp.java`

**Eclipse:**
1. Build Path → Add External JARs → Agregar todos los JARs de JavaFX
2. Run Configurations → Arguments → VM arguments:
   ```
   --module-path "ruta/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
   ```

## 📚 Funcionalidades CRUD

### ➕ Crear Película
1. Click en botón **"Nuevo"**
2. Completar formulario (Título, Descripción, Año, Idioma, Clasificación)
3. Click en **"Guardar"**

### ✏️ Actualizar Película
1. Seleccionar película de la tabla
2. Modificar datos en el formulario
3. Click en **"Actualizar"**

### 🗑️ Eliminar Película
1. Seleccionar película de la tabla
2. Click en **"Eliminar"**
3. Confirmar acción

## 🎨 Paleta de Colores

| Color | Hex | Uso |
|-------|-----|-----|
| Índigo Primario | `#6366F1` | Botón Guardar, elementos activos |
| Verde Esmeralda | `#10B981` | Botón Nuevo, acciones positivas |
| Ámbar | `#F59E0B` | Botón Actualizar, advertencias |
| Rojo | `#EF4444` | Botón Eliminar, acciones destructivas |
| Fondo Oscuro | `#0F172A` | Fondo principal |
| Superficie | `#1E293B` | Tarjetas y paneles |

## 🔮 Próximos Pasos

- [ ] Integrar con base de datos Sakila real (MySQL/PostgreSQL)
- [ ] Implementar capa de persistencia con ORM (JPA/Hibernate)
- [ ] Añadir funcionalidad de búsqueda y filtrado
- [ ] Implementar módulos de Clientes, Inventario y Reportes
- [ ] Agregar paginación para grandes volúmenes de datos
- [ ] Implementar autenticación de usuarios
- [ ] Exportar reportes a PDF/Excel

## 📝 Notas Importantes

- **Datos de Ejemplo**: Actualmente usa datos ficticios en memoria
- **TODO**: Buscar comentarios `TODO` en `FilmController.java` para puntos de integración con BD
- **Idioma**: Toda la interfaz y comentarios están en español
- **Validaciones**: Incluye validación de campos obligatorios y formato de año

## 🤝 Contribuciones

Para extender este proyecto:

1. **Modelos adicionales**: Crear clases en `model/` para Cliente, Inventario, etc.
2. **Controladores**: Añadir controladores en `controller/` para cada módulo
3. **Vistas FXML**: Diseñar vistas en `resources/fxml/`
4. **Persistencia**: Implementar DAOs o Repositories con conexión a Sakila DB

## 📄 Licencia

Proyecto educativo para sistemas de gestión de bases de datos.

---

**Desarrollado con ❤️ usando JavaFX y Material Design**
