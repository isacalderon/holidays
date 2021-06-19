package com.fetcher.planning.web.request;

import java.time.LocalDate;

public class DaysAvailableResponse {

     private long availableDays;
     private long usedDays;
     private LocalDate dateResponse;

    public long getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(long availableDays) {
        this.availableDays = availableDays;
    }

    public long getUsedDays() {
        return usedDays;
    }

    public void setUsedDays(long usedDays) {
        this.usedDays = usedDays;
    }

    public LocalDate getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(LocalDate dateResponse) {
        this.dateResponse = dateResponse;
    }
}
