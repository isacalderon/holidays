package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {
    @Autowired
    private HolidaysService holidaysService;

    @GetMapping("/all")
    public List<AskHolidaysDto> getAll(){
        return holidaysService.getAll();
    }

    @GetMapping("/status")
    public List<AskHolidaysDto> getByStatus(@RequestParam int id){
        return holidaysService.getByStatus(id);
    }

    @GetMapping("/employee/{id}")
    public List<AskHolidaysDto> getByWorker(@PathVariable("id") int id){
        return holidaysService.getByWorker(id);
    }

    @PostMapping("/request")
    public AskHolidaysDto RequestVacations( @RequestBody AskHolidaysDto askHolidays)
    {
         return holidaysService.requestVacations(askHolidays);
    }

}
