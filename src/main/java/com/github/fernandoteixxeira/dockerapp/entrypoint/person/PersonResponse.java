package com.github.fernandoteixxeira.dockerapp.entrypoint.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;

import java.time.LocalDate;

public record PersonResponse(String id, String name, LocalDate birthday) {
    public static PersonResponse from(Person person) {
        return new PersonResponse(person.id(), person.name(), person.birthdate());
    }
}
