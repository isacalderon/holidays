package com.fetcher.planning.domain.repository;

import com.fetcher.planning.domain.AskHolidaysDto;

import java.util.List;

public interface AskHolidaysRepository {
    List<AskHolidaysDto> getAll();
}
