package com.scholiq.Scholiq.controller;

import java.util.List;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;
import com.scholiq.Scholiq.entity.Student;
import com.scholiq.Scholiq.service.SclassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sclass")
public class SclassController {

    @Autowired
    private SclassService sclassService;

    @PostMapping("/create")
    public ResponseEntity<?> createSclass(@RequestBody Sclass sclass) {
        try {
            return ResponseEntity.ok(sclassService.createSclass(sclass));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list/{schoolId}")
    public ResponseEntity<?> listSclasses(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        List<Sclass> sclasses = sclassService.listSclasses(school);
        if (sclasses.isEmpty()) {
            return ResponseEntity.ok("No sclasses found");
        }
        return ResponseEntity.ok(sclasses);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getSclassDetail(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(sclassService.getSclassDetail(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/students/{sclassId}")
    public ResponseEntity<?> getSclassStudents(@PathVariable Long sclassId) {
        Sclass sclass = new Sclass();
        sclass.setId(sclassId);
        List<Student> students = sclassService.getSclassStudents(sclass);
        if (students.isEmpty()) {
            return ResponseEntity.ok("No students found");
        }
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSclass(@PathVariable Long id) {
        try {
            sclassService.deleteSclass(id);
            return ResponseEntity.ok("Class deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteBySchool/{schoolId}")
    public ResponseEntity<?> deleteSclasses(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        sclassService.deleteSclasses(school);
        return ResponseEntity.ok("Classes deleted successfully");
    }
}
