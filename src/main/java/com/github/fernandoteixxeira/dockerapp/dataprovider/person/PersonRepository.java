package com.github.fernandoteixxeira.dockerapp.dataprovider.person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonORM, String> {
}
