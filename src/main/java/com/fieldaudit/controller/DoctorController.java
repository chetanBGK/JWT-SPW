package com.fieldaudit.controller;

import com.fieldaudit.dto.DoctorPdfDTO;
import com.fieldaudit.entity.Doctor;
import com.fieldaudit.repo.DoctorRepository;
import com.fieldaudit.service.DoctorService;
import com.fieldaudit.serviceImpl.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private PdfService pdfService;
@Autowired
private DoctorRepository doctorRepository;
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Doctor> getByHospital(@PathVariable Long hospitalId) {
        return doctorService.getDoctorsByHospital(hospitalId);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadDoctorsPdf() {

        List<Doctor> doctors = doctorRepository.findAll();

        // Convert to PDF DTO
        List<DoctorPdfDTO> dtoList = doctors.stream()
                .map(this::convertToPdfDto)
                .collect(Collectors.toList());

        byte[] pdfBytes = pdfService.generateDoctorsPdf(dtoList);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=doctors.pdf")
                .body(pdfBytes);
    }

    private DoctorPdfDTO convertToPdfDto(Doctor doctor) {
        return new DoctorPdfDTO(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getGender(),
                doctor.getEmailId(),
                doctor.getContactNo(),
                doctor.getHospital() != null ? doctor.getHospital().getHospitalName() : "N/A"
        );
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
