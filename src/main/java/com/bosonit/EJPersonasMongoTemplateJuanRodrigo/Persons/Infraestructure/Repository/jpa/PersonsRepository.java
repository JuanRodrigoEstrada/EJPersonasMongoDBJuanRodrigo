package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.Repository.jpa;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain.PersonsEntity;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output.PersonsOutputDTO;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public interface PersonsRepository extends MongoRepository<PersonsEntity,String> {

    List <PersonsEntity> findByName (String name);
    PersonsEntity getPersonById ( String id);

    void deleteById(String id);

    Optional<PersonsEntity> findById(String id);
}

