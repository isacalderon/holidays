package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.EmployeeService;
import com.fetcher.planning.domain.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{idEmployee}/status/{idStatus}")
    public ResponseEntity<List<AskHolidaysDto>> getByStatus(@PathVariable("idEmployee") int idEmployee, @PathVariable("idStatus") int idStatus){
        return employeeService.getByStatus(idStatus, idEmployee)
                .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/request")
    public ResponseEntity<AskHolidaysDto> RequestVacations( @Valid @RequestBody AskHolidaysDto askHolidays)
    {
        return new ResponseEntity<>(employeeService.requestVacations(askHolidays), HttpStatus.OK);
    }



}
