package com.foo.app.service;

import com.foo.app.db.PersonEntity;
import com.foo.app.rest.PersonDto;
import org.mapstruct.*;

import java.util.List;

/**
 * Map DTOs to JPA Entities and vice-versa
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto entityToDTO(PersonEntity project);

    List<PersonDto> entityToDTO(Iterable<PersonEntity> project);

    @Mapping(target = "id", ignore = true)
    PersonEntity  dtoToEntity(PersonDto source);

    /**
     * Copy all non-null values from PersonDto source to PersonEntity target ('id' excluded)
     * As of MapStruct 1.5.5 there is no way to copy only non-null source fields to target
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void dtoToEntity(PersonDto source, @MappingTarget PersonEntity target);

}

