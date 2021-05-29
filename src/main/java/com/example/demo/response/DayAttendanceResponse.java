package com.example.demo.response;

import java.util.Date;

import com.example.demo.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DayAttendanceResponse {

	private String email;
	private int present;
	private Date date;

	public DayAttendanceResponse(Attendance attendance) {
		email = attendance.getStudent().getEmail();
		present = attendance.getPresent();
		date = attendance.getDate();
	}
}
