package com.fetcher.planning.domain.service;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.repository.EmployeesDomainRepository;
import com.fetcher.planning.persistence.HolidaysRepository;
import com.fetcher.planning.web.request.DaysAvailableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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

    public Optional<AskHolidaysDto> requestVacations(AskHolidaysDto holidays) {

        long total= countByIdEmployee(holidays.getAuthor().getId());
        DaysAvailableResponse daysResponse = getVacations(holidays.getAuthor().getId());

        if(total < 30 && daysResponse.getAvailableDays() > 0)
        {
            Period period = Period.between( holidays.getStartHolidays().toLocalDate(), holidays.getEndHolidays().toLocalDate());
            int totalDays = Math.abs(period.getDays());
            holidays.setDaysToUse(totalDays);
           if(daysResponse.getAvailableDays()>= totalDays) {
               return Optional.of(holidaysRepository.SaveResquest(holidays));
           }
        }
         return Optional.empty();
    }

    public DaysAvailableResponse getVacations(int idEmployee)
    {
        LocalDate now = LocalDate.now();
        LocalDate dateHiring= employeesRepository.findById(idEmployee).getDateHiring().toLocalDate();
        Period period = Period.between(now, dateHiring);
        long totalDays = Math.abs(period.getMonths());
        // idStatus= acepted to count in daysUsed
        Optional<List<AskHolidaysDto>> listholidays= holidaysRepository.getByStatusAndEmployee(3, idEmployee);

        int daysUsed= listholidays.get().stream().mapToInt(AskHolidaysDto::getDaysToUse).sum();

        DaysAvailableResponse response= new DaysAvailableResponse();
        response.setAvailableDays(totalDays-daysUsed);
        response.setUsedDays(daysUsed);
        response.setDateResponse(now);

        return response;
    }


}
