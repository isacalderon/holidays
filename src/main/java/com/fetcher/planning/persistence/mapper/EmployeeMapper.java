package com.fetcher.planning.persistence.mapper;

import com.fetcher.planning.domain.dto.EmployeesDto;
import com.fetcher.planning.domain.dto.StatusDto;
import com.fetcher.planning.persistence.entity.CatStatus;
import com.fetcher.planning.persistence.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeesDto toEmployeesDto(Employee employee);

    @InheritInverseConfiguration
    @Mapping(target= "deparment", ignore = true)
    @Mapping(target= "dateHiring", ignore = true)
    @Mapping(target= "documentId", ignore = true)
    @Mapping(target= "position", ignore = true)
    Employee toEmployee(EmployeesDto employeesDto);
}
