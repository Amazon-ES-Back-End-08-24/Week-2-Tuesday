# Tabla de Contenidos

- [Entrada Estándar (Scanner)](#entrada-estándar-scanner)
    - [Introducción a la Entrada Estándar (Scanner)](#introducción-a-la-entrada-estándar-scanner---standard-input)
    - [¿Por qué Usar Scanner?](#por-qué-usar-scanner)
    - [Conceptos Básicos de Scanner](#conceptos-básicos-de-scanner)
    - [Creación de un Objeto Scanner](#creación-de-un-objeto-scanner)
    - [Leer Diferentes Tipos de Datos](#leer-diferentes-tipos-de-datos)
        - [Leer un String](#leer-un-string)
        - [Leer un Integer](#leer-un-integer)
        - [Leer un Double](#leer-un-double)
    - [Notas Importantes sobre Scanner](#notas-importantes-sobre-scanner)
    - [Ejercicio Práctico: Perfil de Usuario](#ejercicio-práctico-perfil-de-usuario-15-minutos)
        - [Descripción de la Tarea](#descripción-de-la-tarea)
        - [Desafíos Adicionales](#desafíos-adicionales-si-el-tiempo-lo-permite)

- [File Reader y File Writer](#file-reader-y-file-writer)
    - [Introducción al File Reader y File Writer](#introducción-al-file-reader-y-file-writer)
    - [¿Por qué Usar File Reader y File Writer?](#por-qué-usar-file-reader-y-file-writer)
    - [Conceptos Básicos del File Reader y File Writer](#conceptos-básicos-del-file-reader-y-file-writer)
    - [Escribir en un Archivo usando FileWriter](#escribir-en-un-archivo-usando-filewriter)
    - [Añadir a un Archivo](#añadir-a-un-archivo)
    - [Leer de un Archivo usando FileReader y Scanner](#leer-de-un-archivo-usando-filereader-y-scanner)
    - [Notas Importantes sobre FileReader y FileWriter](#notas-importantes-sobre-filereader-y-filewriter)
    - [Ejercicio Práctico: App de Notas Simple](#ejercicio-práctico-app-de-notas-simple-15-minutos)
        - [Descripción de la Tarea](#descripción-de-la-tarea-1)
        - [Desafíos Adicionales](#desafíos-adicionales-si-el-tiempo-lo-permite-1)

# Entrada Estándar (Scanner)

## Introducción a la Entrada Estándar (Scanner) - Standard Input

En Java, los programas a menudo necesitan interactuar con los usuarios aceptando entradas de ellos. Aquí es donde la
clase Scanner es útil. Imagina que estás en la caja de un supermercado y el cajero te pide tu tarjeta de membresía para
darte descuentos. En este escenario, proporcionas tu tarjeta (entrada), y el cajero la escanea para procesar los
descuentos (Scanner). De manera similar, en Java, la clase Scanner se usa para "escanear" o leer las entradas
proporcionadas por el usuario, convirtiéndose en una herramienta esencial para crear programas interactivos.

### ¿Por qué Usar Scanner?

Usar la clase Scanner te ayuda a:

- Leer varios tipos de entrada del usuario, como cadenas, números y más.
- Hacer que tus programas sean interactivos al procesar los datos proporcionados por el usuario.
- Manejar y validar fácilmente la entrada, mejorando la experiencia del usuario.
- Evitar codificar valores directamente, haciendo que tus programas sean más flexibles y reutilizables.

### Conceptos Básicos de Scanner

La clase Scanner en Java es parte del paquete `java.util` y se usa para obtener entradas de varias fuentes, como la
entrada del teclado (entrada estándar), archivos y más. Puede leer diferentes tipos de datos, incluidas cadenas, enteros
y números de punto flotante.

### Creación de un Objeto Scanner

Para usar la clase Scanner, primero debes crear un objeto Scanner. Este objeto sirve como un "escuchador" que espera que
el usuario introduzca datos.

Sintaxis:

```java
Scanner scanner = new Scanner(System.in);
```

Ejemplo:

```java
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        // Crear un objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese datos
        System.out.println("Enter your name:");

        // Leer la entrada del usuario
        String name = scanner.nextLine();

        // Mostrar la entrada del usuario
        System.out.println("Hello, " + name + "!");
    }
}
```

### Leer Diferentes Tipos de Datos

La clase Scanner te permite leer diferentes tipos de entrada, como cadenas, enteros y números de punto flotante. Cada
tipo de dato tiene un método correspondiente en la clase Scanner.

#### Leer un String

Puedes usar `nextLine()` para leer una línea completa de texto.

Sintaxis:

```java
String userInput = scanner.nextLine();
```

Ejemplo:

```java
import java.util.Scanner;

public class ReadStringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your favorite programming language?");
        String language = scanner.nextLine();

        System.out.println("You love " + language + "!");
    }
}
```

#### Leer un Integer

Puedes usar `nextInt()` para leer un valor entero.

Sintaxis:

```java
int number = scanner.nextInt();
```

Ejemplo:

```java
import java.util.Scanner;

public class ReadIntExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        System.out.println("You are " + age + " years old.");
    }
}
```

#### Leer un Double

Puedes usar `nextDouble()` para leer un número de punto flotante.

Sintaxis:

```java
double value = scanner.nextDouble();
```

Ejemplo:

```java
import java.util.Scanner;

public class ReadDoubleExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the price of the item:");
        double price = scanner.nextDouble();

        System.out.println("The item costs $" + price);
    }
}
```

### Notas Importantes sobre Scanner

- Siempre cierra el objeto Scanner usando `scanner.close()` cuando ya no sea necesario para liberar recursos.
- Ten cuidado al mezclar `nextLine()` con otros métodos `nextX()` (como `nextInt()` o `nextDouble()`), ya
  que `nextLine()` podría capturar el carácter de nueva línea dejado por otros métodos. Esto se puede resolver agregando
  un `nextLine()` adicional después de la entrada de entero o doble.

Ejemplo:
Cuando usas nextInt() para leer un entero, el usuario introduce un número y luego presiona Enter. El método nextInt()
solo captura el número, pero deja el carácter de nueva línea (\n) en el buffer de entrada. Si después llamas a
nextLine(), este método puede capturar ese \n en lugar de esperar la siguiente entrada del usuario.

```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer un entero
        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        // Solución: Añadir un nextLine() extra para consumir el carácter de nueva línea restante
        scanner.nextLine(); // Consumir el salto de línea que queda después de nextInt()

        // Leer una cadena
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        // Mostrar la entrada del usuario
        System.out.println("Your age is: " + age);
        System.out.println("Your name is: " + name);

        scanner.close(); // No olvides cerrar el scanner
    }
}
```

- Maneja las posibles excepciones que pueden ocurrir cuando el usuario introduce tipos de datos inesperados.

### Ejercicio Práctico: Perfil de Usuario (15 minutos)

Crea un programa simple que solicite al usuario su nombre, edad y pasatiempo favorito, luego imprima un resumen de "
perfil de usuario".

#### Descripción de la Tarea:

1. Solicita al usuario que ingrese su nombre y guárdalo como una cadena.
2. Pide al usuario que introduzca su edad y guárdala como un entero.
3. Solicita el pasatiempo favorito del usuario y guárdalo como una cadena.
4. Imprime un resumen que incluya el nombre, la edad y el pasatiempo del usuario.

#### Desafíos Adicionales (si el tiempo lo permite):

1. Añade una característica para validar la edad del usuario y asegurarte de que ingrese un entero positivo.
2. Modifica el programa para que pregunte al usuario su número favorito y muestra la suma de su edad y número favorito.

Recuerda probar tu código exhaustivamente para asegurarte de que maneja todas las entradas del usuario de manera
adecuada. ¡Buena suerte!

---

# File Reader y File Writer

## Introducción al File Reader y File Writer

En Java, manejar archivos es un aspecto crucial de muchas aplicaciones, especialmente cuando se trata de persistencia de
datos—guardar datos que pueden ser accesibles incluso después de que el programa se cierre. Imagina escribir una nota en
un trozo de papel y guardarla en un archivador; puedes recuperarla siempre que la necesites. De manera similar, Java
proporciona mecanismos para leer y escribir archivos, lo que permite que tus programas almacenen y recuperen
información.

### ¿Por qué Usar File Reader y File Writer?

Usar Lector y Escritor de Archivos te ayuda a:

- **Persistir Datos:** Almacenar datos que pueden ser utilizados en diferentes sesiones del programa.
- **Procesar Grandes Cantidades de Datos:** Manejar datos que podrían ser demasiado grandes para almacenar en memoria
  leyendo o escribiendo en archivos.
- **Automatizar Tareas:** Automatizar el proceso de leer y escribir archivos, lo cual es esencial para muchas
  aplicaciones, como el registro de actividades, análisis de datos y generación de informes.

### Conceptos Básicos del File Reader y File Writer

En Java, `FileReader` y `FileWriter` son clases usadas para leer y escribir archivos de texto. `FileReader` lee flujos
de caracteres, mientras que `FileWriter` escribe flujos de caracteres en un archivo. Estas clases son parte del
paquete `java.io`.

- **FileReader:** Se usa para leer texto de un archivo. Lee los datos carácter por carácter.
- **FileWriter:** Se usa para escribir texto en un archivo. Escribe los datos carácter por carácter.

### Escribir en un Archivo usando FileWriter

La clase `FileWriter` se usa para escribir datos en un archivo. Si el archivo no existe, se creará. Si ya existe, los
datos serán sobrescritos a menos que especifiques que se añadan al archivo.

Sintaxis:

```java
FileWriter writer = new FileWriter("filename.txt");
```

Ejemplo:

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            // Paso 1: Crear un objeto FileWriter para escribir en el archivo
            FileWriter writer = new FileWriter("output.txt");

            // Paso 2: Escribir algo de texto en el archivo
            writer.write("Hello, World!\n");
            writer.write("This is a text file.");

            // Paso 3: Cerrar el FileWriter
            writer.close();

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Añadir a un Archivo

También puedes añadir datos a un archivo existente usando `FileWriter`. Esto significa que los nuevos datos se añadirán
al final del archivo, en lugar de sobrescribir su contenido.

Sintaxis:

```java
FileWriter writer = new FileWriter

        ("filename.txt", true);
```

Ejemplo:

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAppendExample {
    public static void main(String[] args) {
        try {
            // Paso 1: Crear un objeto FileWriter en modo de añadir
            FileWriter writer = new FileWriter("output.txt", true);

            // Paso 2: Añadir algo de texto al archivo
            writer.write("\nAppending new line to the file.");

            // Paso 3: Cerrar el FileWriter
            writer.close();

            System.out.println("Data has been appended to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Leer de un Archivo usando FileReader y Scanner

Además de usar `FileReader` para leer archivos carácter por carácter, también puedes combinar `FileReader` con `Scanner`
para leer archivos línea por línea de manera más conveniente. Esto es útil cuando necesitas procesar grandes cantidades
de texto o cuando el archivo contiene datos estructurados por líneas.

Ejemplo:

```java
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderWithScannerExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Llamada al método para leer el archivo
        try {
            reader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    // Método para leer un archivo línea por línea usando FileReader y Scanner
    private static void reader(String fileName) throws FileNotFoundException {
        // Scanner para leer las líneas del archivo
        Scanner scanner1 = new Scanner(new FileReader(fileName));
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            System.out.println("Reading line: " + line);
        }
        scanner1.close();
    }
}
```

### Notas Importantes sobre FileReader y FileWriter

- **Ruta del Archivo:** Asegúrate siempre de que se especifique la ruta correcta del archivo. Si el archivo no está en
  el directorio actual, necesitas proporcionar la ruta completa.
- **Manejo de Errores:** Siempre maneja excepciones como `FileNotFoundException` e `IOException` para asegurarte de que
  tu programa no se bloquee si el archivo está ausente o es inaccesible.
- **Gestión de Recursos:** Es una buena práctica cerrar tus objetos `FileReader` y `FileWriter` usando el
  método `close()` o utilizando try-with-resources para asegurarte de que los recursos sean liberados.
- **Codificación de Caracteres:** `FileReader` y `FileWriter` usan la codificación de caracteres predeterminada. Si
  necesitas una codificación específica, considera usar `InputStreamReader` y `OutputStreamWriter`.

### Ejercicio Práctico: App de Notas Simple (15 minutos)

Crea un programa que permita al usuario escribir notas en un archivo y luego leer las notas del archivo.

#### Descripción de la Tarea:

1. Solicita al usuario que ingrese una nota y guárdala en un archivo llamado "notes.txt".
2. Después de guardar la nota, lee el contenido de "notes.txt" y muéstralo en la consola.
3. Asegúrate de que las notas se añadan al archivo, no que se sobrescriban.

#### Desafíos Adicionales (si el tiempo lo permite):

1. **Borrar Notas:** Añade una opción para que el usuario borre todas las notas en el archivo.
2. **Notas con Marca de Tiempo:** Modifica el programa para añadir una marca de tiempo a cada nota antes de guardarla en
   el archivo.

Recuerda probar tu programa exhaustivamente para manejar varias entradas y escenarios de manera adecuada. ¡Buena suerte!

