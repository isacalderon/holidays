package com.fetcher.planning.persistence.crud;

import com.fetcher.planning.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

    Employee findByNameAndLastNameAndDocumentId(String name, String lastName, String documentId);
}
