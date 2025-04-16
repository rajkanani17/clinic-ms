package com.cs.appointmentservice.controller;

import com.cs.appointmentservice.dto.AppointmentDTO;
import com.cs.appointmentservice.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

//    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentDTO> getAll() {
//        logger.info("Fetching all appointments");
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getById(@PathVariable Long id) {
//        logger.info("Fetching appointment with id : {} ", id);
        return appointmentService.getAppointment(id);
    }

    @PostMapping
    public AppointmentDTO create(@RequestBody AppointmentDTO dto) {
//        logger.info("Creating new appointment for patientId: {}, doctorId: {}", dto.getPatientId(), dto.getDoctorId());
        return appointmentService.create(dto);
    }
}

