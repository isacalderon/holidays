package com.fetcher.planning.persistence.crud;

import com.fetcher.planning.domain.AskHolidaysDto;
import com.fetcher.planning.persistence.entity.HolidayRequest;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface HolidayRequestCrudRepository extends CrudRepository <HolidayRequest, Integer> {
    List<HolidayRequest> findByIdStatus(int idStatus);
    List<HolidayRequest> findByIdEmployee(int idWorker);
}
