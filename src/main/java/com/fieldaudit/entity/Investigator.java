package com.fieldaudit.entity;
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
    @GeneratedValue
    private UUID investigatorId;

    private String firstName;
    private String lastName;
    private String email;
    private String contact;

    @OneToMany(mappedBy = "investigator")
    private List<FieldInvestigation> investigations;
}
