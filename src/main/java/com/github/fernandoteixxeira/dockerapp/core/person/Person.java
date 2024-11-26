package com.github.fernandoteixxeira.dockerapp.core.person;

import java.time.LocalDate;

public record Person(String id, String name, LocalDate birthdate) {
}
