package com.fetcher.planning.persistence;

import com.fetcher.planning.domain.dto.EmployeesDto;
import com.fetcher.planning.domain.repository.EmployeesDomainRepository;
import com.fetcher.planning.persistence.crud.EmployeeCrudRepository;
import com.fetcher.planning.persistence.entity.Employee;
import com.fetcher.planning.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeesRepository implements EmployeesDomainRepository {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public int getEmployee(String name, String lastName, String documentId) {

        EmployeesDto employee= mapper.toEmployeesDto(employeeCrudRepository.findByNameAndLastNameAndDocumentId(name, lastName, documentId));
        return employee.getId();
    }
}
