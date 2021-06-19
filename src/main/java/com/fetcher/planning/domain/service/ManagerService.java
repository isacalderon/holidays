package com.fetcher.planning.domain.service;

import com.fetcher.planning.domain.ExceptionsValidations;
import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.repository.EmployeesDomainRepository;
import com.fetcher.planning.persistence.HolidaysRepository;
import com.fetcher.planning.web.request.OverLapRequest;
import com.fetcher.planning.web.request.ValidateResponse;
import com.fetcher.planning.web.request.ManagerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ManagerService {

    @Autowired
    private HolidaysRepository holidaysRepository;

    @Autowired
    private EmployeesDomainRepository employeesRepository;


    public List<AskHolidaysDto> getAll(){

        return holidaysRepository.getAll();
    }

    public Optional<List<AskHolidaysDto>> getByStatus(int status){
        return holidaysRepository.getByStatus(status);
    }

    public  List<AskHolidaysDto> getByWorker(int idWorker){
        return holidaysRepository.getByWorker(idWorker);
    }

    public Optional<?> ResolveHolidays( ManagerRequest request) {

        int idManager= employeesRepository.getEmployee(request.getNameManager(),request.getLastNameManager(), request.getDocumentId());
        holidaysRepository.updateStatus( request.getStatus(), idManager, LocalDateTime.now(), request.getIdHolidays());
        return holidaysRepository.getById(request.getIdHolidays());
    }

    public Optional<List<AskHolidaysDto>> OverlapingHolidays(OverLapRequest overLapRequest){
        LocalDateTime dateStart = LocalDateTime.parse(overLapRequest.getStartDate());
        LocalDateTime dateEnd = LocalDateTime.parse(overLapRequest.getEndDate());
        return holidaysRepository.OverLapVacations(1, dateStart, dateEnd);
    }

    public ValidateResponse validateManagerRequest(ManagerRequest request){

        if(request.getIdHolidays() == 0 )
        {
            return new ValidateResponse(201, "The idHoidays shouldn't be 0");
        }
        if(request.getNameManager() == null || request.getNameManager()== "")
        {
            return new ValidateResponse(201, "The NameManager is required field");
        }
        if(request.getLastNameManager() == null || request.getLastNameManager() == "")
        {
            return new ValidateResponse(201, "The LastNameManager is required field");
        }
       /* Pattern pattern = Pattern.compile("1|2|3");
        Matcher matcher = pattern.matcher(String.valueOf(request.getStatus()));
        if(!matcher.matches())
        {
            return new ValidateResponse(201, "The status must be 1,2 or 3");
        }*/

         return  new ValidateResponse(200, "sucessfull");
    }

}
