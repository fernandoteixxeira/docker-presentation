package com.github.fernandoteixxeira.dockerapp.dataprovider.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("people")
public record PersonORM(@Id String id, String name, LocalDate birthdate) {
    public static PersonORM from(Person person) {
        return new PersonORM(person.id(), person.name(), person.birthdate());
    }

    public Person toEntity() {
        return new Person(id, name, birthdate);
    }
}
