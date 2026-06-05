package com.example.employee_seat_system.controller;

import com.example.employee_seat_system.entity.SeatingChart;
import com.example.employee_seat_system.repository.SeatingChartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SeatingChartController {

    private final SeatingChartRepository repository;

    public SeatingChartController(
            SeatingChartRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/seats")
    public List<SeatingChart> getSeats() {
        return repository.findAll();
    }
}