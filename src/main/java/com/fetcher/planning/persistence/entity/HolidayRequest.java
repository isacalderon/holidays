package com.fetcher.planning.persistence.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "holiday_requests")
public class HolidayRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "resolved_by")
    private Integer resolvedBy;

    @Column(name = "id_status")
    private Integer idStatus;

    @Column(name = "vacation_start_date")
    private LocalDateTime vacationStartDate;

    @Column(name = "vacation_end_date")
    private LocalDateTime vacationEndDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "id_employee", insertable = false, updatable = false)
    private Employee author;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "resolved_by", insertable = false, updatable = false)
    private Employee userResolved;

    @ManyToOne
    @JoinColumn(name = "id_status", insertable = false, updatable = false)
    private CatStatus catStatus;

    public Employee getUserResolved() {
        return userResolved;
    }

    public void setUserResolved(Employee userResolved) {
        this.userResolved = userResolved;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(Integer resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public LocalDateTime getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(LocalDateTime vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public LocalDateTime getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(LocalDateTime vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public CatStatus getCatStatus() {
        return catStatus;
    }

    public void setCatStatus(CatStatus catstatus) {
        this.catStatus = catstatus;
    }

}
