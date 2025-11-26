package com.fieldaudit.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pmjay_id", nullable = false, updatable = false)
    private Long pmjayId;

    private String benificiaryName;
    private String caseType;
    private String documentStatus;
    private String procedureCode;
    private String procedureDetails;
    private String categoryDetails;
    private String registrationId;
    private String specialtyCode;

    private Double preauthApprovedAmount;

    private String preauthInitiatedDate;

    private Date submittedDate;
    private Date assignedDate;

    private String assignedDoctorId;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore// FK column in master_table
    private Hospital hospital;

}
