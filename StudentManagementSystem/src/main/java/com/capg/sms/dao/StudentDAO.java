package com.capg.sms.dao;

import com.capg.sms.beans.Student;

public interface StudentDAO {

	public Student registerStudent(Student student);
	public Student loginStudent(int regno,String password);
	public Student searchStudent(int regno);
	public Boolean removeStudent(int regno,String password);
	public Student updateEmail(int regno,String email);
	public Double updateMarks(Student student);

}
