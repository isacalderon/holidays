package com.fetcher.planning.domain;

import com.fetcher.planning.persistence.entity.Employee;

import java.time.LocalDateTime;
import java.util.List;

public class AskHolidaysDto {
    private int id;
    private int resolved;
    private LocalDateTime startHolidays;
    private LocalDateTime endHolidays;
    private int manager;
    private StatusDto status;

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResolved() {
        return resolved;
    }

    public void setResolved(int resolved) {
        this.resolved = resolved;
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

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }
}
