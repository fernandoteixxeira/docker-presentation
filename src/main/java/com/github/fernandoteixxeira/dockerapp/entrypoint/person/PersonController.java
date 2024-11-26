package com.github.fernandoteixxeira.dockerapp.entrypoint.person;

import com.github.fernandoteixxeira.dockerapp.core.person.Person;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonCreatorUseCase;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonGetterByIdUseCase;
import com.github.fernandoteixxeira.dockerapp.core.person.PersonGetterUseCase;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonController {
    PersonCreatorUseCase personCreatorUseCase;
    PersonGetterUseCase personGetterUseCase;
    PersonGetterByIdUseCase personGetterByIdUseCase;

    @PostMapping
    public ResponseEntity<PersonResponse> post(@RequestBody PersonRequest personRequest) {
        Person person = personCreatorUseCase.create(personRequest.toEntity());
        return ResponseEntity.created(URI.create("/person/" + person.id())).build();
    }

    @GetMapping
    public  ResponseEntity<PeopleResponse> get() {
        List<Person> people = personGetterUseCase.get();
        PeopleResponse peopleResponse = PeopleResponse.from(people);
        return ResponseEntity.ok(peopleResponse);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PersonResponse> getById(@PathVariable String id) {
        Person person = personGetterByIdUseCase.getById(id);
        PersonResponse personResponse = PersonResponse.from(person);
        return ResponseEntity.ok(personResponse);
    }
}
