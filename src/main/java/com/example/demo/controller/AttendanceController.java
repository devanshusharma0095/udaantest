package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.AttendanceRequest;
import com.example.demo.response.DayAttendanceResponse;
import com.example.demo.services.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@PostMapping("/")
	public ResponseEntity<String> recordAttendance(@RequestBody AttendanceRequest request) throws ParseException {
		return ResponseEntity.ok().body(attendanceService.saveAttendance(request));
	}

	@GetMapping("/day")
	public ResponseEntity<List<DayAttendanceResponse>> getAttendanceByDay(@RequestParam("date") String day) throws Exception {
		return ResponseEntity.ok().body(attendanceService.getAttendanceByDay(day));
	}
}
