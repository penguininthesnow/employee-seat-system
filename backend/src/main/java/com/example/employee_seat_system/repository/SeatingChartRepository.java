package com.example.employee_seat_system.repository;

import com.example.employee_seat_system.entity.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingChartRepository
        extends JpaRepository<SeatingChart,Integer> {
}