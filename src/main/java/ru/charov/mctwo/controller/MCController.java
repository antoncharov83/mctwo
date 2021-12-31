package ru.charov.mctwo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import ru.charov.mctwo.service.MCService;

@Controller
@RequiredArgsConstructor
public class MCController {

    private final MCService mcService;

    @MessageMapping("/send")
    public ResponseEntity getMessage(@RequestBody String msg) {
        mcService.send(msg);
        return ResponseEntity.ok().build();
    }
}
