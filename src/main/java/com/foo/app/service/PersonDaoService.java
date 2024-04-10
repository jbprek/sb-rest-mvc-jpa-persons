package com.foo.app.service;


import com.foo.app.rest.PersonInDto;
import com.foo.app.rest.PersonOutDto;

import java.util.List;

public interface PersonDaoService {

    public PersonOutDto createPerson(PersonInDto personDto);
    public PersonOutDto getPerson(Long id);
    public List<PersonOutDto> getAll();
    public PersonOutDto updatePerson(Long personId, PersonInDto personDto);
    public void deletePerson(Long id);

}
