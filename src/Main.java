import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // --------------------------- SCANNER : --------------------------------
        // Scanner - Entrada estándar (standard input)

        // tipoDeDato nombreDeLaVariable = valor;
        Scanner scanner = new Scanner(System.in);

        //nameMethod(scanner);
        //ageMethod(scanner);
        //priceMethod(scanner);

        //avoidingErrorMethod(scanner);

        // scannerExercise(scanner);


        // --------------------------- FILE WRITER & READER : --------------------------------
        // FileWriter - para escribir datos en un archivo

        // Ruta absoluta:
        // String fileName = "/Users/lisamedina/Desktop/fileName.txt";

        // Ruta relativa (en relación al directorio actual):
        // String fileName = "/../../../fileName.txt";

        String fileName = "fileName.txt"; // lo crea en el mismo repositorio

        //fileWriter(fileName);
        //fileWriterWithTryCatch(fileName);
        //fileWriterWithTryWithResources(fileName);

        //reader(fileName);

        notesAppExercise(scanner);


        scanner.close(); // para liberar recursos siempre cerrad el scanner
    }

    private static void nameMethod(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.next(); // captura el input hasta el siguiente espacio en blanco y no consume el salto de línea

        System.out.println("Enter your surname:");
        String surname = scanner.next();

        System.out.println("Hello " + name + " " + surname + " !!");

        scanner.nextLine(); // si no consumo el salto de línea o enter o \n lo guardará en "fullName"

        System.out.println("Enter your initials:");
        String initials = scanner.nextLine(); // consume toda la línea hasta encontrar un \n Y LO CONSUME

        System.out.println("Your initials are " + initials);
    }

    private static void ageMethod(Scanner scanner) {
        System.out.println("Enter your age:");

        int age = scanner.nextInt(); // captura el siguiente número entero hasta el siguiente espacio \n y no consume el salto de línea

        System.out.println("You are " + age + " years old");

        System.out.println("Enter your sister's age: ");
        int sistersAge = scanner.nextInt();


        scanner.nextLine(); // "me cargo" / consumo el salto de línea que tenía en memoria

        System.out.println("Enter her name:");

        String sistersName = scanner.nextLine();

        System.out.println("Your sister's name is " + sistersName + " and her age is " + sistersAge);

//        if (age == 18) {
//            System.out.println("You are " + age + " years old and an adult, you can finally drive!");
//
//        } else if (age >= 18) {
//            System.out.println("You are " + age + " years old and an adult");
//
//        } else {
//
//            System.out.println("You are " + age + " years old and a minor");
//        }
    }

    private static void priceMethod(Scanner scanner) {
        System.out.println("Enter the item's price:");

        double price = scanner.nextDouble();

        System.out.println("The item's price is " + price);

//        if (age >= 18) {
//            System.out.println("Enter the item's price:");
//            double price = scanner.nextDouble();
//
//            System.out.println("The item's price is " + price);
//        } else {
//            System.out.println("BYE BYE");
//        }
    }


    private static void avoidingErrorMethod(Scanner scanner) {
        System.out.println("------ To test the error ------");
        System.out.println("Enter your age:");

        int age = scanner.nextInt();

        String unusedLine = scanner.nextLine(); // comentad esto para ver que es necesario consumir el salto de línea \n enter

        System.out.println("Enter your name:");

        String name = scanner.nextLine();

        System.out.println("You are " + age + " years old and a minor");
        System.out.println("Hello " + name + " !!");

        System.out.println("This is my unused line " + unusedLine); // no hace falta guardarlo en una variable, es solo para test
    }


    private static void scannerExercise(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        //solicitar la edad del usuario y validar que sea un entero positivo usando do-while
        int age;
        do {
            System.out.println("Enter your age (positive number):");

            //si la entrada no es un entero hasNextInt() devuelve false
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar la entrada no válida
            }

            age = scanner.nextInt();
            if (age < 0) {
                System.out.println("Por favor, ingrese un número positivo.");
            }
        } while (age < 0);

        //consumir el salto de línea que queda después de nextInt()
        scanner.nextLine();

        System.out.println("Enter your favourite hobby:");
        String hobby = scanner.nextLine();

        //desafío adicional
        System.out.println("Enter your favourite number:");
        int favoriteNumber = scanner.nextInt();
        int sum = age + favoriteNumber;

        System.out.println("\nUser profile:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favourite hobby: " + hobby);
        System.out.println("Age and favourite number sum: " + sum);
    }


    private static void fileWriter(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        // append = añadir a un archivo FileWriter writer = new FileWriter("fileName.txt", true);

        writer.write("Hello world\n");
        writer.write("Second line\n");
        writer.write("Third line\n");
        writer.write("BYE");

        writer.close();
    }

    private static void fileWriterWithTryCatch(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, false);

            writer.write("Hello world\n");
            writer.write("Second line\n");
            writer.write("Third line\n");
            writer.write("BYE");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileWriterWithTryWithResources(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("Hello world\n");
            writer.write("Second line\n");
            writer.write("Third line\n");
            writer.write("BYE");

            // writer.close(); No es necesario porque el try cierra automáticamente los recursos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void reader(String fileName) throws FileNotFoundException {
        // Scanner para leer las líneas del archivo
        Scanner scanner1 = new Scanner(new FileReader(fileName));
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            System.out.println("Reading line: " + line);
        }
        scanner1.close();
    }

    public static void notesAppExercise(Scanner scanner) {
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a note");
            System.out.println("2. Read all notes");
            System.out.println("3. Delete all notes");
            System.out.println("4. Exit");
            System.out.print("Option: ");

            // Asegurar que el input es int
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                System.out.print("Option: ");
                scanner.next(); // Consume the invalid input
            }

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    deleteNotes();
                    break;
                case 4:
                    continueLoop = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void addNote(Scanner scanner) {
        System.out.println("Write a note:");
        String note = scanner.nextLine();

        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(format);

        // Añadir la nota al archivo
        try (FileWriter writer = new FileWriter("notes.txt", true)) { // true para añadir al archivo, no sobreescribir
            writer.write(timestamp + " - " + note + "\n");
            System.out.println("Your note was saved successfully.");
        } catch (IOException e) {
            System.out.println("There was an error while saving your note.");
            e.printStackTrace();
        }
    }

    public static void readNotes() {
        try (Scanner fileScanner = new Scanner(new FileReader("notes.txt"))) {
            System.out.println("Notes content:");
            if (!fileScanner.hasNextLine()) {
                System.out.println("There are no saved notes.");
            } else {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error while reading your notes.");
            e.printStackTrace();
        }
    }

    public static void deleteNotes() {
        try (FileWriter writer = new FileWriter("notes.txt", false)) { // false para sobrescribir el archivo
            writer.write(""); // Sobrescribir con un archivo vacío
            System.out.println("Your notes where deleted.");
        } catch (IOException e) {
            System.out.println("There was an error while deleting your notes.");
            e.printStackTrace();
        }
    }
}