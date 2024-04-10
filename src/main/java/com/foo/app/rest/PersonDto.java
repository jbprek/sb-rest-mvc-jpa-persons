package com.foo.app.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Value
@Builder
@AllArgsConstructor
public class PersonDto {

    Long id;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    @Past
    LocalDate birthDate;
    @NotBlank
    String country;

}
