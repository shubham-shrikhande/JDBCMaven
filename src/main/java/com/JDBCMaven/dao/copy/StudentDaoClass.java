package com.JDBCMaven.dao.copy;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.JDBCMaven.Student;

public class StudentDaoClass implements StudentDaoInterface{
	JdbcTemplate template;

	public StudentDaoClass(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public int insert(Student student) {

		String query="insert into student(id,name,city) values(?,?,?)";
		int result=template.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public int change(Student student) {
		String query="update student set name=? ,city=? where id=?";
		int result=template.update(query,student.getName(),student.getCity(),student.getId());

		return result;
	}

	public int delete(int id) {

		String query="delete from student where id=?";
		int result=template.update(query,id);

		return result;
	}

	public Student getStudent(int id) {
		String query="select * from student where id=?";

		RowMapImp row=new RowMapImp();
		Student st=template.queryForObject(query, row,id);
		return st;
	}

	public List<Student> getAllStudents() {
		String query="select * from student";
		RowMapImp row= new RowMapImp();
		List<Student> student=template.query(query, row);
		return student;
	}

}
