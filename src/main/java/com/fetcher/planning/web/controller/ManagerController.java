package com.fetcher.planning.web.controller;

import com.fetcher.planning.domain.dto.AskHolidaysDto;
import com.fetcher.planning.domain.service.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/all")
    public List<AskHolidaysDto> getAll(){
        return managerService.getAll();
    }

    @GetMapping("/all/status/{idStatus}")
    public ResponseEntity<List<AskHolidaysDto>> getByStatus(@PathVariable("idStatus") int idStatus){
        return managerService.getByStatus(idStatus)
                .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employee/{id}")
    public List<AskHolidaysDto> getByWorker(@PathVariable("id") int id){
        return managerService.getByWorker(id);
    }


    @PutMapping("/resolve")
    public ResponseEntity<AskHolidaysDto> ResolveHolidayRequest( @Valid @RequestBody ManagerRequest managerRequest)
    {
         return managerService.ResolveHolidays(managerRequest)
                  .map(askHolidaysDto -> new ResponseEntity<>(askHolidaysDto, HttpStatus.OK))
                  .orElse(new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR));
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



}
