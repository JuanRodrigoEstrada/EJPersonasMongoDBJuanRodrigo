package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Input.PersonsInputDTO;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output.PersonsOutputDTO;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.Repository.jpa.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsService implements PersonsInterface{
@Autowired
    PersonsRepository personsRepository;
@Override
    public PersonsOutputDTO savePerson (PersonsInputDTO personsInputDTO){
    PersonsEntity personsEntity = new PersonsEntity(personsInputDTO);
    personsRepository.save(personsEntity);
    return personsEntity.toPersonsOutputDTO(personsEntity);
}
@Override
    public List <PersonsOutputDTO>listPerson(){
    List<PersonsEntity>list = personsRepository.findAll();
    return list.stream().map(n->n.toPersonsOutputDTO(n)).toList();

    }
    @Override
    public PersonsOutputDTO deletePersonbyId(String id)throws Exception{
    PersonsEntity personsEntity = personsRepository.findById(id).orElseThrow(()->new Exception("Id no localizada"));
    personsRepository.deleteById(id);
    return personsEntity.toPersonsOutputDTO(personsEntity);

    }
    @Override
    public  PersonsOutputDTO modifyPersonsbyId(String id, PersonsInputDTO personsInputDTO) throws Exception{
    personsRepository.findById(id).orElseThrow(()->new Exception("id no encontrada"));
    PersonsEntity personsEntity = new PersonsEntity(personsInputDTO);
    personsEntity.setId(id);
    return personsEntity.toPersonsOutputDTO(personsRepository.save(personsEntity));

    }
    @Override
    public PersonsOutputDTO searchPersonsbyId (String id )throws Exception{
    PersonsEntity personsEntity = personsRepository.findById(id).orElseThrow(()->new Exception ("Persona no encontrada por id")) ;
    return personsEntity.toPersonsOutputDTO (personsEntity);

}

    @Override
    public PersonsOutputDTO createPerson(PersonsInputDTO personsInputDTO) throws Exception {
        PersonsEntity personsEntity = new PersonsEntity(personsInputDTO);
        personsRepository.save(personsEntity);
        return personsEntity.toPersonsOutputDTO(personsEntity);
    }


}
