package com.movingmarketplace.controller;

import com.movingmarketplace.entity.Schedule;
import com.movingmarketplace.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(
            @Valid @RequestBody Schedule schedule
    ) {
        Schedule createdSchedule =
                scheduleService.createSchedule(schedule);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdSchedule);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return ResponseEntity.ok(
                scheduleService.getAllSchedules()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(
            @PathVariable Long id
    ) {
        return scheduleService
                .getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id
    ) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}