package com.example.demo.repo;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;

public interface AttendanceDao {
	List<Attendance> getAttendanceByDay(Date day);
	Attendance getAttendanceByDayAndStudent(Date day, Student s);
}
