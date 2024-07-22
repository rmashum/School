package com.scholiq.Scholiq.service;

import java.util.List;

import com.scholiq.Scholiq.entity.Attendance;
import com.scholiq.Scholiq.entity.Subject;
import com.scholiq.Scholiq.entity.Teacher;
import com.scholiq.Scholiq.repository.SubjectRepository;
import com.scholiq.Scholiq.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

/*    @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    @Transactional
    public Teacher registerTeacher(Teacher teacher) {
       // teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));

        Teacher existingTeacher = teacherRepository.findByEmail(teacher.getEmail());
        if (existingTeacher != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        Teacher savedTeacher = teacherRepository.save(teacher);
        subjectRepository.findById(teacher.getTeachSubject().getId())
                .ifPresent(subject -> {
                    subject.setTeacher(savedTeacher);
                    subjectRepository.save(subject);
                });

        return savedTeacher;
    }

    public Teacher loginTeacher(String email, String password) {
        Teacher teacher = teacherRepository.findByEmail(email);
      //  if (teacher != null && passwordEncoder.matches(password, teacher.getPassword())) {
            teacher.setPassword(null); // Hide password
            return teacher;
       // }
        //throw new IllegalArgumentException("Invalid email or password");
    }

    public List<Teacher> getTeachersBySchool(Long schoolId) {
        return null;
                //teacherRepository.findBySchoolId(schoolId);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Teacher not found"));
    }

    @Transactional
    public Teacher updateTeacherSubject(Long teacherId, Long subjectId) {
        Teacher teacher = getTeacherById(teacherId);
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));

        teacher.setTeachSubject(subject);
        Teacher updatedTeacher = teacherRepository.save(teacher);
        subject.setTeacher(updatedTeacher);
        subjectRepository.save(subject);

        return updatedTeacher;
    }

    @Transactional
    public void deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id);
        teacherRepository.delete(teacher);
        subjectRepository.findByTeacherId(id).ifPresent(subject -> {
            subject.setTeacher(null);
            subjectRepository.save(subject);
        });
    }

    @Transactional
    public void deleteTeachersBySchool(Long schoolId) {
        List<Teacher> teachers = null;
                //teacherRepository.findBySchoolId(schoolId);
      // teacherRepository.deleteAll(teachers);
    }

    @Transactional
    public void deleteTeachersByClass(Long sclassId) {
        List<Teacher> teachers = null;
                //teacherRepository.findByTeachSclassId(sclassId);
        teacherRepository.deleteAll(teachers);
    }

    @Transactional
    public Teacher markAttendance(Long teacherId, Attendance attendance) {
        Teacher teacher = getTeacherById(teacherId);
        teacher.getAttendance().add(attendance);
        return teacherRepository.save(teacher);
    }
}
