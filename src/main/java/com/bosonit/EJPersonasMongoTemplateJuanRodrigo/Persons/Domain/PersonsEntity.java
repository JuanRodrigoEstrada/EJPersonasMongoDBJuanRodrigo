package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Input.PersonsInputDTO;
import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output.PersonsOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonsEntity {
    @Id
    private String id;
    private long age;
    private String name;
    private String surname;
    private String password;
    private String company_email;
    private String personal_email;
    private String city;
    private String created_date;
    private String termination_date;
    private String image_url;
    private boolean active;
    private String user;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public PersonsEntity(PersonsInputDTO personsInputDTO){
        if (personsInputDTO == null)
            return;

        user = personsInputDTO.user();
        password = personsInputDTO.password();
        name = personsInputDTO.name();
        surname = personsInputDTO.surname();
        company_email = personsInputDTO.company_email();
        personal_email = personsInputDTO.personal_email();
        city = personsInputDTO.city();
        active = personsInputDTO.active();
        created_date = personsInputDTO.created_date();
        image_url = personsInputDTO.image_url();
        age = personsInputDTO.age();
    }

    public void updateEntity(PersonsInputDTO personsInputDTO){
        setUser(personsInputDTO.user());
        setPassword(personsInputDTO.password());
        setName(personsInputDTO.name());
        setSurname(personsInputDTO.surname());
        setCompany_email(personsInputDTO.company_email());
        setPersonal_email(personsInputDTO.personal_email());
        setCity(personsInputDTO.city());
        setActive(personsInputDTO.active());
        setCreated_date(personsInputDTO.created_date());
        setImage_url(personsInputDTO.image_url());
        setAge(personsInputDTO.age());
    }


    public PersonsOutputDTO toPersonsOutputDTO(PersonsEntity personsEntity) {
        return new PersonsOutputDTO(personsEntity.getId(),personsEntity.getName(),personsEntity.getSurname(),personsEntity.getCompany_email(),
                personsEntity.getPersonal_email(),personsEntity.getCity(),personsEntity.getCreated_date(),personsEntity.getTermination_date(),personsEntity.getImage_url(),personsEntity.isActive(),personsEntity.getAge());
    }
}




