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
    PersonOutDto entityToDTO(PersonEntity project);
    List<PersonOutDto> entitiesToDTOs(Iterable<PersonEntity> project);
    /**
     * DTO to Entity ignores DTO.id field
     */
    @Mapping(target = "id", ignore = true)
    PersonEntity dtoToEntity(PersonInDto source);
    /**
     * Copy all non-null values from PersonDto source to PersonEntity target ('id' excluded)
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PersonInDto source, @MappingTarget @NonNull PersonEntity target);

}

