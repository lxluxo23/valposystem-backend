package com.luiscespedes.vaposystem.controllers;

import com.luiscespedes.vaposystem.dtos.PersonDTO;
import com.luiscespedes.vaposystem.models.Person;
import com.luiscespedes.vaposystem.repositories.PersonRepository;
import com.luiscespedes.vaposystem.utils.RutUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private
    PersonRepository personRepository;

    @GetMapping("/person")
    public List<PersonDTO> getPersons() {
        return personRepository.findAll().stream().map(PersonDTO::new).collect(toList());

    }

    @GetMapping("person/{id}")
    public PersonDTO getPersonById(@PathVariable Integer id) {
        return personRepository.findById(id).map(PersonDTO::new).orElse(null);

    }

    @Transactional
    @PostMapping("/person")
    ResponseEntity<?> createPerson(
            @Valid
            @RequestBody
            PersonDTO personDTO,
            BindingResult result
    ) {
        HashMap<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> {
                        return " '" + err.getField() + "': " + err.getDefaultMessage();
                    }).collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (personRepository.findByrutDni(personDTO.getRutDni()) != null) {
            return new ResponseEntity<>("Person already register!", HttpStatus.CONFLICT);
        }
        
        if (!RutUtils.isValidRut(personDTO.getRutDni())) {
            return new ResponseEntity<>("invalid RUT or DNI", HttpStatus.BAD_REQUEST);
        }
        Person p1 = new Person(
                RutUtils.cleanRut(personDTO.getRutDni()),
                personDTO.getNombres(),
                personDTO.getApellidoPaterno(),
                personDTO.getApellidoMaterno(),
                personDTO.getNombreCalle(),
                personDTO.getNumero(),
                personDTO.getRestoDireccion(),
                personDTO.getCorreo(),
                personDTO.getFechaNacimiento()
        );
        personRepository.save(p1);
        return new ResponseEntity<>("Person successfully created.", HttpStatus.CREATED);
    }

    @DeleteMapping("/person/{id}")
    ResponseEntity<Object> deletePerson(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.BAD_REQUEST);
        }
        Person p1 = personRepository.findById(id).orElse(null);
        if (p1 == null) {
            return new ResponseEntity<>("The person does not exist.", HttpStatus.FORBIDDEN);
        }
        personRepository.deleteById(id);
        return new ResponseEntity<>("Person successfully deleted.", HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/person/{id}")
    ResponseEntity<Object> updatePerson(
            @PathVariable Integer id,
            @RequestBody PersonDTO personDTO
    ) {
        if (id == null || personDTO == null) {
            return new ResponseEntity<>("Missing data", HttpStatus.BAD_REQUEST);
        }
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return new ResponseEntity<>("The person does not exist.", HttpStatus.FORBIDDEN);
        }
        if (!RutUtils.isValidRut(personDTO.getRutDni())) {
            return new ResponseEntity<>("invalid RUT or DNI", HttpStatus.BAD_REQUEST);
        }
        if (personDTO.getRutDni() != null) {
            person.setRutDni(RutUtils.cleanRut(personDTO.getRutDni()));
        }
        if (personDTO.getNombres() != null) {
            person.setNombres(personDTO.getNombres());
        }
        if (personDTO.getApellidoPaterno() != null) {
            person.setApellidoPaterno(personDTO.getApellidoPaterno());
        }
        if (personDTO.getApellidoMaterno() != null) {
            person.setApellidoMaterno(personDTO.getApellidoMaterno());
        }
        if (personDTO.getNombreCalle() != null) {
            person.setNombreCalle(personDTO.getNombreCalle());
        }
        if (personDTO.getNumero() != null) {
            person.setNumero(personDTO.getNumero());
        }
        if (personDTO.getRestoDireccion() != null) {
            person.setRestoDireccion(personDTO.getRestoDireccion());
        }
        if (personDTO.getCorreo() != null) {
            person.setCorreo(personDTO.getCorreo());
        }
        if (personDTO.getFechaNacimiento() != null) {
            person.setFechaNacimiento(personDTO.getFechaNacimiento());
        }
        //los if de arriba son por si no se quiere actualizar en su totalidad a la persona

        personRepository.save(person);

        return new ResponseEntity<>("Person successfully updated.", HttpStatus.OK);
    }
}
