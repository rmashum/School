package com.scholiq.Scholiq.controller;

import java.util.List;

import com.scholiq.Scholiq.dto.LoginRequest;
import com.scholiq.Scholiq.entity.Attendance;
import com.scholiq.Scholiq.entity.Teacher;
import com.scholiq.Scholiq.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/register")
    public Teacher registerTeacher(@RequestBody Teacher teacher) {
        return teacherService.registerTeacher(teacher);
    }

    @PostMapping("/login")
    public Teacher loginTeacher(@RequestBody LoginRequest loginRequest) {
        return teacherService.loginTeacher(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @GetMapping("/school/{schoolId}")
    public List<Teacher> getTeachersBySchool(@PathVariable Long schoolId) {
        return teacherService.getTeachersBySchool(schoolId);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/subject")
    public Teacher updateTeacherSubject(@RequestBody LoginRequest request) {
        return teacherService.updateTeacherSubject(request.getTeacherId(), request.getSubjectId());
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @DeleteMapping("/school/{schoolId}")
    public void deleteTeachersBySchool(@PathVariable Long schoolId) {
        teacherService.deleteTeachersBySchool(schoolId);
    }

    @DeleteMapping("/class/{classId}")
    public void deleteTeachersByClass(@PathVariable Long classId) {
        teacherService.deleteTeachersByClass(classId);
    }

    @PostMapping("/{id}/attendance")
    public Teacher markAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        return teacherService.markAttendance(id, attendance);
    }
}
