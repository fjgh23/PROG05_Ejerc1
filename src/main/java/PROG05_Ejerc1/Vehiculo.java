package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * Gestiona los atributos de cada vehículo utilizado.
 * @author Javier Gómez
 */
public class Vehiculo {
    // Declara los atributos de la clase privados
    // Sólo los métodos de la clase pueden acceder a los atributos
    private int kilometros;
    private int precio;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private String dni;
    private String marca;
    private String matricula;
    private String propietario;

    /**
     * 
     * Constructor de la clase Vehiculo.
     * @author Javier Gómez
     * @param matricula Matrícula del vehículo.
     * @param marca Marca del vehículo.
     * @param fechaMatriculacion Fecha de matriculación del vehículo.
     * @param descripcion Descripción del vehículo.
     * @param kilometros Kilómetros del vehículo.
     * @param precio Precio del vehículo.
     * @param propietario Nombre del propietario del vehículo.
     * @param dni Nº del DNI del propietario del vehículo.
     * 
     */
    public Vehiculo(String matricula, String marca, 
        LocalDate fechaMatriculacion, String descripcion, int kilometros, 
        int precio, String propietario, String dni) {
        
        // Asigna los atributos
        this.matricula = matricula;
        this.marca = marca;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.kilometros = kilometros;
        this.precio = precio;
        this.propietario = propietario;
        this.dni = dni;
    }

    /**
     * 
     * Devuelve la descripción del vehículo.
     * @author Javier Gómez
     * @return <code><b>descripcion</b></code> Descripción del vehículo.
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * Establece la descripción del vehículo.
     * @author Javier Gómez
     * @param descripcion Descripción del vehículo.
     * 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * Devuelve el número de DNI del propietario.
     * @author Javier Gómez
     * @return <code><b>dni</b></code> Número de DNI del propietario.
     * 
     */
    public String getDNI() {
        return dni;
    }

    /**
     * 
     * Establece el número de DNI del propietario.
     * @author Javier Gómez
     * @param dni Número de DNI del propietario.
     * 
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }

    /**
     * 
     * Devuelve la fecha de matriculación del vehículo.
     * @author Javier Gómez
     * @return <code><b>fechaMatriculacion</b></code> Fecha de matriculación del vehículo.
     * 
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * 
     * Establece la fecha de matriculación del vehículo.
     * @author Javier Gómez
     * @param fechaMatriculacion Fecha de matriculación del vehículo.
     * 
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    /**
     * 
     * Devuelve el nº de kilómetros realizados por el vehículo.
     * @author Javier Gómez
     * @return <code><b>kilometros</b></code> Nº de kilómetros realizados por el vehículo.
     * 
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     * 
     * Establece el nº de kilómetros realizados por el vehículo.
     * @author Javier Gómez
     * @param kilometros Nº de kilómetros realizados por el vehículo.
     * 
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * 
     * Devuelve la marca del vehículo.
     * @author Javier Gómez
     * @return <code><b>marca</b></code> Marca del vehículo.
     * 
     */
    public String getMarca() {
        return marca;
    }

    /**
     * 
     * Establece la marca del vehículo.
     * @author Javier Gómez
     * @param marca Marca del vehículo.
     * 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * 
     * Devuelve la matrícula del vehículo.
     * @author Javier Gómez
     * @return <code><b>matricula</b></code> Matrícula del vehículo.
     * 
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * 
     * Establece la matrícula del vehículo.
     * @author Javier Gómez
     * @param matricula Matrícula del vehículo.
     * 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * 
     * Devuelve el precio del vehículo.
     * @author Javier Gómez
     * @return <code><b>precio</b></code> Precio del vehículo.
     * 
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * 
     * Establece el precio del vehículo.
     * @author Javier Gómez
     * @param precio Precio del vehículo.
     * 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * 
     * Devuelve el nombre del propietario del vehículo.
     * @author Javier Gómez
     * @return <code><b>propietario</b></code> Nombre del propietario del vehículo.
     * 
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * 
     * Establece el nombre del propietario del vehículo.
     * @author Javier Gómez
     * @param propietario Nombre del propietario del vehículo.
     * 
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * 
     * Devuelve el número de años de antigüedad del vehículo.
     * @author Javier Gómez
     * @return <code><b>annios</b></code> Nº de años de antigüedad del vehículo.
     * 
     */
    public int getAnnios() {
        // Declara las variables del método
        int annios;
        // Instancia un calendario gregoriano (por defecto con la fecha actual)
        LocalDate hoy = LocalDate.now();
        
        // Calcula la diferencia con la clase Period
        annios = Period.between(this.fechaMatriculacion, 
            hoy).getYears();
        
        // Devuelve la diferencia en años
        return annios;
    }
}
