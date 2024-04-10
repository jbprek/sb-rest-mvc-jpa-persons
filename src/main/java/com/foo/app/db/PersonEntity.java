package com.foo.app.db;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;

}