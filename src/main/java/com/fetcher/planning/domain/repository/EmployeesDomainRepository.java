package com.fetcher.planning.domain.repository;

import com.fetcher.planning.domain.dto.EmployeesDto;

import java.util.Optional;


public interface EmployeesDomainRepository {

    int getEmployee(String name, String lastName, String documentId);

}
