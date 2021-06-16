package com.fetcher.planning.persistence.mapper;

import com.fetcher.planning.domain.AskHolidaysDto;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class})
public interface AskHolidaysMapper {

    @Mappings({
            @Mapping(source = "resolvedBy", target = "resolved"),
            @Mapping(source = "vacationStartDate", target = "startHolidays"),
            @Mapping(source = "vacationEndDate", target = "endHolidays"),
            @Mapping(source = "managerId", target = "manager"),
            @Mapping(source = "catStatus", target = "status")
    })
    AskHolidaysDto toAskHolidays(HolidayRequest holidayRequest);
    List<AskHolidaysDto> tosAskHolidaysList (List<HolidayRequest> holidayRequestList);

    @InheritInverseConfiguration
    @Mapping(target = "idEmployee", ignore = true)
    @Mapping(target = "idStatus", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    HolidayRequest toHolidayResquet (AskHolidaysDto askHolidaysDto);

}
