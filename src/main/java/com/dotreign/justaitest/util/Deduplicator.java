package com.dotreign.justaitest.util;

import com.dotreign.justaitest.model.MessageId;
import com.dotreign.justaitest.repository.MessageIdRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Deduplicator {

  private final MessageIdRepository messageIdRepository;

  /**
   * Метод дедупликации сообщений Проверяет, существует ли сообщение в БД Redis, если нет, то
   * создает новую запись в БД и возвращает false, иначе возвращает true
   *
   * @param eventId - айди сообщения, по которому происходит дедупликация
   * @return является ли сообщение дубликатом
   */
  public boolean isDuplicateElseAdd(String eventId) {
    log.info("Проверка на дедупликацию");
    Optional<MessageId> messageId = messageIdRepository.findById(eventId);
    if (messageId.isEmpty()) {
      log.info("Сообщения с eventId - {} не существует. Создаю новую запись в БД", eventId);
      MessageId newMessageId = new MessageId(eventId, 3600L);
      messageIdRepository.save(newMessageId);
      return false;
    } else {
      log.warn("Сообщение с eventId - {} уже существует.", eventId);
      return true;
    }
  }

}
