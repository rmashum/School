package com.scholiq.Scholiq.service;

import java.util.List;

import com.scholiq.Scholiq.entity.Subject;
import com.scholiq.Scholiq.repository.StudentRepository;
import com.scholiq.Scholiq.repository.SubjectRepository;
import com.scholiq.Scholiq.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjectsBySchool(Long schoolId) {
        return subjectRepository.findBySchoolId(schoolId);
    }

    public List<Subject> getClassSubjects(Long classId) {
        return subjectRepository.findBySclassId(classId);
    }

    public List<Subject> getFreeSubjectList(Long classId) {
        return subjectRepository.findBySclassIdAndTeacherIsNull(classId);
    }

    public Subject getSubjectDetail(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    //    teacherRepository.updateTeachSubjectToNull(id);
        //studentRepository.updateExamResultAndAttendanceToNull(id);
    }

    @Transactional
    public void deleteSubjectsBySchool(Long schoolId) {
        List<Subject> subjects = subjectRepository.findBySchoolId(schoolId);
        subjects.forEach(subject -> deleteSubject(subject.getId()));
    }

    @Transactional
    public void deleteSubjectsByClass(Long classId) {
        List<Subject> subjects = subjectRepository.findBySclassId(classId);
        subjects.forEach(subject -> deleteSubject(subject.getId()));
    }
}
