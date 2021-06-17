package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.HolidaysService;
import com.fetcher.planning.web.request.ErrorResponse;
import com.fetcher.planning.web.request.ManagerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<AskHolidaysDto> RequestVacations( @Valid @RequestBody AskHolidaysDto askHolidays)
    {
         return new ResponseEntity<>(holidaysService.requestVacations(askHolidays), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

   // @PutMapping("/manager/resolve")
    //public ResponseEntity<ErrorResponse> ResolveHolidayRequest(@RequestBody ManagerRequest managerRequest)
   // {
    //}

}
