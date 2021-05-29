package com.example.demo.repo.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;
import com.example.demo.repo.AttendanceDao;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private EntityManager entityManager;

	public List<Attendance> getAttendanceByDay(Date day) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Attendance> criteriaQuery = cb.createQuery(Attendance.class);
		Root<Attendance> root = criteriaQuery.from(Attendance.class);
		criteriaQuery.select(root).where(cb.equal(root.get("date"), day));
		TypedQuery<Attendance> q = entityManager.createQuery(criteriaQuery);
		return q.getResultList();
	}

	public Attendance getAttendanceByDayAndStudent(Date day, Student s) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Attendance.class);
		criteria.add(Restrictions.eq("date", day)).add(Restrictions.eq("student.id", s.getId()));
		return (Attendance) criteria.uniqueResult();
	}
}
