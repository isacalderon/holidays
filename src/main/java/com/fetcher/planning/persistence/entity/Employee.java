package com.fetcher.planning.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String deparment;

    @Column(name = "date_hiring")
    private LocalDateTime dateHiring;

    @Column(name = "document_id")
    private String documentId;

    private String position;

    @OneToMany(mappedBy = "author")
    private List<HolidayRequest> requestsVacations;

    @OneToMany(mappedBy = "employeeVacations")
    private List<DaysVacation> vacations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public LocalDateTime getDateHiring() {
        return dateHiring;
    }

    public void setDateHiring(LocalDateTime dateHiring) {
        this.dateHiring = dateHiring;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
