package com.zdy.dao;

import com.zdy.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {

    //查询student表中所有的数据
    public List<Student> selectStudents();
    public int insertStudent(Student student);
}
