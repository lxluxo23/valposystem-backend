package com.luiscespedes.vaposystem.repositories;

import com.luiscespedes.vaposystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person rutDni(String rutDni);
}
