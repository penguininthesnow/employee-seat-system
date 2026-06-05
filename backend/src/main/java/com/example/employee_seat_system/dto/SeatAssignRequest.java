package com.example.employee_seat_system.dto;

public class SeatAssignRequest {

    private String empId;
    private Integer seatSeq;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Integer getSeatSeq() {
        return seatSeq;
    }

    public void setSeatSeq(Integer seatSeq) {
        this.seatSeq = seatSeq;
    }
}