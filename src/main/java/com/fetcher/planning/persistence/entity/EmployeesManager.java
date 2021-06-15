package com.fetcher.planning.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees_managers")
public class EmployeesManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "reporter_to")
    private Integer reporterTo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "id_employee", insertable = false, updatable = false)
    private Employee worker;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Integer getReporterTo() {
        return reporterTo;
    }

    public void setReporterTo(Integer reporterTo) {
        this.reporterTo = reporterTo;
    }
}
