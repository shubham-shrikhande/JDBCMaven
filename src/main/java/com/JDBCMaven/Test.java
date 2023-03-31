package com.JDBCMaven;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.JDBCMaven.dao.copy.StudentDaoClass;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/JDBCMaven/Connection/config.xml");
		StudentDaoClass dao=(StudentDaoClass) context.getBean("dao");
         // for insert operation
		Student s= new Student(1,"Shubham","Nerpinglai");
		int resultInsert=dao.insert(s);
		System.out.println(resultInsert);
		
		 // for update operation
		s.setId(1);
		s.setName("Akshay");
		s.setCity("Mumbai");
		int resultChange=dao.change(s);
		System.out.println(resultChange	);
		
		// for Delete Operation
	
		int resultDelete=dao.delete(2);
		System.out.println(resultDelete);
		
		// QueryForObject  -single object retrieval operation
		Student student=dao.getStudent(2);
		System.out.println(student);
		
		// query -for all rows retrieval operation
		List<Student> students=dao.getAllStudents();
		for(Student s1: students) {
			System.out.println(s1);
		}
	}

}
