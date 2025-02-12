package com.example.gbwwebappbackend.service.attachment;

import com.example.gbwwebappbackend.domain.response.PdfResponse;
import com.example.gbwwebappbackend.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface AttachmentService {
    public Attachment save(MultipartFile multipartFile);
    PdfResponse getDocument(String fileId);
}
