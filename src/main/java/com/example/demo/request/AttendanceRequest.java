package com.example.demo.request;

import lombok.Data;

@Data
public class AttendanceRequest {

	private String email;
	private int present;
	private String date;
}
