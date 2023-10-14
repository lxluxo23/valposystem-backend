package com.luiscespedes.vaposystem.dtos;

import com.luiscespedes.vaposystem.models.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class PersonDTO {
    private Integer id;
    private String rutDni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreCalle;
    private Integer numero;
    private String restoDireccion;
    private String correo;
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
