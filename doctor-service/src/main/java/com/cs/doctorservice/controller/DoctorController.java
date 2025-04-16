package com.cs.doctorservice.controller;

import com.cs.doctorservice.dto.DoctorDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cs.doctorservice.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

//    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
//        logger.info("Fetching all doctors");
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {
//        logger.info("Fetching doctor with id: {}", id);
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
//        logger.info("Creating doctor with name: {}", dto.getName());
        return doctorService.saveDoctor(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
//        logger.warn("Deleting doctor with id: {}", id);
        doctorService.deleteDoctor(id);
    }
}

