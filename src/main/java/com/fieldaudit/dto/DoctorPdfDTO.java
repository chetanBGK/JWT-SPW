package com.fieldaudit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPdfDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String emailId;
    private String contactNo;
    private String hospitalName;
}
