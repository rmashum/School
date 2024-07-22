package com.scholiq.Scholiq.service;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;
import com.scholiq.Scholiq.entity.Student;
import com.scholiq.Scholiq.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public Student registerStudent(Student student) {
      //  student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Optional<Student> loginStudent(int rollNum, String name, String password) {
        Optional<Student> studentOpt = studentRepository.findByRollNumAndName(rollNum, name);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
           // if (passwordEncoder.matches(password, student.getPassword())) {
                student.setPassword(null);  // Hide password
                return Optional.of(student);
           // }
        }
        return Optional.empty();
    }

    public List<Student> listStudentsBySchool(Admin school) {
        return null;
                //studentRepository.findBySchool(school);
    }

    public List<Student> listStudentsByClass(Sclass sclassName) {
        return null;
                //studentRepository.findBySClassName(sclassName);
    }

    public Optional<Student> updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setRollNum(studentDetails.getRollNum());
            student.setSclassName(studentDetails.getSclassName());
            student.setSchool(studentDetails.getSchool());
            if (studentDetails.getPassword() != null) {
               // student.setPassword(passwordEncoder.encode(studentDetails.getPassword()));
            }
            return studentRepository.save(student);
        });
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudentsBySchool(Admin school) {
        List<Student> students =null;
                //studentRepository.findBySchool(school);
        studentRepository.deleteAll(students);
    }

    public void deleteStudentsByClass(Sclass sclassName) {
        List<Student> students = null;
                //studentRepository.findBySClassName(sclassName);
        studentRepository.deleteAll(students);
    }
}

