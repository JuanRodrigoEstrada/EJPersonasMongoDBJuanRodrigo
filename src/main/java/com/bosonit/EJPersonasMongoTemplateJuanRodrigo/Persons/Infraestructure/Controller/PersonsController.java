package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.Controller;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain.PersonsService;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Input.PersonsInputDTO;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output.PersonsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonsController {

    @Autowired
    PersonsService personsService;


    @GetMapping("/person")
    public PersonsOutputDTO savePerson(@RequestBody PersonsInputDTO personsInputDTO) {
        return personsService.savePerson(personsInputDTO);
    }

    @GetMapping("/person/list")
    public List<PersonsOutputDTO> returnAllpersons() {
        return personsService.listPerson();
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<PersonsOutputDTO> deletebyId(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personsService.deletePersonbyId(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
        @PutMapping("/person/{id}")
        public ResponseEntity<PersonsOutputDTO> modifyPersonsbyId (@PathVariable String id, @RequestBody PersonsInputDTO
        personsInputDTO) {
            try {
                return new ResponseEntity<>(personsService.modifyPersonsbyId(id, personsInputDTO), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            }
        }
            @GetMapping("/person/{id}")
            public ResponseEntity<?> searchPersonsbyId (@PathVariable String id){
                try {
                    return new ResponseEntity<>(personsService.searchPersonsbyId(id), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>("no se encuentra el id", HttpStatus.NOT_FOUND);
                }


    }
    @PostMapping("/person/create")
    public ResponseEntity<PersonsOutputDTO>createPerson(@RequestBody PersonsInputDTO personsInputDTO){
        try{
            return new ResponseEntity<>(personsService.createPerson(personsInputDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}


