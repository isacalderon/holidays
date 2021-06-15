package com.fetcher.planning.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cat_status")
public class CatStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private boolean active;

    @OneToMany(mappedBy = "status")
    private List<HolidayRequest> holidaysRequests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
