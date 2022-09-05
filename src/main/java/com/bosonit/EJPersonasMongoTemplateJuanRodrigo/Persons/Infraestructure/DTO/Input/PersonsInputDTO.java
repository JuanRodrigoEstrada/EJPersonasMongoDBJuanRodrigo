package com.bosonit.EJPersonasMongoTemplateJuanRodrigo.Persons.Infraestructure.DTO.Input;

public record PersonsInputDTO (String id,String user,
        String name,
        String surname,
        String password,
        String company_email,
        String personal_email,
        String city,
        String created_date,
        String termination_date,
        String image_url,
        boolean active,
        long age)
 {



}
