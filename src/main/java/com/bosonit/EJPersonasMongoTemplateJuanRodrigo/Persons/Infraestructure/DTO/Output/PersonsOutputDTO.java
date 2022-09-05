package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Output;

import com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Domain.PersonsEntity;

public record PersonsOutputDTO (String id,String user,
                                String name,
                                String surname,
                                String company_email,
                                String personal_email,
                                String city,
                                String created_date,
                                String termination_date,
                                boolean active ,
                                long age) {
    public PersonsOutputDTO(PersonsEntity personsEntity) {
        this(
                personsEntity.getId(),
                personsEntity.getUser(),
                personsEntity.getName(),
                personsEntity.getSurname(),
                personsEntity.getCompany_email(),
                personsEntity.getPersonal_email(),
                personsEntity.getCity(),
                personsEntity.getCreated_date(),
                personsEntity.getTermination_date(),
                personsEntity.isActive(),
                personsEntity.getAge()

        );
    }
}



