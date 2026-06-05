package com.example.employee_seat_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seating_chart")
public class SeatingChart {

    @Id
    @Column(name = "floor_seat_seq")
    private Integer floorSeatSeq;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "seat_no")
    private String seatNo;

    public Integer getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(Integer floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}