package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Input.PersonsInputDTO;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output.PersonsOutputDTO;

import java.util.List;

public interface PersonsInterface {
    PersonsOutputDTO savePerson (PersonsInputDTO personsInputDTO);
    List<PersonsOutputDTO>listPerson();

    PersonsOutputDTO deletePersonbyId(String id)throws Exception;

    PersonsOutputDTO modifyPersonsbyId(String id, PersonsInputDTO personsInputDTO) throws Exception;

    PersonsOutputDTO searchPersonsbyId(String id)throws Exception;

    PersonsOutputDTO createPerson(PersonsInputDTO personsInputDTO)throws Exception;
}
