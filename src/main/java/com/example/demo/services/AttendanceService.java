package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;
import com.example.demo.repo.AttendanceRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.request.AttendanceRequest;
import com.example.demo.response.DayAttendanceResponse;

@Service
public class AttendanceService {
	@Autowired
	private AttendanceRepo attendanceRepo;
	@Autowired
	private StudentRepo studentRepo;

	public String saveAttendance(AttendanceRequest request) throws ParseException {
		Student student = new Student();
		student.setEmail(request.getEmail());
		student = studentRepo.save(student);
		Date date = getParseDate(request.getDate());
		if (Objects.nonNull(date)) {
				Attendance attendance = new Attendance(date, request.getPresent(), student);
				attendanceRepo.save(attendance);
				return "Success";

		} else {
			return "Invalid Date";
		}
	}

	public List<DayAttendanceResponse> getAttendanceByDay(String strDate) throws Exception {
		Date date = getParseDate(strDate);
		if (Objects.nonNull(date)) {
			List<Attendance> attendanceList = attendanceRepo.getAttendanceByDay(date);
			return attendanceList.stream().map(DayAttendanceResponse::new).collect(Collectors.toList());
		} else {
			throw new Exception("not Valid date");
		}
	}

	private Date getParseDate(String strDate) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
		}
		catch (ParseException e) {
			return null;
		}
	}
}
