package com.fetcher.planning.domain.dto;

import java.time.LocalDateTime;

public class AskHolidaysDto {
    private int idHolidays;
    private EmployeesDto author;
    private StatusDto status;
    private EmployeesDto resolvedBy;
    private LocalDateTime createdAt;
    private LocalDateTime startHolidays;
    private LocalDateTime endHolidays;
    private int daysToUse;

    public int getDaysToUse() {
        return daysToUse;
    }

    public void setDaysToUse(int daysToUse) {
        this.daysToUse = daysToUse;
    }

    public EmployeesDto getAuthor() {
        return author;
    }

    public void setAuthor(EmployeesDto author) {
        this.author = author;
    }

    public int getIdHolidays() {
        return idHolidays;
    }

    public void setIdHolidays(int idHolidays) {
        this.idHolidays = idHolidays;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EmployeesDto getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(EmployeesDto resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public LocalDateTime getStartHolidays() {
        return startHolidays;
    }

    public void setStartHolidays(LocalDateTime startHolidays) {
        this.startHolidays = startHolidays;
    }

    public LocalDateTime getEndHolidays() {
        return endHolidays;
    }

    public void setEndHolidays(LocalDateTime endHolidays) {
        this.endHolidays = endHolidays;
    }


}
