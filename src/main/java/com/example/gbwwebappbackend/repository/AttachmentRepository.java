package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}