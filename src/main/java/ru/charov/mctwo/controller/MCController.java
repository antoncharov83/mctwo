package ru.charov.mctwo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import ru.charov.mctwo.model.Message;
import ru.charov.mctwo.service.MCService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MCController {

    private final MCService mcService;

    @MessageMapping("/send")
    public ResponseEntity getMessage(@RequestBody Message msg) {
        mcService.send(msg);
        return ResponseEntity.ok().build();
    }
}
