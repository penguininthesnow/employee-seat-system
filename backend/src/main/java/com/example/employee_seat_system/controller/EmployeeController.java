package com.example.employee_seat_system.controller;

import com.example.employee_seat_system.dto.SeatAssignRequest;
import com.example.employee_seat_system.entity.Employee;
import com.example.employee_seat_system.repository.EmployeeRepository;
import com.example.employee_seat_system.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final SeatService seatService;

    public EmployeeController(
            EmployeeRepository employeeRepository,
            SeatService seatService) {

        this.employeeRepository = employeeRepository;
        this.seatService = seatService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping("/seats/assign")
    public String assignSeat(
            @RequestBody SeatAssignRequest request) {

        seatService.assignSeat(
                request.getEmpId(),
                request.getSeatSeq());

        return "success";
    }

    @PutMapping("/seats/clear/{empId}")
    public String clearSeat(
            @PathVariable String empId) {

        seatService.clearSeat(empId);

        return "success";
    }
}