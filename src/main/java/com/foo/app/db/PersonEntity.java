package com.foo.app.db;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONS")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Size(max = 255)
    @Column(name = "COUNTRY")
    private String country;

    @Version
    private Long version;

}