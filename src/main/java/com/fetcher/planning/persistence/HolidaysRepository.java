package com.fetcher.planning.persistence;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.repository.AskHolidaysRepository;
import com.fetcher.planning.persistence.crud.HolidayRequestCrudRepository;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import com.fetcher.planning.persistence.mapper.AskHolidaysMapper;
import com.sun.tools.jconsole.JConsolePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<AskHolidaysDto> getById(int id)
    {
       return holidayRequestCrudRepository.findById(id).map( holidayRequest -> mapper.toAskHolidays(holidayRequest));
    }

    @Override
    public long countHolidaysRecordByWorker(int idWorker)
    {
        return holidayRequestCrudRepository.countByIdEmployee(idWorker);
    }

    @Override
    public AskHolidaysDto SaveResquest(AskHolidaysDto askHolidays){

        // Validate the total ask for that employee

        HolidayRequest request = mapper.toHolidayResquet(askHolidays);
        request.setIdEmployee(askHolidays.getWorker().getIdAuthor());
        request.setIdStatus(askHolidays.getStatus().getId());
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());

        HolidayRequest resp= holidayRequestCrudRepository.save(request);
        return mapper.toAskHolidays(resp);

    }

    @Override
    public Optional<List<AskHolidaysDto>> findByVacationStartDateGreaterThanEqualAndVacationEndDateLessThanEqual
            (LocalDateTime date1, LocalDateTime date2)
    {
        return  null;
    }

    public void updateStatus(int status, int manager, LocalDateTime dateUpdate, int holidaysId)
    {
         holidayRequestCrudRepository.updateStatus(status, manager, dateUpdate, holidaysId);
    }



}
