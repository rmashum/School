package com.scholiq.Scholiq.controller;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Notice;
import com.scholiq.Scholiq.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    public ResponseEntity<?> createNotice(@RequestBody Notice notice) {
        try {
            return ResponseEntity.ok(noticeService.createNotice(notice));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list/{schoolId}")
    public ResponseEntity<?> listNotices(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        List<Notice> notices = noticeService.listNotices(school);
        if (notices.isEmpty()) {
            return ResponseEntity.ok("No notices found");
        }
        return ResponseEntity.ok(notices);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotice(@PathVariable Long id, @RequestBody Notice noticeDetails) {
        Optional<Notice> updatedNotice = noticeService.updateNotice(id, noticeDetails);
        return updatedNotice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotice(@PathVariable Long id) {
        try {
            noticeService.deleteNotice(id);
            return ResponseEntity.ok("Notice deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteBySchool/{schoolId}")
    public ResponseEntity<?> deleteNotices(@PathVariable Long schoolId) {
        Admin school = new Admin();
        school.setId(schoolId);
        try {
            noticeService.deleteNotices(school);
            return ResponseEntity.ok("Notices deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
