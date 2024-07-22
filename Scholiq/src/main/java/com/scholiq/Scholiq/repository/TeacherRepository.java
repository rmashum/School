package com.scholiq.Scholiq.repository;

import java.util.List;

import com.scholiq.Scholiq.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByEmail(String email);

    /*List<Teacher> findBySchoolId(Long schoolId);

    List<Teacher> findByTeachSclassId(Long sclassId);*/

    //void updateTeachSubjectToNull(Long id);
}