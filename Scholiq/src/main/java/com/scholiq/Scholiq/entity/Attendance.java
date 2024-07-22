package com.scholiq.Scholiq.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Embeddable
public class Attendance {
    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subName;
    // Getters and Setters
}
