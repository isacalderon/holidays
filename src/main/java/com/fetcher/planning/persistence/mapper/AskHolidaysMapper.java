package com.fetcher.planning.persistence.mapper;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class, EmployeeMapper.class})
public interface AskHolidaysMapper {

    @Mappings({
            @Mapping(source = "id", target = "idHolidays"),
            @Mapping(source = "vacationStartDate", target = "startHolidays"),
            @Mapping(source = "vacationEndDate", target = "endHolidays"),
            @Mapping(source = "catStatus", target = "status"),
            @Mapping(source = "userResolved", target = "resolvedBy")
    })
    AskHolidaysDto toAskHolidays(HolidayRequest holidayRequest);
    List<AskHolidaysDto> tosAskHolidaysList (List<HolidayRequest> holidayRequestList);

    @InheritInverseConfiguration
    @Mapping(target = "idEmployee", ignore = true)
    @Mapping(target = "resolvedBy", ignore = true)
    @Mapping(target = "idStatus", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "managerId", ignore = true)
    HolidayRequest toHolidayResquet (AskHolidaysDto askHolidaysDto);

}
