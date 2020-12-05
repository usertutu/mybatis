package com.zdy;

import com.zdy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    //测试方法
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据

        //1.定义mybatis主配置文件的名称，从类根路径开始
        System.out.println("00001");
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);

        //3.创建了sqlSeesionFactoryBuilder对象
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        System.out.println("000002");
        //4.创建了sqlSessionFactory对象
        SqlSessionFactory factory =builder.build(in);
        System.out.println("111111");
        //5.[重要]获取sqlSession对象，从sqlSessionFactory中获取sqlSession
        SqlSession sqlSession= factory.openSession();
        //6.[重要]指定要执行的sql语句的标识。 sql映射中namespace+"."+标签id值
        String sqlId="com.zdy.dao.StudentDao"+"."+"insertStudent";
        //7.执行sql语句，通过sqlid找到语句
        Student student=new Student();
        student.setId(1008);
        student.setName("李杠");
        student.setEmail("sanguo@qq.com");
        student.setAge(20);
        int nums =sqlSession.insert(sqlId,student);
        //mybatis默认是不自动提交事务的，所以在insert，update，delete后手工提交事务
        sqlSession.commit();

        //8.输出结果
        System.out.println("执行insert结果:"+nums);

        //9.关闭sqlsession对象
        sqlSession.close();


    }
}
