package com.example.gbwwebappbackend.repository;


import com.example.gbwwebappbackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    @Modifying
    @Transactional
    @Query("update Message m set m.isRead = ?1 where m.id = ?2")
    int updateIsReadById(@NonNull boolean isRead, @NonNull String id);
}
