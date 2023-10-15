package com.luiscespedes.vaposystem.dtos;

import com.luiscespedes.vaposystem.models.Person;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class PersonDTO {
    private Integer id;
    @NotNull(message = "this value cannot be null")
    private String rutDni;
    @NotNull(message = "this value cannot be null")
    private String nombres;
    @NotNull(message = "this value cannot be null")
    private String apellidoPaterno;
    @NotNull(message = "this value cannot be null")
    private String apellidoMaterno;
    @NotNull(message = "this value cannot be null")
    private String nombreCalle;
    @NotNull(message = "this value cannot be null")
    private Integer numero;
    @NotNull(message = "this value cannot be null")
    private String restoDireccion;
    @NotNull(message = "this value cannot be null")
    @Email (message = "this value needs to be of type email")
    private String correo;
    @NotNull(message = "this value cannot be null")
    private LocalDate fechaNacimiento;

    public PersonDTO(Person person){
        this.id = person.getId();
        this.rutDni = person.getRutDni();
        this.nombres = person.getNombres();
        this.apellidoPaterno = person.getApellidoPaterno();
        this.apellidoMaterno = person.getApellidoMaterno();
        this.nombreCalle = person.getNombreCalle();
        this.numero = person.getNumero();
        this.restoDireccion = person.getRestoDireccion();
        this.correo = person.getCorreo();
        this.fechaNacimiento = person.getFechaNacimiento();
    }

    public PersonDTO() {
    }
}
