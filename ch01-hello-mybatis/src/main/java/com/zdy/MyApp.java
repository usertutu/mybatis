package com.zdy;

import com.zdy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {

    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据

        //1.定义mybatis主配置文件的名称，从类根路径开始
        System.out.println("00001");
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);

        //3.创建了sqlSeesionFactoryBuilder对象
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();

        //4.创建了sqlSessionFactory对象
          SqlSessionFactory factory =builder.build(in);

        //5.[重要]获取sqlSession对象，从sqlSessionFactory中获取sqlSession
            SqlSession sqlSession= factory.openSession();
        //6.[重要]指定要执行的sql语句的标识。 sql映射中namespace+"."+标签id值
        String sqlId="com.zdy.dao.StudentDao"+"."+"selectStudents";
        //7.执行sql语句，通过sqlid找到语句
        List<Student> studentList =sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(stu -> System.out.println(stu));
        //9.关闭sqlsession对象
        sqlSession.close();


    }
            }
