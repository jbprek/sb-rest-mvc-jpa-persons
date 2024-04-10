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

    @NotBlank(groups = OnCreateValidation.class)
    String firstName;
    @NotBlank(groups = OnCreateValidation.class)
    String lastName;
    @NotNull(groups = OnCreateValidation.class)
    @Past(groups = {OnCreateValidation.class, OnUpdateValidation.class})
    LocalDate birthDate;
    @NotBlank(groups = OnCreateValidation.class)
    String country;

}
