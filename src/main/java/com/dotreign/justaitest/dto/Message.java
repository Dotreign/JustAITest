package com.dotreign.justaitest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДТО сообщения запроса
 */
@Getter
@Setter
@AllArgsConstructor
public class Message {

  private Long date;
  private Long from_id;
  private Long id;
  private Long out;
  private Long version;
  private Object[] attachments;
  private Long conversation_message_id;
  private Object[] fwd_messages;
  private Boolean important;
  private Boolean is_hidden;
  private Long peer_id;
  private Long random_id;
  private String text;


}
