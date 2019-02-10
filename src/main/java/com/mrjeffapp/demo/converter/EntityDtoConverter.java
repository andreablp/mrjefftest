package com.mrjeffapp.demo.converter;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface EntityDtoConverter<Entity, Dto> {

    /**
     * Convert an entity to dto.
     *
     * @param entity Entity to convert.
     * @return Result of conversion.
     */
    Dto convertToDto(Entity entity);

    /**
     * Convert an dto to entity.
     *
     * @param dto Dto to convert.
     * @return Result of conversion.
     */
    Entity convertToEntity(Dto dto);

    /**
     * Convert an entity collection to dto list.
     *
     * @param entityCollection Collection of entities.
     * @return Result of conversion.
     */
    List<Dto> convertToListDto(Collection<Entity> entityCollection);

    /**
     * Convert an dto list to entity list.
     *
     * @param dtoList List of dtos.
     * @return Result of conversion.
     */
    List<Entity> convertToListEntity(List<Dto> dtoList);

    /**
     * Convert an dto list to entity set.
     *
     * @param dtoList List of dtos.
     * @return Result of conversion.
     */
    Set<Entity> convertToSetEntity(List<Dto> dtoList);
}
