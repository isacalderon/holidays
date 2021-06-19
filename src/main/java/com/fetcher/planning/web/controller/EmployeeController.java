package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.EmployeeService;
import com.fetcher.planning.domain.service.ManagerService;
import com.fetcher.planning.web.request.DaysAvailableResponse;
import io.swagger.annotations.*;
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
    @ApiOperation("The employee can filter by status pending= 1, rejected = 2, approved= 3")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code= 404, message = "Record not found"),
    })

    public ResponseEntity<List<AskHolidaysDto>> getByStatus( @ApiParam(value = "the id of the employee", required = true,example = "5")
                                                                 @PathVariable("idEmployee") int idEmployee,
                                                             @ApiParam(value = "the status id", required = true, example = "1")
                                                                 @PathVariable("idStatus") int idStatus){
        return employeeService.getByStatus(idStatus, idEmployee)
                .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/request")
    @ApiOperation("Save the request vacation")
    public ResponseEntity<AskHolidaysDto> RequestVacations( @RequestBody AskHolidaysDto askHolidays)
    {
        return employeeService.requestVacations(askHolidays)
                  .map(holidaysDto -> new ResponseEntity<>(holidaysDto, HttpStatus.CREATED))
                   .orElse(new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED));
    }

    @GetMapping("/{idEmployee}/days")
    @ApiOperation("The employee ask the total available days to vacation")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<DaysAvailableResponse> getAvailableDays(@ApiParam(value = "the id of the employee", required = true,example = "5")
                                                                      @PathVariable("idEmployee") int idEmployee){
        return new ResponseEntity<>( employeeService.getVacations(idEmployee), HttpStatus.OK) ;
    }



}
