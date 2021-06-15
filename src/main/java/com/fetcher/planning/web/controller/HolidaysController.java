package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.AskHolidaysDto;
import com.fetcher.planning.domain.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
