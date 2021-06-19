package com.fetcher.planning.domain.repository;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AskHolidaysRepository {
    List<AskHolidaysDto> getAll();
    Optional<List<AskHolidaysDto>> getByStatus(int status);
    Optional<List<AskHolidaysDto>> getByStatusAndEmployee(int status, int employee);
    List<AskHolidaysDto> getByWorker(int idWorker);
    Optional<AskHolidaysDto> getById(int id);
    long countHolidaysRecordByWorker(int idWorker);
    AskHolidaysDto SaveResquest(AskHolidaysDto askHolidays);
    Optional<List<AskHolidaysDto>> findByVacationStartDateGreaterThanEqualAndVacationEndDateLessThanEqual(LocalDateTime date1, LocalDateTime date2);

    void updateStatus(int status, int manager, LocalDateTime dateUpdate, int holidaysId);
    int getUsedDays(int idEmployee, int idStatus);
    Optional<List<AskHolidaysDto>>  OverLapVacations(int idStatus, LocalDateTime start, LocalDateTime end);
}
