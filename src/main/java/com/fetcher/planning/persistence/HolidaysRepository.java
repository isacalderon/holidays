package com.fetcher.planning.persistence;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
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

    @Override
    public List <AskHolidaysDto> getByStatus(int status)
    {
        List<HolidayRequest> holidays = (List<HolidayRequest>) holidayRequestCrudRepository.findByIdStatus(status);
        return mapper.tosAskHolidaysList(holidays);
    }

    @Override
    public List<AskHolidaysDto> getByWorker(int idWorker)
    {
        List<HolidayRequest> holidays = (List<HolidayRequest>) holidayRequestCrudRepository.findByIdEmployee(idWorker);
        return mapper.tosAskHolidaysList(holidays);
    }



}
