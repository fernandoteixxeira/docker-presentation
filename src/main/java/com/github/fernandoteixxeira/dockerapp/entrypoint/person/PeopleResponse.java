package com.github.fernandoteixxeira.dockerapp.entrypoint.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;

import java.util.List;

public record PeopleResponse(List<PersonResponse> people) {
    public static PeopleResponse from(List<Person> people) {
        List<PersonResponse> listOfPeople = people.stream()
                .map(person -> new PersonResponse(person.id(), person.name(), person.birthdate()))
                .toList();
        return new PeopleResponse(listOfPeople);
    }
}
