
# Proyecto: WaterRun

Este poryecto es una implementacion de un juego de resolucion de acertijos en Java.
___________________________________________
|   Detalle           |   Información     |
|---------------------|-------------------|
| **Autor**           |     SDM           |
| **Fecha de Inicio** |   v1 18/11/2024   |
| **Última versión**  |   v8 28/04/2025   |
¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯

## Contenido del Proyecto

- **Java (`WaterRun.java`)**: Codigo base.
- **Java (`Pregunta.java`)**: Clase para las preguntas.
- **Java (`GestionPreguntas.java`)**: Clase para gestionar las preguntas.
- **Java (`Personajes.java`)**: Superclase de tipos de personajes.
- **Java (`Policia.java`)**: Subclase de Personaje con atributos y metodos diferentes a escapista.
- **Java (`Escapista.java`)**: Subclase de Personaje con atributos y metodos diferentes a policia.
- **Java (`Jugador.java`)**: Clase que se encargará de registrar los datos del jugador.
- **Java (`Partida.java`)**: Clase que se encargará de registrar los datos de la partida.
- **Java (`CaracterIncorrectoException.java`)**:
- **Java (`MasCaracteresPermitidosException.java`)**:
- **Java (`MismaConstrasenaException.java`)**:
- **Java (`MismoNombreException.java`)**:
- **Java (`NumeroFueraDeRangoException.java`)**:
- **Java (`GestionHistorial.java`)**:
- **Java (`GestionPerfil.java`)**:
- **Java (`GestionMusica.java`)**:
- **Java (`GestionUsuario.java`)**:
- **Java (`Log.java`)**:
- **Java (`PartidasTxt.java`)**:       
- **Java (`GestionSalir.java`)**:
- **Java (`UtilidadesJuego.java`)**:
- **Java (`GuardarPartidas.java`)**:            
- **Java (`ReproductorMusica.java`)**:            
- **Java (`Utilidades.java`)**: Clase encargada de gestionar todas las validaciones de respuestas.
- **Java (`VarGenYConst.java`)**: Clase encargada de gestionar todas las variables genéricas y constantes.
- **Java (`GestionJugar.java`)**: Clase con el codigo general. Se encarga de gestionar los menús.
- **Java (`GestionAspecto.java`)**: Clase que se encarga de gestionar la gestión de colores.
- **Java (`Jugar.java`)**: Clase que gestiona la opción de Jugar. 
- **Java (`JugarFaMe.java`)**: Clase que gestiona la partida en dificultad fácil y media. 
- **Java (`JugarDificil.java`)**: Clase que gestiona  la partida en dificultad difícil. 
- **Jar (`WaterRun.jar`)**: Versión ejecutable del juego.
- **Manifest (`Manifest.txt`)**: Archivo para crear el WaterRun.Jar.
- **SQL (`WaterRun.sql`)**:
- **Partidas (`Partidas.txt`)**:


## Estructura del Proyecto

```
WATERRUNVX_SAMUELDIAZMARTOS/
    WaterRun.jar    # Archivo ejecutable del juego (.jar)
    README.md       # Este archivo
    .vscode/        # Configuraciones para Visual Studio Code
        settings.json
    bin/            # Carpeta con los .Class de los archivos
        WaterRun.class
        clases/         #Carpeta con las clases
            Pregunta.class
            Personajes.class
            GestionPreguntas.class
            Policia.class
            Escapista.class   
            Jugador.class
            Partida.class
        excepciones/
            CaracterIncorrectoException.class
            MasCaracteresPermitidosException.class
            MismaConstrasenaException.class
            MismoNombreException.class
            NumeroFueraDeRangoException.class
        utilidades/     #Carpeta de Utilidades
            Utilidades.class
            VarGenYConst.class
            ReproductorMusica.class
        gestionjuego/   #Carpeta de gestión del juego
            juego/      #Carpeta del juego
                GuardarPartidas.class
                UtilidadesJuego.class
                Jugar.class
                JugarFaMe.class
                JugarDificil.class
            salir/
                GestionSalir.class
                PartidasTxt.class
            GestionHistorial.class
            GestionMusica.class
            GestionPerfil.class
            GestionUsuario.class
            GestionAspecto.class
            GestionJugar.class
        log/
            Log.class
        Manifest.txt
    lib/            # Carpeta que contiene las librerias externas 
        mysql-connector-j-9.2.0.jar
    logs/           # Carpeta que contiene los logs con los errores al ejecutar
    src/            # Carpeta con el código fuente
        WaterRun.java
        clases/         #Carpeta con las clases
            Pregunta.java
            Personajes.java
            GestionPreguntas.java
            Policia.java
            Escapista.java   
            Jugador.java
            Partida.java
        excepciones/
            CaracterIncorrectoException.java
            MasCaracteresPermitidosException.java
            MismaConstrasenaException.java
            MismoNombreException.java
            NumeroFueraDeRangoException.java
        utilidades/     #Carpeta de Utilidades
            Utilidades.java
            VarGenYConst.java
            ReproductorMusica.java
        gestionjuego/   #Carpeta de gestión del juego
            juego/      #Carpeta del juego
                GuardarPartidas.java
                UtilidadesJuego.java
                Jugar.java
                JugarFaMe.java
                JugarDificil.java
            salir/
                GestionSalir.java
                PartidasTxt.java
            GestionHistorial.java
            GestionMusica.java
            GestionPerfil.java
            GestionUsuario.java
            GestionAspecto.java
            GestionJugar.java
        log/
            Log.java
        Manifest.txt
    Partidas.txt
    WaterRun.jar
    WaterRun.sql
```

## Requisitos del Sistema

- **Java Developmen Kit (JDK)**: version 21 o superior.
- Entorno de desarrollo integrado (IDE) recomendado: Visual Studio Code.

## Instrucciones de Ejecución
1. Abre mySqlWorkBench y conectate a un usuario.
2. Abre el script.sql llamado WaterRun.sql que se encuentra en la raíz del proyecto.
3. Ejecuta WaterRun.sql dentro del WorkBench.
4. Abre el proyecto en **Visual Studio Code**
5. En el archivo ConexionBD, cambia al usuario usado en la base de datos y la contraseña. 
6. Asegúrate de que JDK 21 esté correctamente configurado.
7. Ve a la carpeta `src/` y selecciona el archivo que deseas ejecutar
(`WaterRun.java` o `WaterRun.jar`)
8. En caso de elegir `WaterRun.java` complia y ejecuta el programa.
   En caso de elegir `WaterRun.jar` selecciona en la parte superior izquierda
   `Terminal` y ejecuta el siguietne comando: `java -jar WaterRun.jar`
9. En caso de que al seleccionar un color no se muestre en el cmd y se
   muestren unos caracteres, escriba este comando en la terminal y reiniciela.
    `reg add HKEY_CURRENT_USER\Console /v VirtualTerminalLevel /t REG_DWORD /d 1`


## Funcionalidades Principales
         
- **GestionUsuario**: Se encarga de validar al usuario al inicio de la sesión.
- **bienvenida**: Se encarga de mostrar el mensaje de bienvenida.
- **menu1**: Se encarga de mostrar el menú principal del juego donde nos dejará elegir entre: `Jugar`, `Dificultad`, `Aspecto`, `Historial`, `Opciones de  Música`,`Opciones de Perfil` o `Salir`.
- **Jugar**: Se encarga de validar si el jugador quiere jugar o no y mandarlo a `JugarFaMe` o `JugarDificil` en función de la dificultad elegida.
- **JugarDificil**: Se encarga de mostrar el juego, comprobar las respuestas y mostrarte si has acertado o fallado en dificultad difícil. También te muestra si has ganado o perdido.
- **JugarFaMe**: Se encarga de mostrar el juego, comprobar las respuestas y mostrarte si has acertado o fallado en las dificultades fácil y media. También te muestra si has ganado o perdido.
- **UtilidadesJuego**: Se encarga de gestionar todos los metodos usados a la hora de jugar.
- **GuardarPartidas**: Se encarga de guardar las partidas en la base de datos una vez terminan. También las almacena para guardarlas en un archivo.txt.
- **VarGenYConst**: Gestiona las variables genericas y constantes del juego.
- **Utilidades**: Se encarga de gestionar metodos genericos usados en todo el juego.
- **dificultadDelJuego**: Se encarga de gestionar la dificultad del juego.
- **GestionAspecto**: Se encarga de mostrar una selección de colores para elegir de personaje o del agua. Valida la respuesta y asigna dichos colores.
- **GestionHistorial**: Muestra los datos de la última partida.
- **Validaciones**: Impide avanzar entre menús si pones un caracter incorrecto. 
- **Colores**: Puedes elegir tanto el color del agua como el color de tu personaje.
- **Victoria**: Si respondes a todas las preguntas correctamente ganarás y se te devolverá al menú principal.
- **Derrota**: Si fallas, cuando el agua cubra toda la sala se mostrará un mensaje de derrota.
- **Log**: En caso de ocurrir algún error en el juego, lo guarda en formato de texto.
- **GestionMusica**: Se encarga de gestionar el menú de música y todas las opciones relacionadas. 
- **GestionPerfil**: Se encarga de gestionar el menú del perfil y sus opciones.
- **Excepciones**: Se encargan de registrar los errores del juego para guardaelos en el log.
- **PartidasTxt**: Se encarga de guardar en un fichero.txt las partidas de la sesión junto al nombre del usuario y mostrarlo al final de la partida.


## Notas Adicionales

Este proyecto está diseñado para la asignatura `Fundamentos de programación` donde implementamos código en `java` y aprendemos a programar en dicho lenguaje.
Hay unas cuantas mejoras por hacer proximamente, como no permitir usuarios nulos, modularizar más los modulos, guardar las respuestas según se juega la partida y poder entrar a una partida que has dejado a medias.
El aspecto gráfico también tiene mucho que mejorar, falta implementar el agua que vaya subiendo y el policía que te dispara en la dificultad difícil.

**Este proyecto conitene:**
- **Conexion a base de datos**: Conectamos, insertamos, actualizamos, creamos y descargamos datos de la base de datos.
- **Ficheros**: Creamos, leemos y cargamos datos en ficheros. 
- **Modularización**: Descomposición del programa en métodos y archivos diferentes.
- **Empaquetado**: Mantener un orden de paquetes en el programa.
- **Documentación**: Creación de un documento de análisis técnico del software.
- **Buenas Prácticas**: Uso de buenas prácticas en nuestro código.
- **Clases**: Creación de clases y superclases con herencia.