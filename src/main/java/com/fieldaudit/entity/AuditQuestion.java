package com.fieldaudit.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "audit_que_id")
    private Long auditQueId;

    private String answer;
    private String auditFormType;

    @Column(length = 1000)
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "investigation_id")
    @JsonIgnore
    private FieldInvestigation investigation;
}
