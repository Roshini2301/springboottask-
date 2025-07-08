package com.example.springbootfirst;

import com.example.springbootfirst.Sp1;
import com.example.springbootfirst.Sp2;
import com.example.springbootfirst.Sp3;
import com.example.springbootfirst.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

       ApplicationContext context= new ClassPathXmlApplicationContext("resources.xml");
//      Student s=(Student) context.getBean("st");
//       s.internshipProgram();
//        context.getBean("fun");
//        System.out.println( "Hello World!" );
//        Springboot f=(Springboot) context.getBean("fun");
//        f.hello("hi");
        Sp1 s1=(Sp1) context.getBean("key1");
        s1.h1("hi1");
        Sp2 s2=(Sp2) context.getBean("key2");
        s2.h2("hi2");
        Sp3 s3=(Sp3) context.getBean("key3");
        s3.h3("hi3");


    }
}