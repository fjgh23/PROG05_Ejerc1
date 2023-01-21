package PROG05_Ejerc1_util;

/**
 * 
 * Clase para la gestión del DNI.
 * @author Javier Gómez
 * 
 */
public class DNI {
    // Declara los atributos de la clase
    private int numDNI;
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final int DNI_MAX = 99999999;
    private static final int DNI_MIN = 999999;
    
    /**
     * 
     * Devuelve sólo el número del DNI.
     * @author Javier Gómez
     * @return Nº entero con el valor del DNI.
     * 
     */
    public int getDNI() {
        return numDNI;
    }
    
    /**
     * 
     * Devuelve el NIF (incluye el nº de DNI y la letra).
     <br>Cálcula la letra en el momento.
     * @author Javier Gómez
     * @return <code><b>cadNIF</b></code> Cadena con el valor del NIF (DNI y la letra correspondiente).
     * 
     */
    public String getNIF() {
        // Declara variables del método
        String cadNIF;
        char letra;
        String cadLetra;
        
        // Calcula la letra del DNI
        letra = DNI.calcularLetraDNI(numDNI);
        // Convierte el número de DNI en cadena
        cadNIF = String.valueOf(numDNI);
        // Convierte la letra en una cadena
        cadLetra = String.valueOf(letra);
        // Completa la cadena para el NIF
        cadNIF = cadNIF + cadLetra;
        
        return cadNIF;
    }
    
    /**
     * 
     * Establece el DNI.
     * @author Javier Gómez
     * @param dni Nº de DNI a establecer.
     * @throws java.lang.Exception Lanza una excepción si el DNI es inválido.
     * 
     */
    public void setDNI(int dni) throws Exception {
        // Valida el DNI
        if (validarDNI(dni))
            numDNI = dni;
        else
            // DNI inválido, lanza excepción
            throw new Exception("DNI inválido: " + String.valueOf(dni));
    }
    
    /**
     * 
     * Establece el DNI a través del NIF.
     * @author Javier Gómez
     * @param nif Cadena con el NIF a establecer como DNI.
     * @throws java.lang.Exception Lanza una excepción para NIF inválido.
     * 
     */
    public void setDNI(String nif) throws Exception{
        if (validarNIF(nif))
            // NIF válido, asigna DNI
            numDNI = DNI.extraerNumeroNIF(nif);
        else
            // NIF inválido, lanza excepción
            throw new Exception("NIF inválido: " + nif);
    }
    
    /**
     * 
     * Calcula la letra correspondiente a un DNI.
     * @author Javier Gómez
     * @param dni Nº de DNI.
     * @return <code><b>letra</b></code> La letra del NIF.
     * 
     */
    public static char calcularLetraDNI(int dni) {
        // Declara las variables del método
        char letra = ' ';
        
        // Valida el DNI
        if (validarDNI(dni)) {
            // Del array de letras para el DNI extrae la correspondiente
            letra = LETRAS_DNI.charAt(dni % 23);
        }
        
        return letra;
    }
    
    /**
     * 
     * Extrae la letra de un NIF.
     * @author Javier Gómez
     * @param nif NIF a extraer la letra.
     * @return <code><b>letra</b></code> La letra del NIF.
     * @throws java.lang.Exception Transmite la excepción de preValidadNIF.
     * 
     */
    public static char extraerLetraNIF(String nif) throws Exception {
        // Declara las variables del método
        int largo;
        char letra = ' ';

        // Realiza un chequeo del NIF
		if (preValidarNIF(nif)) {
			// No es nulo y tamaño correcto
			// Longitud del NIF
			largo = nif.length();
			// Extrae el último carácter de la cadena
			letra = nif.charAt(largo - 1);
        }
		
        return letra;
    }
    
    /**
     * 
     * Extrae el nº de DNI de un NIF.
     * @author Javier Gómez
     * @param nif NIF a extraer el nº de DNI.
     * @return <code><b>dni</b></code> Variable entera con el nº del DNI o 0.
     * @throws java.lang.Exception Transmite la excepción de preValidadNIF.
     * 
     */
    public static int extraerNumeroNIF(String nif) throws Exception {
        // Declara las variables del método
        int dni = 0;
        int largo;
        String cadDni;
        
        // Realiza un chequeo del NIF
		if (preValidarNIF(nif)) {
			// No es nulo y tamaño correcto
			// Longitud del NIF
			largo = nif.length();
			// Extrae todos los caracteres de la cadena menos el último
			cadDni = nif.substring(0, largo - 1);
			try {
				// Convierte a entero la cadena extraída
				dni = Integer.parseInt(cadDni);
			} catch (Exception ex) {
				System.out.println("\n" + ex.getMessage() + "\n");
			}
			// Valida el DNI extraído
			if (!validarDNI(dni))
				// No es válido el DNI
				dni = 0;
        }
		
        return dni;
    }
    
    /**
     * 
     * Realiza una primera comprobación a un NIF.
     * @author Javier Gómez
     * @param nif Es el NIF a verificar.
     * @return <code><b>valido</b></code> Verdadero, NIF correcto.
     * @throws java.lang.Exception Lanza excepciones si:<br>
	 <ol>
		<li>Se ha pasado un NIF nulo.</li>
		<li>La longitud del NIF es incorrecta.</li>
	 </ol>
     * 
     */
	private static boolean preValidarNIF(String nif) throws Exception {
        // Declara las variables del método
        boolean valido = false;
        int largo;
        
        // Comprueba el paso del parámetro
        if (nif == null || nif.length() == 0)
            throw new Exception("Se ha pasado un NIF nulo.");
        else {
            // No es nulo ni está vacío
            largo = nif.length();
            if (largo > 7 && largo < 10)
				valido = true;
			else
                throw new Exception("La longitud del NIF es incorrecta.");
        }

		return valido;
	}
	
    /**
     * 
     * Valida si un DNI es correcto.
     * @author Javier Gómez
     * @param dni Número de DNI a verificar.
     * @return <code><b>valido</b></code> Verdadero, número del DNI correcto.
     * 
     */
    public static boolean validarDNI(int dni) {
        // Declara las variables del método
        boolean valido = false;
        
        // Comprueba si el valor se halla entre los márgenes establecidos
        if (dni > DNI_MIN && dni < DNI_MAX)
           valido = true;
        
        return valido;
    }
    
    /**
     * 
     * Valida si un NIF es correcto (la letra corresponde con el nº).
     * @author Javier Gómez
     * @param nif NIF a verificar.
     * @return <code><b>valido</b></code> Verdadero, letra del NIF correcta.
     * @throws java.lang.Exception Lanza una excepción si el NIF es incorrecto.
     * 
     */
    public static boolean validarNIF(String nif) throws Exception {
        // Declara las variables del método
        boolean valido = false;
        char letra_nif;
        char letra_calculada;
        int dni;
        
        // Realiza un primer chequeo del NIF
		if (preValidarNIF(nif)) {
			// No es nulo y tamaño correcto
			// Extrae la letra del NIF
			letra_nif = extraerLetraNIF(nif);
			// Extrae el número del DNI
			dni = extraerNumeroNIF(nif);
			// El DNI es válido (mayor que 0)
			if (dni > 0) {
				// Calcula la letra del DNI
				letra_calculada = calcularLetraDNI(dni);
				// Comprobamos las letras
				valido = (letra_nif == letra_calculada);
				// Lanzamos la excepción si no es válido
				if (!valido)
					throw new Exception ("La letra del NIF es inválida.");
			} else
				throw new Exception("El nº de DNI del NIF es inválido.");
		}
		
        return valido;
    }
    
}
