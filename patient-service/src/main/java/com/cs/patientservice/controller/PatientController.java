package com.cs.patientservice.controller;

import com.cs.patientservice.dto.PatientDTO;
import com.cs.patientservice.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

//    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientDTO> getAllPatients() {
//        logger.info("Fetching all patients");
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
//        logger.info("Fetching patient with id: {}", id);
        return patientService.getPatientById(id);
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO dto) {
//        logger.info("Creating patient with name: {}", dto.getName());
        return patientService.savePatient(dto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
//        logger.warn("Deleting patient with id: {}", id);
        patientService.deletePatient(id);
    }
}

