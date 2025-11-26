package com.fieldaudit.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investigator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investigatorId;

    private String firstName;
    private String lastName;
    private String email;
    private String contact;

    @OneToMany(mappedBy = "investigator")
    @JsonIgnore
    private List<FieldInvestigation> investigations;
}
