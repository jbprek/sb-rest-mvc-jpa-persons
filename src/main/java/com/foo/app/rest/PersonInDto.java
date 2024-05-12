package com.foo.app.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.foo.app.db.PersonEntity}
 */
@Builder
@AllArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonInDto implements Serializable {
    @Size(max = 255)
    private final String firstName;
    @Size(max = 255)
    private final String lastName;
    private final LocalDate birthDate;
    @Size(max = 255)
    private final String country;
}