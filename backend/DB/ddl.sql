CREATE TABLE seating_chart (
                               floor_seat_seq INT PRIMARY KEY,
                               floor_no INT NOT NULL,
                               seat_no VARCHAR(10) NOT NULL
);

CREATE TABLE employee (
                          emp_id VARCHAR(5) PRIMARY KEY,
                          name VARCHAR(50),
                          email VARCHAR(100),
                          floor_seat_seq INT,
                          FOREIGN KEY (floor_seat_seq)
                              REFERENCES seating_chart(floor_seat_seq)
);