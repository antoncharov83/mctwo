package ru.charov.mctwo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.charov.mctwo.model.Message;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class MCService {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void send(Message msg) {
        msg.setMC2_timestamp(LocalDateTime.now());

        var msgKafka = MessageBuilder.withPayload(msg).setHeader(KafkaHeaders.TOPIC, "topicMC3").build();

        var response = kafkaTemplate.send(msgKafka);
        response.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(final SendResult<String, Message> message) {
                log.info("sent message= " + message + " with offset= " + message.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(final Throwable throwable) {
                log.error("unable to send message= ", throwable);
            }
        });
    }
}
