package com.fetcher.planning.persistence.crud;

import com.fetcher.planning.persistence.HolidaysRepository;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HolidayRequestCrudRepository extends CrudRepository <HolidayRequest, Integer> {
    List<HolidayRequest> findByIdStatus(int idStatus);
    List<HolidayRequest> findByIdEmployee(int idWorker);
    long countByIdEmployee(int IdEmployee);

    Optional<List<HolidayRequest>> findByVacationStartDateGreaterThanEqualAndVacationEndDateLessThanEqual(LocalDateTime date1, LocalDateTime date2);

    @Transactional
    @Modifying
    @Query("Update HolidayRequest h set h.idStatus= :status, h.resolvedBy= :manager, h.updatedAt= :date where h.id= :idHolidays")
    void updateStatus(@Param(value = "status") int status, @Param(value = "manager") int manager,
                      @Param(value = "date") LocalDateTime dateUpdate, @Param(value = "idHolidays") int idHolidays);
}
