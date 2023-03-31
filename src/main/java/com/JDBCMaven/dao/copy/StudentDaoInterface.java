package com.JDBCMaven.dao.copy;

import java.util.List;

import com.JDBCMaven.Student;

public interface StudentDaoInterface {
     public int insert(Student student);
     public int change(Student student);
     public int delete(int id);
     public Student getStudent(int id);
     public List<Student> getAllStudents();
     }
