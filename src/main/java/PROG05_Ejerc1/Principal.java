package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import PROG05_Ejerc1_util.DNI;
import PROG05_Ejerc1_util.Validar;

/**
 *
 * Gestión de un vehículo.
 * @author Javier Gómez
 *
 */
public class Principal {

    // Declara atributos de la clase
    static Vehiculo coche;
    int HolaED = 1;
    
    /**
     *
     * Lee una cadena por teclado.
     * @param msj Mensaje a mostrar para introducir la cadena.
     * @return <code><b>cad</b></code> Cadena a retornar.
     *
     */
    public static String leerCadena(String msj) {
        // Declara variables del método
        String cad;
		// Clase Scanner para petición de datos
//		Scanner teclado = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in, "CP850");
        
        // Muestra el mensaje
        System.out.print(msj);
        // Espera hasta la introdución de una cadena (intro)
        cad = teclado.nextLine();
        
        return cad;
    }
    
    /**
     *
     * Lee una fecha por teclado (año, mes y día) entre dos fechas dadas.
     * @param msj Mensaje a mostrar para introducir la fecha.
     * @param fechaMin Fecha mínima admitida (inclusive).
     * @param fechaMax Fecha máxima admitida (inclusive).
     * @return <code><b>fecha</b></code> Fecha admitida.
     *
     */
    public static LocalDate leerFecha(String msj, LocalDate fechaMin, 
        LocalDate fechaMax) {
        // Declara variables del método
        boolean fecErr;
        int dia, mes, annio, maxDias, annioMin, annioMax;
        LocalDate fecha;
        DateTimeFormatter formato = 
            DateTimeFormatter.ofPattern("dd-MM-yyyy");     
        
        // Comprueba los parámetros
        if (fechaMin.isAfter(fechaMax)) {
            System.out.println("Fecha mínima mayor que fecha máxima.");
            return null;
        }
        
        // Asigna fecha, el año mínimo y máximo
        fecha = fechaMin;
        annioMin = fechaMin.getYear();
        annioMax = fechaMax.getYear();
        
        // Bucle entre fecha min y fecha max
        do {
            // Activa el estado de error
            fecErr = true;
            
            // Solicita el año
            annio = leerNumero(msj + " Año: ", "Año no válido.", 
                    annioMin, annioMax);
            
            // Solicita el mes
            mes = leerNumero(msj + " Mes: ", "Mes no válido", 
                    1, 12);
            
            // Calcula el día máximo del mes
            switch (mes) {
                case 2:
                    maxDias = (Validar.esBisiesto(annio)) ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    maxDias = 30;
                    break;
                default:
                    maxDias = 31;
            }
            
            // Solicita el día
            dia = leerNumero(msj + " Día: ", "Día no válido", 
                    1, maxDias);
            
            // Generamos la fecha
            try {
                // Convertimos el año, mes y día en fecha
                fecha = LocalDate.of(annio, mes, dia);
                
                // Compara la fecha con el mínimo
                if (fecha.isEqual(fechaMin) || 
                    fecha.isAfter(fechaMin)) {
                    // Fecha igual o mayor que el mínimo
                    // Compara la fecha con el máximo
                    if (fecha.isEqual(fechaMax) || 
                        fecha.isBefore(fechaMax)) {
						// Fecha igual o menor que el máximo
                        // Correcto, desactiva el estado de error
                        fecErr = false;
                    } else
                        // Fecha mayor que máximo
                        System.out.println("\nFecha introducida: " + 
                            fecha.format(formato) + 
                            "\n es mayor que: " + 
                            fechaMax.format(formato));
                } else
                    // Fecha menor que mínimo
                    System.out.println("\nFecha introducida: " + 
                        fecha.format(formato) + "\n es menor que: " + 
                        fechaMin.format(formato));
            } catch (Exception ex) {
				// Se produjo un error al convertir la fecha
                System.out.println("\nError en fecha.");
            }
        } while (fecErr);
        
        return fecha;
    }
    
    /**
     *
     * Lee un número por teclado.
     * @param msj Mensaje a mostrar para introducir el número.
     * @param msjErr Mensaje de error a mostrar.
     * @param min Valor mínimo a introducir (inclusive).
     * @param max Valor máximo admitido (inclusive)
     * @return <code><b>num</b></code> Valor a retornar (entre min y max).
     * @exception InputMismatchException Controla la introducción de un entero.
     *
     */
    public static int leerNumero(String msj, String msjErr, int min, int max) {
        // Declara variables del método
        boolean numErr;
        int num = 0;
		// Clase Scanner para petición de datos
		Scanner teclado = new Scanner( System.in);
        
        // Comprueba los mensajes
        if (msj.length() == 0)
            msj = "Introduce un número entero: ";
        if (msjErr.length() == 0)
            msjErr = "No es un número entero";
        if (min > max) {
            System.out.println("\n Error en parámetros:\nMínimo: " + min +
                "\n mayor que máximo: " + max);
        }
        
        // Bucle entre min y max
        do {
            // Bucle hasta introducir un entero
            do {
                try {
					// Muestra el mensaje
                    System.out.print(msj);
					// Lee un entero
                    num = teclado.nextInt();
					// Sin errores
                    numErr = false;
                } catch (InputMismatchException ime) {
					// Muestra mensaje de error
                    System.out.println("\n" + msjErr);
                    teclado.nextLine();
					// Con errores
                    numErr = true;
                }
            } while (numErr);
        } while (num < min || num > max);

        return num;
    }
    
    /**
     *
     * Muestra el menú de la aplicación y permite seleccionar una opción.
     * @return Nº entero con el valor seleccionado en el menú.
     *
     */
    private static int menu() {
        // Declara variables del método
        int opc;
       
        // Muestra el menú
        System.out.println("\n\n==========================");
        System.out.println("      Menú: Vehículo");
        System.out.println("==========================");
        System.out.println(" 1. Nuevo vehículo");
        System.out.println(" 2. Ver matrícula");
        System.out.println(" 3. Ver nº de kilómetros");
        System.out.println(" 4. Actualizar kilómetros");
        System.out.println(" 5. Ver años de antigüedad");
        System.out.println(" 6. Mostrar propietario");
        System.out.println(" 7. Mostrar descripción");
        System.out.println(" 8. Mostrar precio");
        System.out.println(" 9. Salir");
        System.out.println("--------------------------");
        // Introducir opción
        opc = leerNumero(" Seleccione una opción: ",
            "No es una opción válida", 1, 9);
        // Salta una línea
        System.out.println();
    
        return opc;
    }

    /**
     *
     * Introduce los datos de un vehículo.
     * @return Verdadero: Todo correcto. Falso: Se produjeron errores.
     *
     */
    static private boolean introducirVehiculo() {
        // Declara variables del método
        boolean ok;
        int kilometros, precio;
        LocalDate fechaMatriculacion;
        String descripcion, dniNIF, marca, matricula, propietario;
        
        // Solicita la matrícula
        matricula = leerCadena("Introducir la matrícula del vehículo: ");
        // Convierte a mayúsculas y la muestra
        matricula = matricula.toUpperCase();
        System.out.println("Matrícula: " + matricula);
        
        // Solicita la marca
        marca = leerCadena("Introducir la marca del vehículo: ");
        
        // Solicita la descripción
        descripcion = leerCadena(
        "Introducir la descripción del vehículo: ");
        
        // Solicita el propietario
        propietario = leerCadena(
        "Introducir el nombre del propietario del vehículo: ");
        
        // Solicita los kilómetros
        kilometros = leerNumero(
        "Introducir número de kilómetros del vehículo: ", 
                "Nº de kilómetros incorrecto.", 0, 10000000);
        
        // Bucle para el DNI del propietario
        do {
            // Solicita el DNI del propietario
            dniNIF = leerCadena("Introducir DNI (NIF) del propietario: ");
            // Convierte a mayúsculas y muestra el DNI
            dniNIF = dniNIF.toUpperCase();
            System.out.println("DNI (NIF): " + dniNIF);
            
            try {
                // Valida el DNI (NIF)
                DNI.validarNIF(dniNIF);
				// Correcto
                ok = true;
            } catch (Exception ex) {
                // Muestra el mensaje establecido para la excepción
                System.out.println(ex.getMessage() + "\n");
				// Errores
                ok = false;
            }
        } while (!ok);
        
        // Solicita el precio del vehículo
        precio = leerNumero(
        "Introducir precio del vehículo (sin decimales): ", 
                "Precio no válido.",0, 999999);
        
        // Solicita la fecha de matriculación
        fechaMatriculacion = leerFecha("Fecha de matriculación.", 
                LocalDate.of(1900, Month.JANUARY, 1), 
                LocalDate.now());
        
		// Instancia el vehículo con sus atributos
		coche = new Vehiculo(matricula, marca, fechaMatriculacion, 
			descripcion, kilometros, precio, propietario, dniNIF);
        
        return ok;
    }
    
    /**
     *
     * Método main de la aplicación.
     * @param args No utiliza parámetros.
     *
     */
    public static void main(String[] args) {
        // Declara variables del método main
        int opcion;
        int kilo;
        
        // Bucle para mostrar el menú hasta finalizar
        do {
            // Muestra el menú y selecciona una opción
            opcion = menu();
            
            // Según la opción seleccionada
            try {
                switch (opcion) {
                    case 1:     // Nuevo vehículo
                        if (introducirVehiculo())
							// Correcto
                            System.out.println(
                              "\nVehículo introducido correctamente.");
                        else
							// Errores
                            System.out.println("\nError  en el vehículo.");

                        break;
                    case 2:     // Ver matrícula
                        System.out.println("Nº de matrícula: " + 
                                coche.getMatricula());
                        break;
                    case 3:     // Ver nº de kilómetros
                        System.out.printf("Nº de kilómetros: %,d", 
                                coche.getKilometros());
						System.out.println();
                        break;
                    case 4:     // Actualizar kilómetros
                        // Solicita los kilómetros recorridos
                        kilo = leerNumero(
                                "Introducir número de kilómetros recorridos: ", 
                                "Nº de kilómetros incorrecto.", 0, 
                                10000000);
			// Incrementa el total de kilómetros
                        kilo += coche.getKilometros();
                        coche.setKilometros(kilo);
			// Muestra el total de kilómetros
                        System.out.printf("Total kilómetros: %,d", 
                                coche.getKilometros());
						System.out.println();
                        break;
                    case 5:     // Ver años de antigüedad
                        System.out.println("Años de antigüedad: " + 
                                coche.getAnnios());
                        break;
                    case 6:     // Mostrar propietario
                        System.out.println("Nombre del propietario: " + 
                                coche.getPropietario());
						// Muestra el DNI del propietario
                        System.out.println("DNI del propietario...: " + 
                                coche.getDNI());
                        break;
                    case 7:     // Mostrar descripción
						// Muestra el nº de matrícula
                        System.out.println("Nº de matrícula.: " + 
                                coche.getMatricula());
						// Muestra la descripción
                        System.out.println("Descripción.....: " + 
                                coche.getDescripcion());
						// Muestra el nº de kilómetros
                        System.out.printf("Nº de kilómetros: %,d", 
                                coche.getKilometros());
						System.out.println();
                        break;
                    case 8:     // Mostrar precio
                        System.out.printf("Precio: %,d euros", coche.getPrecio());
						System.out.println("");
                        break;
                    case 9:     // Salir
                        System.out.println("Gracias por participar.");
                        System.out.println("    ¡Vuelva pronto!");
                        break;
                    default:
                        System.out.println("Opción desconocida.");
                        System.out.println("Vuelva a intentarlo.");
                }
            } catch (NullPointerException npe) {
                // Mensaje de la excepción
                System.out.println("\nVehículo sin inicializar.");
            }
            
            // ¿Vamos a Salir?
            if (opcion < 9)
				// No vamos a salir
				leerCadena("Pulse ENTER (INTRO) para continuar...");
        } while (opcion != 9);
        
        // Fin del programa
        System.out.println("\nFin.");
    }
}
