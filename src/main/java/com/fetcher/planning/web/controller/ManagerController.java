package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.ExceptionsValidations;
import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.ManagerService;
import com.fetcher.planning.web.request.ManagerRequest;
import com.fetcher.planning.web.request.OverLapRequest;
import com.fetcher.planning.web.request.ValidateResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/all")
    @ApiOperation("get all the values")
    public List<AskHolidaysDto> getAll(){
        return managerService.getAll();
    }

    @GetMapping("/all/status/{idStatus}")
    @ApiOperation("Get the records filter by status")
    public ResponseEntity<List<AskHolidaysDto>> getByStatus( @ApiParam(value = "the status id", required = true, example = "1")
                                                                 @PathVariable("idStatus") int idStatus){
        return managerService.getByStatus(idStatus)
                .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employee/{id}")
    @ApiOperation("Get an overview by employee")
    @ApiParam(value = "the id of the employee", required = true,example = "5")
    public List<AskHolidaysDto> getByWorker(@PathVariable("id") int id){
        return managerService.getByWorker(id);
    }


    @PutMapping(value = "/resolve")
    @ApiOperation("Acepted or Reject the Holiday request")
    public ResponseEntity<?> ResolveHolidayRequest(@RequestBody ManagerRequest managerRequest) {
         // Validate the manager Request
        ValidateResponse validate= managerService.validateManagerRequest(managerRequest);
         if( validate.getCode() != 200){
             return new ResponseEntity<>(validate, HttpStatus.BAD_REQUEST);
         }

         return managerService.ResolveHolidays(managerRequest)
                     .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.ACCEPTED))
                     .orElse(new ResponseEntity(HttpStatus.FAILED_DEPENDENCY));

    }

    @PostMapping(value = "/overlap")
    @ApiOperation("Get the overlaping request to holidays")
    public  ResponseEntity<List<AskHolidaysDto>> OverlapingHolidays(@RequestBody OverLapRequest overlap)
    {
        return managerService.OverlapingHolidays(overlap)
                .map(askHolidaysList -> new ResponseEntity<>(askHolidaysList, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
