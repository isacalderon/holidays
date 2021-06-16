package com.fetcher.planning.persistence.mapper;

import com.fetcher.planning.domain.dto.StatusDto;
import com.fetcher.planning.persistence.entity.CatStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    @Mappings({
            @Mapping(source="description", target="status")
    })
    StatusDto toStatus(CatStatus catStatus);

    @InheritInverseConfiguration
    //@Mapping(target= "holidaysRequests", ignore = true)
    CatStatus toCatStatus(StatusDto status);
}
