package com.scholiq.Scholiq.repository;

import com.scholiq.Scholiq.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

    Admin findBySchoolName(String schoolName);
}