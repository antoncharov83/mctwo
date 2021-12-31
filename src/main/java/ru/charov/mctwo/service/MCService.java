package ru.charov.mctwo.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.charov.mctwo.model.Message;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class MCService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final Gson mapper;

    public void send(String msgTxt) {
        var msg = mapper.fromJson(msgTxt, Message.class);
        msg.setMC2_timestamp(LocalDateTime.now());

        var txtMsg = mapper.toJson(msg);

        kafkaTemplate.send("topicMC3", txtMsg);
    }
}
