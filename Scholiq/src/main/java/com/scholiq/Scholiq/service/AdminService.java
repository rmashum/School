package com.scholiq.Scholiq.service;


import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public Admin registerAdmin(Admin admin) throws Exception {
        if (adminRepository.findByEmail(admin.getEmail()) != null) {
            throw new Exception("Email already exists");
        }
        if (adminRepository.findBySchoolName(admin.getSchoolName()) != null) {
            throw new Exception("School name already exists");
        }
      //  admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin loginAdmin(String email, String password) throws Exception {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null) {
            throw new Exception("User not found");
        }
   /*     if (!bCryptPasswordEncoder.matches(password, admin.getPassword())) {
            throw new Exception("Invalid password");
        }*/
        admin.setPassword(null); // Do not return the password
        return admin;
    }

    public Admin getAdminDetail(Long id) throws Exception {
        Optional<Admin> admin = adminRepository.findById(id);
        if (!admin.isPresent()) {
            throw new Exception("No admin found");
        }
        admin.get().setPassword(null); // Do not return the password
        return admin.get();
    }
}
