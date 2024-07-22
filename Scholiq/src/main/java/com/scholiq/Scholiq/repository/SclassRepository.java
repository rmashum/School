package com.scholiq.Scholiq.repository;

import java.util.List;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Sclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SclassRepository extends JpaRepository<Sclass, Long> {
/*    Sclass findBySclassNameAndSchool(String sclassName, Admin school);

    List<Sclass> findBySchool(Admin school);*/
}
