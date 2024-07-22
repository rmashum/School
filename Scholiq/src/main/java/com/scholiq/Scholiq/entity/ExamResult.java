package com.scholiq.Scholiq.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class ExamResult {
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subName;

    @Column
    private int marksObtained;
}
