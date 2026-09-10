package com.movingmarketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long movingRequestId;

    @NotNull
    @Column(nullable = false)
    private LocalDate scheduledDate;

    @NotNull
    @Column(nullable = false)
    private LocalTime scheduledTime;

    @NotNull
    @Column(nullable = false)
    private String status;

    public Schedule() {
    }

    public Schedule(
            Long movingRequestId,
            LocalDate scheduledDate,
            LocalTime scheduledTime,
            String status
    ) {
        this.movingRequestId = movingRequestId;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public void setMovingRequestId(Long movingRequestId) {
        this.movingRequestId = movingRequestId;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}