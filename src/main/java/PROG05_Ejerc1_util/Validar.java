package PROG05_Ejerc1_util;

/**
 *
 * Clase para las validaciones. Métodos públicos y estáticos.
 * @author Javier Gómez
 * 
 */
public class Validar {
    
    /**
     * 
     * Valida si un año es bisiesto.
     * @author Javier Gómez
     * @param annio Año a calcular.
     * @return <code><b>bisiesto</b></code> Verdadero si el año es bisiesto.
     * 
     */
    public static boolean esBisiesto(int annio) {
        // Declara variables del método
        boolean bisiesto;
        boolean div4, div100, div400;
        
        // Calculamos si es bisiesto
        div4 = ((annio % 4) == 0);
        div100 = ((annio % 100) == 0);
        div400 = ((annio % 400) == 0);
        bisiesto = (div4 && (!div100)) || (div4 && div100 & div400);
        
        return bisiesto;
    }
}