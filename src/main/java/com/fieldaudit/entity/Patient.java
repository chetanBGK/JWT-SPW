package com.fieldaudit.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String patientName;
    private String gender;
    private String age;
    private String address;
    private String aadharNo;
    private String contactNo;
    private String procedureName;
    private Date hospitalizationDate;
    private String state;
    private String pincode;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<FieldInvestigation> investigations;
}
