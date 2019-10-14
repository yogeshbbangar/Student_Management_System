package com.capg.sms.services;

import org.springframework.stereotype.Service;

import com.capg.sms.beans.Student;
import com.capg.sms.dao.StudentDAO;
import com.capg.sms.dao.StudentDAOImpl;

@Service
public class StudentServiceImpl implements StudentService {
	StudentDAO dao=new StudentDAOImpl();

	@Override
	public Student registerStudent(Student student) {
		return dao.registerStudent(student);
	}

	@Override
	public Student loginStudent(int regno, String password) {
		return dao.loginStudent(regno, password);
	}

	@Override
	public Student searchStudent(int regno) {
		return dao.searchStudent(regno);
	}

	@Override
	public Boolean removeStudent(int regno,String password) {
		return dao.removeStudent(regno, password);
	}

	@Override
	public Student updateEmail(int regno, String email) {
		return dao.updateEmail(regno, email);
	}

	@Override
	public Double updateMarks(Student student) {
		return dao.updateMarks(student);
	}

	@Override
	public String getgrade(double marks) {
		String grade="";
		double aggregate=marks/10;
		if(aggregate>9) {
			grade="A+";
		}else if(aggregate>8) {
			grade="A";
		}
		else if(aggregate>7) {
			grade="B";
		}else if(aggregate>6) {
			grade="C";
		}else if(aggregate>5) {
			grade="D";
		}else if(aggregate>4) {
			grade="E";
		}else  {
			grade="Fail";
		}
		return grade;
	}

	@Override
	public Double getAggreagateMarks(int regno) {
		Student student = dao.searchStudent(regno);
		double monthlyMarks=student.getMonthlyMarks();
		double quaterlyMarks=student.getQuaterlyMarks();
		double aggregateMarks=0;
		aggregateMarks=(monthlyMarks+quaterlyMarks*4)/24;
		return aggregateMarks;
	}
	
}
