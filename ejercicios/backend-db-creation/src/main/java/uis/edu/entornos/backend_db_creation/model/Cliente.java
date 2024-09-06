package uis.edu.entornos.backend_db_creation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull(message = "El campo nombres no puede ser nulo")
    @NotBlank(message = "El campo nombres no puede estar vacío")
    @Size(min = 3, max = 70, message = "El campo nombres debe tener entre 3 y 70 caracteres")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @NotNull(message = "El campo apellidos no puede ser nulo")
    @NotBlank(message = "El campo apellidos no puede estar vacío")
    @Size(min = 3, max = 150, message = "El campo apellidos debe tener entre 3 y 150 caracteres")
    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Size(min = 3, max = 150, message = "El campo dirección debe tener entre 3 y 150 caracteres")
    @Column(name = "direccion", nullable = true, length = 150)
    private String direccion;

    @Size(min = 7, max = 10, message = "El campo teléfono debe tener entre 7 y 10 caracteres")
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;

    @NotNull(message = "El campo email no puede ser nulo")
    @NotBlank(message = "El campo email no puede estar vacío")
    @Size(min = 10, max = 150, message = "El campo email debe tener entre 3 y 150 caracteres")
    @Email(message = "El campo email debe ser una dirección de correo válida")
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    // Getters & Setters

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "}";
    }
    
}
