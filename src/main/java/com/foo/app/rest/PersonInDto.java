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
public class PersonInDto {

    @NotBlank(groups = PersonCreateValidation.class)
    String firstName;
    @NotBlank(groups = PersonCreateValidation.class)
    String lastName;
    @NotNull(groups = PersonCreateValidation.class)
    @Past
    LocalDate birthDate;
    @NotBlank(groups = PersonCreateValidation.class)
    String country;

}
