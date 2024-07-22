package com.scholiq.Scholiq.service;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;
import com.scholiq.Scholiq.entity.Student;
import com.scholiq.Scholiq.repository.SclassRepository;
import com.scholiq.Scholiq.repository.StudentRepository;
import com.scholiq.Scholiq.repository.SubjectRepository;
import com.scholiq.Scholiq.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SclassService {

    @Autowired
    private SclassRepository sclassRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Sclass createSclass(Sclass sclass) throws Exception {
/*        if (sclassRepository.findBySclassNameAndSchool(sclass.getSclassName(), sclass.getSchool()) != null) {
            throw new Exception("Sorry this class name already exists");
        }*/
        return sclassRepository.save(sclass);
    }

    public List<Sclass> listSclasses(Admin school) {
        return null;
                //sclassRepository.findBySchool(school);
    }

    public Sclass getSclassDetail(Long id) throws Exception {
        Optional<Sclass> sclass = sclassRepository.findById(id);
        if (!sclass.isPresent()) {
            throw new Exception("No class found");
        }
        return sclass.get();
    }

    public List<Student> getSclassStudents(Sclass sclass) {
        return null;
                //studentRepository.findBySclass(sclass);
    }

    public void deleteSclass(Long id) throws Exception {
        Optional<Sclass> sclass = sclassRepository.findById(id);
        if (!sclass.isPresent()) {
            throw new Exception("Class not found");
        }
/*        studentRepository.deleteAll(studentRepository.findBySclass(sclass.get()));
        subjectRepository.deleteAll(subjectRepository.findBySclass(sclass.get()));
        teacherRepository.deleteAll(teacherRepository.findByTeachSclass(sclass.get()));*/
        sclassRepository.delete(sclass.get());
    }

    public void deleteSclasses(Admin school) {
        List<Sclass> sclasses = null;
                //sclassRepository.findBySchool(school);
        if (sclasses.isEmpty()) {
            return;
        }
        for (Sclass sclass : sclasses) {
/*            studentRepository.deleteAll(studentRepository.findBySclass(sclass));
            subjectRepository.deleteAll(subjectRepository.findBySclass(sclass));
            teacherRepository.deleteAll(teacherRepository.findByTeachSclass(sclass));*/
        }
        sclassRepository.deleteAll(sclasses);
    }
}
