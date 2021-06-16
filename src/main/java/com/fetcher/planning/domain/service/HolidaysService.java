package com.fetcher.planning.domain.service;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.persistence.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidaysService {

    @Autowired
    private HolidaysRepository holidaysRepository;

    public List<AskHolidaysDto> getAll(){

        return holidaysRepository.getAll();
    }

    public List<AskHolidaysDto> getByStatus(int status){
        return holidaysRepository.getByStatus(status);
    }

    public  List<AskHolidaysDto> getByWorker(int idWorker){
        return holidaysRepository.getByWorker(idWorker);
    }
}
