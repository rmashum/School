package com.scholiq.Scholiq.service;

import java.util.List;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Complain;
import com.scholiq.Scholiq.repository.ComplainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    public Complain createComplain(Complain complain) {
        return complainRepository.save(complain);
    }

    public List<Complain> listComplains(Admin school) {
        return complainRepository.findBySchool(school);
    }
}
