package com.scholiq.Scholiq.controller;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.dto.LoginRequest;
import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;
import com.scholiq.Scholiq.entity.Student;
import com.scholiq.Scholiq.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.registerStudent(student));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody LoginRequest request) {
        Optional<Student> student = studentService.loginStudent(request.getRollNum(), request.getName(), request.getPassword());
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<?> listStudentsBySchool(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        List<Student> students = studentService.listStudentsBySchool(school);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<?> listStudentsByClass(@PathVariable Long classId) {
        Sclass sclassName = new Sclass();
        sclassName.setId(classId);
        List<Student> students = studentService.listStudentsByClass(sclassName);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> updatedStudent = studentService.updateStudent(id, studentDetails);
        return updatedStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteBySchool/{schoolId}")
    public ResponseEntity<?> deleteStudentsBySchool(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        try {
            studentService.deleteStudentsBySchool(school);
            return ResponseEntity.ok("Students deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteByClass/{classId}")
    public ResponseEntity<?> deleteStudentsByClass(@PathVariable Long classId) {
        Sclass sclassName = new Sclass();
        sclassName.setId(classId);
        try {
            studentService.deleteStudentsByClass(sclassName);
            return ResponseEntity.ok("Students deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
