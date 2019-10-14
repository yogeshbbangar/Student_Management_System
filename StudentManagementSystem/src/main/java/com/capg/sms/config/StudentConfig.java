package com.capg.sms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capg.sms.beans.Student;

@Configuration
@ComponentScan(basePackageClasses = Student.class)
public class StudentConfig {
	
	
}
