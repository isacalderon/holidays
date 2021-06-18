package com.fetcher.planning.domain.service;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.repository.EmployeesDomainRepository;
import com.fetcher.planning.persistence.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private HolidaysRepository holidaysRepository;

    @Autowired
    private EmployeesDomainRepository employeesRepository;

    public Optional<List<AskHolidaysDto>> getByStatus(int status, int employee){
        return holidaysRepository.getByStatusAndEmployee(status, employee);
    }

    private long countByIdEmployee(int idWorker) {

        return holidaysRepository.countHolidaysRecordByWorker(idWorker);
    }

    public AskHolidaysDto requestVacations(AskHolidaysDto holidays) {

        long total= countByIdEmployee(holidays.getAuthor().getId());
        if(total < 30)
        {
            return holidaysRepository.SaveResquest(holidays);
        }

        return null;

    }
}
