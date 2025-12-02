# 🔧 Guía de Instalación de Java y JavaFX para Windows

## ✅ Checklist de Instalación

- [ ] Instalar JDK 17 o superior
- [ ] Configurar variables de entorno JAVA_HOME
- [ ] Verificar instalación de Java
- [ ] Instalar Maven (opcional pero recomendado)
- [ ] Descargar JavaFX SDK (si no usas Maven)
- [ ] Ejecutar el proyecto

---

## 📥 Opción 1: Instalación Rápida con Maven (RECOMENDADO)

Esta es la forma más sencilla ya que Maven descargará JavaFX automáticamente.

### Paso 1: Instalar JDK

1. **Visita**: https://adoptium.net/
2. **Descarga**: OpenJDK 17 LTS para Windows x64
3. **Ejecuta** el instalador descargado (.msi)
4. Durante la instalación:
   - ✅ Marca "Set JAVA_HOME variable"
   - ✅ Marca "Add to PATH"
   - Click "Next" hasta finalizar

### Paso 2: Verificar Instalación de Java

Abre una **nueva terminal** (PowerShell o CMD) y ejecuta:

```bash
java -version
```

Deberías ver algo como:
```
openjdk version "17.0.x" 2023-xx-xx
OpenJDK Runtime Environment...
```

### Paso 3: Instalar Maven

**Opción A - Con Chocolatey (más fácil)**:

1. Abre PowerShell como Administrador
2. Instala Chocolatey si no lo tienes:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```
3. Instala Maven:
   ```powershell
   choco install maven -y
   ```

**Opción B - Manual**:

1. Descarga Maven desde: https://maven.apache.org/download.cgi
2. Descarga el archivo `apache-maven-x.x.x-bin.zip`
3. Extrae en `C:\Program Files\Apache\maven`
4. Agrega a PATH:
   - Busca "Variables de entorno" en Windows
   - Edita "Path" en Variables del sistema
   - Agrega: `C:\Program Files\Apache\maven\bin`

### Paso 4: Verificar Maven

Abre una nueva terminal:

```bash
mvn -version
```

### Paso 5: Ejecutar el Proyecto

En la carpeta del proyecto:

```bash
cd c:\Users\diazk\Desktop\finalproyect
mvn clean javafx:run
```

La primera vez descargará todas las dependencias (puede tardar unos minutos).

---

## 📥 Opción 2: Sin Maven (Manual con JavaFX SDK)

### Paso 1: Instalar JDK (igual que arriba)

Sigue el Paso 1 de la Opción 1.

### Paso 2: Descargar JavaFX SDK

1. Visita: https://gluonhq.com/products/javafx/
2. Descarga JavaFX Windows SDK (versión 20 o superior)
3. Extrae en: `C:\Program Files\Java\javafx-sdk-20`

### Paso 3: Configurar Variable de Entorno

1. Busca "Variables de entorno" en Windows
2. Crea una nueva variable del sistema:
   - **Nombre**: `PATH_TO_FX`
   - **Valor**: `C:\Program Files\Java\javafx-sdk-20\lib`

### Paso 4: Compilar Manualmente

Desde la carpeta del proyecto:

```bash
# Compilar
javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -d out src/main/java/com/sakila/*.java src/main/java/com/sakila/*/*.java

# Copiar recursos
xcopy src\main\resources out\resources /E /I

# Ejecutar
java --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -cp out com.sakila.SakilaApp
```

---

## 🎯 Opción 3: Usar un IDE (IntelliJ IDEA)

### IntelliJ IDEA Community (Gratis)

1. **Descarga**: https://www.jetbrains.com/idea/download/
2. **Instala** IntelliJ IDEA Community
3. **Abre el proyecto**:
   - File → Open → Selecciona `c:\Users\diazk\Desktop\finalproyect`
4. **IntelliJ detectará el pom.xml** y preguntará si quieres importar como proyecto Maven
   - Click "Load"
5. **Espera** a que descargue las dependencias (esquina inferior derecha)
6. **Ejecutar**:
   - Click derecho en `SakilaApp.java`
   - Run 'SakilaApp.main()'

---

## 🚀 Método Más Rápido (Lo que te recomiendo)

### Para empezar YA:

1. **Instala JDK 17**:
   - Ve a: https://adoptium.net/
   - Descarga e instala (marca las opciones de JAVA_HOME y PATH)

2. **Instala Maven con Chocolatey**:
   ```powershell
   # PowerShell como Administrador
   Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   choco install maven -y
   ```

3. **Ejecuta el proyecto**:
   ```bash
   cd c:\Users\diazk\Desktop\finalproyect
   mvn clean javafx:run
   ```

---

## ❓ Solución de Problemas

### Error: "JAVA_HOME not set"

**Solución**:
1. Busca "Variables de entorno"
2. Crea variable del sistema `JAVA_HOME`:
   - Valor: `C:\Program Files\Eclipse Adoptium\jdk-17.x.x-hotspot`
3. Reinicia la terminal

### Error: "mvn: command not found"

**Solución**:
- Cierra y abre una nueva terminal
- Verifica que Maven esté en PATH

### Error al ejecutar JavaFX

**Solución**:
```bash
# Asegúrate de usar el plugin de Maven
mvn clean javafx:run
```

---

## 📞 Siguiente Paso

Una vez instalado, ejecuta:

```bash
cd c:\Users\diazk\Desktop\finalproyect
mvn clean javafx:run
```

Y deberías ver la ventana de la aplicación Sakila! 🎬
