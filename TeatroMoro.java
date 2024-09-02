// Actividad Formativa 4
// Alumno: Gonzalo Moya
// Semana: 4
// Tema: Fundamentos de Programación  
// Fecha de entrega: Lunes 2 de Septiembre 2024

import java.util.Scanner; // Importa la clase Scanner para la entrada del usuario

public class TeatroMoro {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        // Bucle for sin conciones para mostrar el menú principal hasta que el usuario por cuenta propia desee salir del programa.
        for (;;) {
            System.out.println("Menú Principal:");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación para asegurarse de que la entrada sea un número entero.
            if (!scanner.hasNextInt()) { 
                System.out.println("Dato ingresado no válido. Por favor, ingrese un número.");
                scanner.next(); // Limpiamos la entrada inválida.
                continue; // Volvemos al inicio del bucle.
            }

            opcion = scanner.nextInt(); // Leemos la opción seleccionada por el usuario.

            // Lógica del menú
            if (opcion == 1) {
                comprarEntrada(scanner); // Llama al método para comprar una entrada
            } else if (opcion == 2) {
                System.out.println("Gracias por usar el sistema."); // Mensaje de despedida
                break; // Rompe el bucle para salir del programa
            } else {
                System.out.println("Opción inválida. Por favor, seleccione 1 o 2."); // Validación de opción fuera de rango
            }
        }
    }

    // Método para gestionar la compra de entradas
    public static void comprarEntrada(Scanner scanner) {
        int zona = 0; // Inicialización de la variable para almacenar la zona seleccionada
        boolean zonaValida = false; // Indicador de si la zona ingresada es válida

        // Bucle para asegurar que se ingrese una zona válida
        do {
            System.out.println("Seleccione la ubicación del asiento:");
            System.out.println("1. Zona A");
            System.out.println("2. Zona B");
            System.out.println("3. Zona C");
            System.out.print("Ingrese el número de la zona: ");

            // Validación para asegurarse de que la entrada sea un número entero
            if (!scanner.hasNextInt()) { // Si la entrada no es un número entero
                System.out.println("Dato no válido. Por favor, ingrese un número del 1 al 3.");
                scanner.next(); // Limpia la entrada inválida
            } else {
                zona = scanner.nextInt(); 
                zonaValida = (zona >= 1 && zona <= 3);
                if (!zonaValida) {
                    System.out.println("Zona inválida. Por favor, ingrese un número del 1 al 3."); // Mensaje de error si la zona no está en el rango
                }
            }
        } while (!zonaValida); // Repite mientras la entrada sea true

        // Usa operadores ternarios para determinar el precio base según la zona
        int precioBase = (zona == 1) ? 15000 : (zona == 2) ? 12000 : 9000;

        int edad = 0; // Inicialización de la variable para almacenar la edad del usuario
        boolean edadValida = false; // Indicador de si la edad ingresada es válida

        // Bucle para asegurar que se ingrese una edad válida
        do {
            System.out.print("Ingrese su edad: ");

            // Validación para asegurarse de que la entrada sea un número entero
            if (!scanner.hasNextInt()) { // Si la entrada no es un número entero
                System.out.println("Dato no válido. Ingrese un número para la edad.");
                scanner.next(); // Limpia la entrada inválida
            } else {
                edad = scanner.nextInt(); // Lee la edad ingresada
                // Usa operador ternario para validar la edad
                edadValida = (edad > 0 && edad <= 99);
                if (!edadValida) {
                    System.out.println("Edad no válida. La edad debe ser entre 1 y 99."); // Mensaje de error si la edad no está en el rango
                }
            }
        } while (!edadValida); // Repite mientras la entrada siga siendo true.

        int descuento = (edad < 18) ? 5 : (edad >= 60) ? 10 : 0;

        int precioFinal = precioBase - (precioBase * descuento / 100);

        // resumen de la compra.
        System.out.println("Resumen de la compra:");
        System.out.println("Ubicación del asiento: Zona " + zona);
        System.out.println("Precio base: $" + precioBase);
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("Precio final a pagar: $" + precioFinal);

        // Preguntamos al usuario si desea realizar otra compra.
        char continuar; // Variable para almacenar la opción de continuar

        // Bucle do-while para validar la entrada del usuario
        do {
            System.out.print("¿Desea realizar otra compra? (s/n): ");
            continuar = scanner.next().toLowerCase().charAt(0); // Lee la opción de continuar y la convierte a minúscula

            // Validamos que la entrada sea 's' o 'n'
            if (continuar != 's' && continuar != 'n') {
                System.out.println("Opción no válida. Por favor, ingrese 's' para sí o 'n' para no."); // Mensaje de error para entradas no válidas
            }
        } while (continuar != 's' && continuar != 'n'); // Repite mientras la entrada no sea 's' o 'n'

        // Si el usuario decide no continuar se termina el programa.
        if (continuar == 'n') {
            System.out.println("Gracias por su compra.");
            System.exit(0); // Salida del programa.
        }
    }
}




