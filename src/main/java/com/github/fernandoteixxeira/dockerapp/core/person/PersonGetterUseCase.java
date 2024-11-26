package com.github.fernandoteixxeira.dockerapp.core.person;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonGetterUseCase {
    PersonGetterPort personGetterPort;

    public List<Person> get() {
        return personGetterPort.get();
    }
}
