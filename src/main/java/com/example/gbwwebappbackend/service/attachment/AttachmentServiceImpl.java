package com.example.gbwwebappbackend.service.attachment;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.entity.Attachment;
import com.example.gbwwebappbackend.entity.Message;
import com.example.gbwwebappbackend.mapper.MessageMapper;
import com.example.gbwwebappbackend.repository.AttachmentRepository;
import com.example.gbwwebappbackend.repository.MessageRepository;
import com.example.gbwwebappbackend.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
//@AllArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    @Value("${file.saving.directory.base}")
    private String baseDir;

    @Value("${file.saving.directory.base.sub}")
    private String subDIr;


    @Value("${file.saving.directory.base.sub.news}")
    private String newsDir;

    @Value("${file.saving.directory.base.sub.resumes}")
    private String resumesDir;


    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment save(MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String headDirectory = baseDir + File.separator + subDIr;

        String fileId = UUID.randomUUID().toString();
        String fileExtension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);

        if (fileExtension.equals("pdf")) {
            headDirectory = headDirectory + File.separator + resumesDir;
        } else if (fileExtension.equals("jpg")
                || fileExtension.equals("jpeg")
                || fileExtension.equals("png")
                || fileExtension.equals("gif")
                || fileExtension.equals("bmp")
        || fileExtension.equals("tif")
        || fileExtension.equals("tiff")){
            headDirectory = headDirectory + File.separator + newsDir;
        }

        createPathIfNotExists(headDirectory);

        try {
            multipartFile.transferTo(
                    new File(headDirectory + File.separator + fileId + "." + fileExtension)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Attachment attachment = new Attachment();

        attachment.setId(fileId);
        attachment.setExtension(fileExtension);
        attachment.setPathDirectory(headDirectory);

        attachmentRepository.save(attachment);

        return attachment;
    }

    private void createPathIfNotExists(String directory) {

        if (!checkIsAvailablePath(directory)) {
            File fileDirectory = new File(directory);
            if (!fileDirectory.mkdirs()) {
                throw new RuntimeException("Cannot save");
            }
        }


    }

    private boolean checkIsAvailablePath(String basePath) {
        File path = new File(basePath);
        return path.exists();
    }


}
