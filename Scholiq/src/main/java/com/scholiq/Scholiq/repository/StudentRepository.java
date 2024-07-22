package com.scholiq.Scholiq.repository;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;
import com.scholiq.Scholiq.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNumAndName(int rollNum, String name);

   /* List<Student> findBySchool(Admin school);

 //   List<Student> findBySClassName(Sclass sclassName);

    List<Student> findBySclass(Sclass sclass);

    void updateExamResultAndAttendanceToNull(Long id);*/
}
