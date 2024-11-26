package com.github.fernandoteixxeira.dockerapp.core.person;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonCreatorUseCase {
    PersonCreatorPort personCreatorPort;

    public Person create(Person person) {
        return personCreatorPort.create(person);
    }
}
