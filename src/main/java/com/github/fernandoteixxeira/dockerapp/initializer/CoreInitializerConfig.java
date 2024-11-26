package com.github.fernandoteixxeira.dockerapp.initializer;

import com.github.fernandoteixxeira.dockerapp.core.person.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInitializerConfig {
    @Bean
    public PersonCreatorUseCase personCreatorUseCase(PersonCreatorPort personCreatorPort) {
        return new PersonCreatorUseCase(personCreatorPort);
    }

    @Bean
    public PersonGetterUseCase personGetterUseCase(PersonGetterPort personGetterPort) {
        return new PersonGetterUseCase(personGetterPort);
    }

    @Bean
    public PersonGetterByIdUseCase personGetterByIdUseCase(PersonGetterByIdPort personGetterByIdPort) {
        return new PersonGetterByIdUseCase(personGetterByIdPort);
    }
}
