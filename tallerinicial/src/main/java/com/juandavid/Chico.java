package com.juandavid;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author Juan Escalante
 */
public class Chico {

    // Instance variables
    @CsvBindByPosition(position = 0)
    private Integer codigo;
    @CsvBindByPosition(position = 1)
    private String sexo;
    @CsvBindByPosition(position = 2)
    private String nombre;
    @CsvBindByPosition(position = 3)
    private Integer edad;
    @CsvBindByPosition(position = 4)
    private Integer ciudad;

    // Empty constructor
    public Chico() {
    }

    // Constructor
    public Chico(Integer codigo, String sexo, String nombre, Integer edad, Integer ciudad) {
        this.codigo = codigo;
        this.sexo = sexo;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters & Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString(){
        // Setup sexoDisplay for printing the corresponding sexo
        String sexoDisplay = "";
        if (sexo.equals("F")){
            sexoDisplay = "Femenino";
        } else if (sexo.equals("M")){
            sexoDisplay = "Masculino";
        }

        // Setup ciudadDisplay for printing the corresponding ciudad
        String ciudadDisplay;
        switch (ciudad) {
            case 1 -> ciudadDisplay = "Bucaramanga";
            case 2 -> ciudadDisplay = "Girón";
            case 3 -> ciudadDisplay = "Floridablanca";
            case 4 -> ciudadDisplay = "Piedecuesta";
            default -> ciudadDisplay = "null";
        }

        return "Chico{"
        + "codigo: " + codigo
        + ", sexo: " + sexoDisplay
        + ", nombre: " + nombre
        + ", edad: " + edad
        + ", ciudad: " + ciudadDisplay
        + "}";
    }
}
