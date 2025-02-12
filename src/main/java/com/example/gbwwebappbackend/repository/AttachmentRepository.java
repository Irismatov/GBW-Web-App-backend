package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}