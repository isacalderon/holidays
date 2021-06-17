package com.fetcher.planning.domain.repository;

import com.fetcher.planning.domain.dto.AskHolidaysDto;

import java.util.List;
import java.util.Optional;

public interface AskHolidaysRepository {
    List<AskHolidaysDto> getAll();
    List<AskHolidaysDto> getByStatus(int status);
    List<AskHolidaysDto> getByWorker(int idWorker);
    AskHolidaysDto SaveResquest(AskHolidaysDto askHolidays);
}
