package com.fetcher.planning.persistence.crud;

import com.fetcher.planning.persistence.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

    Employee findByNameAndLastNameAndDocumentId(String name, String lastName, String documentId);
    Employee findById(int idEmployee);


}
