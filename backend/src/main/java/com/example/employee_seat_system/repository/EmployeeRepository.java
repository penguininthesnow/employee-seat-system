package com.example.employee_seat_system.repository;

import com.example.employee_seat_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository
        extends JpaRepository<Employee, String> {
    // 用stored procedure的地方(透過stored procedure存取資料庫)
    @Procedure(procedureName = "AssignSeat")
    void assignSeat(
            @Param("p_emp_id") String empId,
            @Param("p_seat_seq") Integer seatSeq
    );
}