package com.fetcher.planning.persistence.crud;

import com.fetcher.planning.persistence.HolidaysRepository;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HolidayRequestCrudRepository extends CrudRepository <HolidayRequest, Integer> {
    Optional<List<HolidayRequest>> findByIdStatus(int idStatus);
    Optional<List<HolidayRequest>> findByIdStatusAndIdEmployee(int idStatus, int idEmployee);
    List<HolidayRequest> findByIdEmployee(int idWorker);
    long countByIdEmployee(int IdEmployee);

    @Transactional
    @Modifying
    @Query("Update HolidayRequest h set h.idStatus= :status, h.resolvedBy= :manager, h.updatedAt= :date where h.id= :idHolidays")
    void updateStatus(@Param(value = "status") int status, @Param(value = "manager") int manager,
                      @Param(value = "date") LocalDateTime dateUpdate, @Param(value = "idHolidays") int idHolidays);

    @Transactional
    @Modifying
    @Query("select sum(h.daysUsed) from HolidayRequest h where h.idEmployee= :idEmployee and h.idStatus= :idStatus")
    int getUsedDays(@Param(value = "idEmployee") int idEmployee, @Param(value = "idStatus") int idStatus);

    @Transactional
    @Modifying
    @Query("select h from HolidayRequest h where h.idStatus= :idStatus and h.vacationStartDate>= :start and h.vacationEndDate<=:end group by h.id, h.vacationStartDate, h.vacationEndDate order by h.id")
    Optional<List<HolidayRequest>>  OverLapVacations(@Param(value = "idStatus") int idStatus,
                                                     @Param(value = "start") LocalDateTime start,
                                                     @Param(value = "end") LocalDateTime end);
    //Optional<List<HolidayRequest>> findAllByIdStatusAndVacationStartDateGreaterThanEqualAndVacationEndDateLessThanEqualGroupBy

}
