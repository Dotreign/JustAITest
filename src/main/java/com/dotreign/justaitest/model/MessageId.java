package com.dotreign.justaitest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * Объект сообщения в Redis для дедупликации приходящих сообщений
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("MessageId")
public class MessageId {

  @Id
  private String messageId;

  @TimeToLive
  private long expiration;
}