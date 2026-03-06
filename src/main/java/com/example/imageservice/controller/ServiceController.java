package com.example.imageservice.controller;

import com.example.imageservice.model.ServiceTime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {

    @GetMapping
    public List<ServiceTime> getServices() {
        return List.of(
                new ServiceTime("Sunday Celebration", "9:00 AM & 11:30 AM", "Worship and teaching"),
                new ServiceTime("Midweek Recharge", "Wednesday 6:30 PM", "Bible Study")
        );
    }
}