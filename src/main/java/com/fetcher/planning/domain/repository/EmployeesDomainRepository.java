package com.fetcher.planning.domain.repository;

import com.fetcher.planning.domain.dto.EmployeesDto;
import com.fetcher.planning.persistence.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


public interface EmployeesDomainRepository {

    int getEmployee(String name, String lastName, String documentId);

    EmployeesDto findById(int idEmployee);

}
