package com.scholiq.Scholiq.controller;

import java.util.List;

import com.scholiq.Scholiq.entity.Subject;
import com.scholiq.Scholiq.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @GetMapping("/school/{schoolId}")
    public List<Subject> getAllSubjectsBySchool(@PathVariable Long schoolId) {
        return subjectService.getAllSubjectsBySchool(schoolId);
    }

    @GetMapping("/class/{classId}")
    public List<Subject> getClassSubjects(@PathVariable Long classId) {
        return subjectService.getClassSubjects(classId);
    }

    @GetMapping("/free/{classId}")
    public List<Subject> getFreeSubjectList(@PathVariable Long classId) {
        return subjectService.getFreeSubjectList(classId);
    }

    @GetMapping("/{id}")
    public Subject getSubjectDetail(@PathVariable Long id) {
        return subjectService.getSubjectDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }

    @DeleteMapping("/school/{schoolId}")
    public void deleteSubjectsBySchool(@PathVariable Long schoolId) {
        subjectService.deleteSubjectsBySchool(schoolId);
    }

    @DeleteMapping("/class/{classId}")
    public void deleteSubjectsByClass(@PathVariable Long classId) {
        subjectService.deleteSubjectsByClass(classId);
    }
}
