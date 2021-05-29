package com.example.demo.repo.impl;

import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Student getStudentByEmail(String email) {
		Session s = (Session) entityManager.getDelegate();
		Criteria criteria = s.createCriteria(Student.class);
		criteria.add(Restrictions.eq("email", email));
		return (Student) criteria.uniqueResult();
	}
}
