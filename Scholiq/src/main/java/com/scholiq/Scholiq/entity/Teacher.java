package com.scholiq.Scholiq.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "Teacher";

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @ManyToOne
    @JoinColumn(name = "teachSubject_id")
    private Subject teachSubject;

    @ManyToOne
    @JoinColumn(name = "teachSclass_id", nullable = false)
    private Sclass teachSclass;

    @ElementCollection
    @CollectionTable(name = "teacher_attendance", joinColumns = @JoinColumn(name = "teacher_id"))
    private List<Attendance> attendance;

    // Getters and Setters
}

