DELIMITER //

CREATE PROCEDURE AssignSeat(
    IN p_emp_id VARCHAR(5),
    IN p_seat_seq INT
)
BEGIN

UPDATE employee
SET floor_seat_seq = p_seat_seq
WHERE emp_id = p_emp_id;

END //

DELIMITER ;