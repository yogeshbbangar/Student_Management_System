package com.capg.sms.services;

import com.capg.sms.beans.Student;

public interface StudentService {

	public Student registerStudent(Student student);
	public Student loginStudent(int regno,String password);
	public Student searchStudent(int regno);
	public Boolean removeStudent(int regno,String password);
	public Student updateEmail(int regno,String email);
	public Double updateMarks(Student student);
	public String getgrade(double marks);
	public Double getAggreagateMarks(int regno);
	


}
