package com.github.fernandoteixxeira.dockerapp.dataprovider.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonCreatorPort;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonGetterByIdPort;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonGetterPort;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonDataProvider implements PersonCreatorPort, PersonGetterPort, PersonGetterByIdPort {
    PersonRepository personRepository;

    @Override
    @Transactional
    public Person create(Person person) {
        PersonORM from = PersonORM.from(person);
        PersonORM perssonOrm = personRepository.save(from);
        return perssonOrm.toEntity();
    }

    @Override
    public Person getById(String id) {
        return personRepository.findById(id)
                .map(PersonORM::toEntity)
                .orElse(null);
    }

    @Override
    public List<Person> get() {
        return personRepository.findAll().stream()
                .map(PersonORM::toEntity)
                .toList();
    }
}
