package com.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_STUDENTS")
public class Student implements Serializable {

    @Id
    @SequenceGenerator(name = "S_STUDENTS_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_STUDENTS_SEQUENCE")
    @Column(name = "id")
    private Long studentId;

    @Column(name = "name", length = 20)
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Student mentor;

    public Long getStudentId() {
        return studentId;
    }

    public Student setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Student getMentor() {
        return mentor;
    }

    public Student setMentor(Student mentor) {
        this.mentor = mentor;
        return this;
    }
}