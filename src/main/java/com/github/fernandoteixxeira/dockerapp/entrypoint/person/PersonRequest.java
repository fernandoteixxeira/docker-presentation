package com.github.fernandoteixxeira.dockerapp.entrypoint.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;

import java.time.LocalDate;

public record PersonRequest(String name, LocalDate birthdate) {
    public Person toEntity() {
        return new Person(null, name, birthdate);
    }
}
