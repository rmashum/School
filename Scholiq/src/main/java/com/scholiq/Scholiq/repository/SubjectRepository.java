package com.scholiq.Scholiq.repository;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findBySchoolId(Long schoolId);

    List<Subject> findBySclassId(Long classId);

    List<Subject> findBySclassIdAndTeacherIsNull(Long classId);

    Optional<Subject> findByTeacherId(Long id);
}