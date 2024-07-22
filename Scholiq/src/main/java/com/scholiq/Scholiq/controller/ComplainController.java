package com.scholiq.Scholiq.controller;

import java.util.List;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Complain;
import com.scholiq.Scholiq.service.ComplainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping("/create")
    public ResponseEntity<?> createComplain(@RequestBody Complain complain) {
        try {
            return ResponseEntity.ok(complainService.createComplain(complain));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list/{schoolId}")
    public ResponseEntity<?> listComplains(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        List<Complain> complains = complainService.listComplains(school);
        if (complains.isEmpty()) {
            return ResponseEntity.ok("No complains found");
        }
        return ResponseEntity.ok(complains);
    }
}
