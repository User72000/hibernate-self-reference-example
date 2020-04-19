package com.example.service;

import com.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    public void insert() {
        Student student1 = new Student();
        student1.setStudentName("student1");

        Student student2 = new Student();
        student2.setStudentName("student2");

        Student student3 = new Student();
        student3.setStudentName("student3");

        Student student4 =new Student();
        student4.setStudentName("student4");

        student1.setMentor(student1);
        student2.setMentor(student1);
        student3.setMentor(student2);
        student4.setMentor(student3);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepion 2---->>>:  " + e.toString());
        }
    }
}
