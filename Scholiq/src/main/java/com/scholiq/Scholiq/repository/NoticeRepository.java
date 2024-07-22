package com.scholiq.Scholiq.repository;

import java.util.List;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findBySchool(Admin school);
}
