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
public class Doctor {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String gender;
    private String emailId;
    private String contactNo;
    private String password;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<FieldInvestigation> investigations;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Patient> patients;
}
