package com.mrjeffapp.demo.converter;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseEntityDtoConverter<Entity, Dto> implements EntityDtoConverter<Entity, Dto>{

    private final Class<Entity> entityClass;
    private final Class<Dto> dtoClass;
    protected ModelMapper modelMapper;

    public BaseEntityDtoConverter(Class<Entity> entityClass, Class<Dto> dtoClass){
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;

        this.modelMapper = new ModelMapper();
    }

    @Override
    public Dto convertToDto(Entity entity) {

        if (entity == null)
            return null;

        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public Entity convertToEntity(Dto dto) {

        if (dto == null)
            return null;

        return modelMapper.map(dto, entityClass);
    }

    @Override
    public List<Dto> convertToListDto(Collection<Entity> entityCollection) {

        if (entityCollection == null)
            return Collections.emptyList();

        return entityCollection
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<Entity> convertToListEntity(List<Dto> dtoList) {

        if (dtoList == null) return Collections.emptyList();

        return dtoList
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Entity> convertToSetEntity(List<Dto> dtoSet) {

        if (dtoSet == null) return Collections.emptySet();

        return dtoSet
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());

    }
}
