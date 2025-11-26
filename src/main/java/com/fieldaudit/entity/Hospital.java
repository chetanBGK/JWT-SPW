package com.fieldaudit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;

    private String hospitalName;
    private String hospitalAddress;
    private String district;
    private String state;
    private String pincode;
    private String hospitalContact;
    private String emailId;
    private String hospitalType;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<Patient> patients;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<FieldInvestigation> investigations;
}
