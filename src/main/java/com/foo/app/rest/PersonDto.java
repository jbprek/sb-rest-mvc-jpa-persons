package com.foo.app.rest;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PersonDto {

    Long id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String country;

}
