package com.example.employee_seat_system.service;

import com.example.employee_seat_system.entity.Employee;
import com.example.employee_seat_system.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    private final EmployeeRepository employeeRepository;

    public SeatService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void assignSeat(String empId, Integer seatSeq) {
// 用stored procedure的地方(透過stored procedure存取資料庫)
        employeeRepository.assignSeat(empId, seatSeq);
    }

    @Transactional
    public void clearSeat(String empId) {

        Employee employee =
                employeeRepository.findById(empId)
                        .orElseThrow();

        employee.setFloorSeatSeq(null);

        employeeRepository.save(employee);
    }
}