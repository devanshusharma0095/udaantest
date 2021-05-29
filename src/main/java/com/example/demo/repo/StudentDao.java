package com.example.demo.repo;

import com.example.demo.entity.Student;

public interface StudentDao {

	Student getStudentByEmail(String email);
}
