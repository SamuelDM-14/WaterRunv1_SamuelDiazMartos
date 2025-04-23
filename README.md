
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
- **Java (`GestionPregunta.java`)**: Clase para gestionar las preguntas.
- **Java (`Personaje.java`)**: Superclase de tipos de personajes.
- **Java (`Policia.java`)**: Subclase de Personaje con atributos y metodos diferentes a escapista.
- **Java (`Escapista.java`)**: Subclase de Personaje con atributos y metodos diferentes a policia.
- **Java (`Jugador.java`)**: Clase que se encargará de registrar los datos del jugador.
- **Java (`Partida.java`)**: Clase que se encargará de registrar los datos de la partida.
- **Java (`Utilidades.java`)**: Clase encargada de gestionar todas las validaciones de respuestas.
- **Java (`VarGenYConst.java`)**: Clase encargada de gestionar todas las variables genéricas y constantes.
- **Java (`GestionJugar.java`)**: Clase con el codigo general. Se encarga de gestionar los menús.
- **Java (`Aspecto.java`)**: Clase que se encarga de gestionar la gestión de colores.
- **Java (`Jugar.java`)**: Clase que gestiona la opción de Jugar. 
- **Java (`JugarFaMe.java`)**: Clase que gestiona la partida en dificultad fácil y media. 
- **Java (`JugarDificil.java`)**: Clase que gestiona  la partida en dificultad difícil. 
- **Jar (`WaterRun.jar`)**: Versión ejecutable del juego.
- **Manifest (`Manifest.txt`)**: Archivo para crear el WaterRun.Jar.



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
            Preguntas.class
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
                GuardarRespuesta.class
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
            Preguntas.java
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
                GuardarRespuesta.java
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
            Log.class
        Manifest.txt
```

## Requisitos del Sistema

- **Java Developmen Kit (JDK)**: version 21 o superior.
- Entorno de desarrollo integrado (IDE) recomendado: Visual Studio Code.

## Instrucciones de Ejecución
1. Abre el proyecto en **Visual Studio Code**
2. Asegúrate de que JDK 21 esté correctamente configurado.
3. Ve a la carpeta `src/` y selecciona el archivo que deseas ejecutar
(`WaterRun.java` o `WaterRun.jar`)
4. En caso de elegir `WaterRun.java` complia y ejecuta el programa.
   En caso de elegir `WaterRun.jar` selecciona en la parte superior izquierda
   `Terminal` y ejecuta el siguietne comando: `java -jar WaterRun.jar`
5. En caso de que al seleccionar un color no se muestre en el cmd y se
   muestren unos caracteres, escriba este comando en la terminal y reiniciela.
    `reg add HKEY_CURRENT_USER\Console /v VirtualTerminalLevel /t REG_DWORD /d 1`


## Funcionalidades Principales

- **bienvenida**: Se encarga de mostrar el mensaje de bienvenida.
- **menu1**: Se encarga de mostrar el menú principal del juego donde nos dejará elegir entre: `Jugar`, `Dificultad`, `Aspecto`, `Historial` o `Salir`
- **jugar**: Se encarga de mostrar el juego, comprobar las respuestas y mostrarte si has acertado o fallado. También te muestra si has ganado o perdido y las preguntas cambian en función de la dificultad.
- **dificultadDelJuego**: Se encarga de gestionar la dificultad del juego.
- **cambiarAspecto**: Se encarga de mostrar una selección de colores para elegir de personaje o del agua. Valida la respuesta y asigna dichos colores.
- **historial**: Muestra los datos de la última partida.
- **Validaciones**: Impide avanzar entre menús si pones un caracter incorrecto. 
- **Colores**: Puedes elegir tanto el color del agua como el color de tu personaje.
- **Victoria**: Si respondes a todas las preguntas correctamente ganarás y se te devolverá al menú principal.
- **Derrota**: Si fallas, cuando el agua cubra toda la sala se mostrará un mensaje de derrota.


## Notas Adicionales

Este proyecto está diseñado para la asignatura `Fundamentos de programación` donde implementamos código en `java` y aprendemos a programar en dicho lenguaje.

**Este proyecto conitene:**
- **Modularización**: Descomposición del programa en métodos y archivos diferentes.
- **Empaquetado**: Mantener un orden de paquetes en el programa.
- **Documentación**: Creación de un documento de análisis técnico del software.
- **Buenas Prácticas**: Uso de buenas prácticas en nuestro código.
- **Clases**: Creación de clases y superclases con herencia.