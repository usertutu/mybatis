package com.zdy.dao;

import com.zdy.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);
}
