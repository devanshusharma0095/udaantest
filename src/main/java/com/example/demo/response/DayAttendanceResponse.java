package com.example.demo.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DayAttendanceResponse {

	private List<String> email;
	private int count;

	public DayAttendanceResponse(List<String> email) {
		this.email = email;
		this.count = email.size();
	}
}
