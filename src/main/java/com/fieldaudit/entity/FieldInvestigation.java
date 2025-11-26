package com.fieldaudit.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldInvestigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investigation_id")
    private Long investigationId;

    private Date dateOfInvestigation;
    private String status;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "investigator_id")
    private Investigator investigator;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "investigation")
    private List<AuditQuestion> auditQuestions;
}
