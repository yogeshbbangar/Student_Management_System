package com.capg.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.sms.beans.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQLUnit");

	@Override
	public Student registerStudent(Student student) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			em.close();
			return student;
		} catch (Exception e) {
			// throw custom exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student loginStudent(int regno, String password) {
		Student student = null;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Student> query = em.createQuery("from Student u where regno= :id and password= :passwd",
					Student.class);
			query.setParameter("id", regno);
			query.setParameter("passwd", password);
			List<Student> studentList = query.getResultList();
			if (studentList.size() > 0)
				student = studentList.get(0);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Student searchStudent(int regno) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, regno);
		em.close();
		return student;
	}

	@Override
	public Boolean removeStudent(int regno,String password) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Student student = em.find(Student.class, regno);
			if(student.getPassword().equals(password)) {
				em.remove(student);
				state = true;
			}
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Student updateEmail(int regno, String email) {
		Student tempStudent=null;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			tempStudent = em.find(Student.class, regno);
			tempStudent.setEmail(email);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempStudent;
	}

	@Override
	public Double updateMarks(Student student) {
		Student tempStudent=null;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			tempStudent = em.find(Student.class, student.getRegno());
			tempStudent.setMonthlyMarks(student.getMonthlyMarks());
			tempStudent.setQuaterlyMarks(student.getQuaterlyMarks());
			tempStudent.setAggregateMarks(student.getAggregateMarks());
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempStudent.getAggregateMarks();
	}

}
