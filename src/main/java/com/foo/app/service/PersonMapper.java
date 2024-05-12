package com.foo.app.service;

import com.foo.app.db.PersonEntity;
import com.foo.app.rest.PersonInDto;
import com.foo.app.rest.PersonOutDto;
import org.mapstruct.*;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Map DTOs to JPA Entities and vice-versa
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonOutDto toDto(PersonEntity entity);

    List<PersonOutDto> toDTOs(Iterable<PersonEntity> entities);


    PersonEntity toEntity(PersonInDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonEntity partialUpdate(PersonInDto dto, @MappingTarget PersonEntity personEntity);
}

