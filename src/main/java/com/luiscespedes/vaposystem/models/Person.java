package com.luiscespedes.vaposystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Person(String rutDni, String nombres, String apellidoPaterno, String apellidoMaterno, String nombreCalle, Integer numero, String restoDireccion, String correo, LocalDate fechaNacimiento) {
        this.rutDni = rutDni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.restoDireccion = restoDireccion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String GetFullName(){
        return this.getNombres() + " " + this.getApellidoPaterno()+ " " +this.getApellidoMaterno();
    }
}
