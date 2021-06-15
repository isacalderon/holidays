package com.fetcher.planning.persistence;

import com.fetcher.planning.domain.AskHolidaysDto;
import com.fetcher.planning.domain.repository.AskHolidaysRepository;
import com.fetcher.planning.persistence.crud.HolidayRequestCrudRepository;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import com.fetcher.planning.persistence.mapper.AskHolidaysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepository implements AskHolidaysRepository {
    @Autowired
    private HolidayRequestCrudRepository holidayRequestCrudRepository;

    @Autowired
    private AskHolidaysMapper mapper;

    @Override
    public List <AskHolidaysDto> getAll()
    {
        List<HolidayRequest> holidays = (List<HolidayRequest>) holidayRequestCrudRepository.findAll();
        return mapper.tosAskHolidaysList(holidays);
    }

   // public List <HolidayRequest> getByStatus()
    //{
     //   return holidayRequestCrudRepository.
   // }


}
