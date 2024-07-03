package com.dotreign.justaitest.service;

import com.dotreign.justaitest.dto.ApiRequest;
import com.dotreign.justaitest.util.Deduplicator;
import com.dotreign.justaitest.util.VkApiFeignClient;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

  private final Deduplicator deduplicator;
  private final VkApiFeignClient vkApiFeignClient;

  @Value("${vk.api.access_token}")
  private String accessToken;
  @Value("${vk.api.version}")
  private String version;

  /**
   * Метод отправки ответа пользователю с предварительной дедупликацией сообщений
   *
   * @param apiRequest - тело запроса
   */
  public void sendMessage(ApiRequest apiRequest) {
    if (deduplicator.isDuplicateElseAdd(apiRequest.getEvent_id())) {
      return;
    }
    log.info("Отправка сообщения с eventId - {} обратно пользователю {}", apiRequest.getEvent_id(),
        apiRequest.getObject().getMessage().getFrom_id());
    vkApiFeignClient.sendMessage(apiRequest.getObject().getMessage().getFrom_id(),
        Instant.now().getEpochSecond(),
        String.format("Вы написали: %s", apiRequest.getObject().getMessage().getText()),
        accessToken, version);
  }

}
