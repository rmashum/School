package com.scholiq.Scholiq.service;

import java.util.List;
import java.util.Optional;

import com.scholiq.Scholiq.entity.Admin;
import com.scholiq.Scholiq.entity.Notice;
import com.scholiq.Scholiq.repository.NoticeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public List<Notice> listNotices(Admin school) {
        return noticeRepository.findBySchool(school);
    }

    public Optional<Notice> updateNotice(Long id, Notice noticeDetails) {
        return noticeRepository.findById(id).map(notice -> {
            notice.setTitle(noticeDetails.getTitle());
            notice.setDetails(noticeDetails.getDetails());
            notice.setDate(noticeDetails.getDate());
            return noticeRepository.save(notice);
        });
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    public void deleteNotices(Admin school) {
        List<Notice> notices = noticeRepository.findBySchool(school);
        noticeRepository.deleteAll(notices);
    }
}
