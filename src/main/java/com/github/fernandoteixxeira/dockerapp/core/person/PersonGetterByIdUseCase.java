package com.github.fernandoteixxeira.dockerapp.core.person;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonGetterByIdUseCase {
    PersonGetterByIdPort personGetterByIdPort;

    public Person getById(String id) {
        return personGetterByIdPort.getById(id);
    }
}
