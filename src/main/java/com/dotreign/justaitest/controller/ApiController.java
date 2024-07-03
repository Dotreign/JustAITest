package com.dotreign.justaitest.controller;

import com.dotreign.justaitest.dto.ApiRequest;
import com.dotreign.justaitest.service.MessageService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class ApiController {

  @Value("${vk.api.confirmation_key}")
  private String confirmationKey;
  private final MessageService messageService;

  /**
   * Метод принимающий запросы от VK. Реализована обработка двух типов запросов, для лучшей обработки
   * можно реализовать фабрику команд или стратегий обработки разных типов запросов.
   */
  @PostMapping
  public ResponseEntity<String> apiRequest(@RequestBody ApiRequest apiRequest) {
    log.info("Получен запрос с типом {}", apiRequest.getType());
    if (Objects.equals(apiRequest.getType(), "message_new")) {
      messageService.sendMessage(apiRequest);
      return ResponseEntity.ok("OK");
    }
    return ResponseEntity.ok(confirmationKey);
  }

}
