package com.example.gbwwebappbackend.repository;


import com.example.gbwwebappbackend.entity.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void MessageRepository_Save_ReturnsSavedMessage() {
        Message message = Message.builder()
                .phone("122222")
                .email("irismatoffj@mail.com")
                .firstName("jakhongir")
                .content("something").build();
        Message save = messageRepository.save(message);
        Assertions.assertThat(save).isNotNull();
        Assertions.assertThat(save.getId()).isEqualTo(1);
    }
}
