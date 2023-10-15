package com.luiscespedes.vaposystem;

import com.luiscespedes.vaposystem.models.Person;
import com.luiscespedes.vaposystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class VaposystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(VaposystemApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(
			PersonRepository personRepository

	) {
		return (args) -> {
			Person person1 = new Person();
			person1.setRutDni("111111111");
			person1.setNombres("Juan");
			person1.setApellidoPaterno("Pérez");
			person1.setApellidoMaterno("González");
			person1.setNombreCalle("Calle Principal");
			person1.setNumero(123);
			person1.setRestoDireccion("Dpto. 4");
			person1.setCorreo("juan.perez@gmail.com");
			person1.setFechaNacimiento(LocalDate.of(1990, 1, 1));

			Person person2 = new Person();
			person2.setRutDni("490593837");
			person2.setNombres("María");
			person2.setApellidoPaterno("González");
			person2.setApellidoMaterno("López");
			person2.setNombreCalle("Calle Secundaria");
			person2.setNumero(456);
			person2.setRestoDireccion("Piso 2");
			person2.setCorreo("maria.gonzalez@gmail.com");
			person2.setFechaNacimiento(LocalDate.of(1995, 2, 2));

			Person person3 = new Person();
			person3.setRutDni("895614270");
			person3.setNombres("Pedro");
			person3.setApellidoPaterno("López");
			person3.setApellidoMaterno("Sánchez");
			person3.setNombreCalle("Calle Terciaria");
			person3.setNumero(789);
			person3.setRestoDireccion("Casa 10");
			person3.setCorreo("pedro.lopez@gmail.com");
			person3.setFechaNacimiento(LocalDate.of(2000, 3, 3));


			personRepository.save(person1);
			personRepository.save(person2);
			personRepository.save(person3);

		};
	}

}
