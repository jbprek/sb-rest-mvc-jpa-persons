package com.foo.app.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.foo.app.db.PersonEntity}
 */
@AllArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonOutDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String firstName;
    @Size(max = 255)
    private final String lastName;
    private final LocalDate birthDate;
    @Size(max = 255)
    private final String country;
}