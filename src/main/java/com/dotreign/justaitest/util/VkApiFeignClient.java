package com.dotreign.justaitest.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "vk", url = "https://api.vk.com/")
public interface VkApiFeignClient {

  /**
   * Метод отправки сообщения пользователю
   *
   * @param userId      - айди пользователя
   * @param randomId    - уникальный идентификатор, предназначенный для предотвращения повторной
   *                    отправки одного и того же сообщения
   * @param message     - сообщение
   * @param accessToken - токен доступа к API VK
   * @param apiVersion  - версия используемого API
   */
  @PostMapping("/method/messages.send")
  void sendMessage(@RequestParam(name = "user_id") Long userId,
      @RequestParam(name = "random_id") Long randomId,
      @RequestParam(name = "message") String message,
      @RequestParam(name = "access_token") String accessToken,
      @RequestParam(name = "v") String apiVersion);


}
