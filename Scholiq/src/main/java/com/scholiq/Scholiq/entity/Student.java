package com.scholiq.Scholiq.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int rollNum;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "sclass_id", nullable = false)
    private Sclass sclassName;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private Admin school;

    @Column
    private String role = "Student";

    @ElementCollection
    private List<ExamResult> examResult;

    @ElementCollection
    private List<Attendance> attendance;

}
