package com.fetcher.planning.domain.service;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.dto.StatusDto;
import com.fetcher.planning.domain.repository.EmployeesDomainRepository;
import com.fetcher.planning.persistence.HolidaysRepository;
import com.fetcher.planning.web.request.ManagerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

   // private long countByIdEmployee(int idWorker) {

     //   return holidaysRepository.countHolidaysRecordByWorker(idWorker);
    //}

    //public AskHolidaysDto requestVacations(AskHolidaysDto holidays) {

      //    long total= countByIdEmployee(holidays.getAuthor().getId());
        //  if(total < 30)
         // {
          //    return holidaysRepository.SaveResquest(holidays);
          //}

         // return null;

   // }

    public Optional<AskHolidaysDto> ResolveHolidays(ManagerRequest request) {

        // buscar el manager
        int idManager= employeesRepository.getEmployee(request.getNameManager(),request.getLastNameManager(), request.getDocumentId() );
        try {
            holidaysRepository.updateStatus( request.getStatus(), idManager, LocalDateTime.now(), request.getIdHolidays());
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        return holidaysRepository.getById(request.getIdHolidays());

    }
}
