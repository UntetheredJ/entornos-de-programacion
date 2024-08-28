package uis.edu.entornos.back_cliente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {
    // Attributes
    public static final String TABLE_NAME = "cliente";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;
    private String documento;
    private String tipdoc;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;

    // Constructors

    public Cliente() {
    }

    public Cliente(int idcliente, String documento, String tipdoc, String nombres, String apellidos, String direccion,
            String email) {
        this.idcliente = idcliente;
        this.documento = documento;
        this.tipdoc = tipdoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
    }

    // Getters and Setters

    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipdoc() {
        return tipdoc;
    }

    public void setTipdoc(String tipodoc) {
        this.tipdoc = tipodoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente {idcliente: " + idcliente + ", documento: " + documento + ", tipdoc: " + tipdoc
                + ", nombres: " + nombres + ", apellidos: " + apellidos + ", direccion: " + direccion + ", email: "
                + email + "}";
    }
}
