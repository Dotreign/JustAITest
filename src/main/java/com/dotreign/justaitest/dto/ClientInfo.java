package com.dotreign.justaitest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДТО информации о клиенте(устройстве) с которого пришел запрос
 */
@Getter
@Setter
@AllArgsConstructor
public class ClientInfo {

  private String[] button_actions;
  private Boolean keyboard;
  private Boolean inline_keyboard;
  private Boolean carousel;
  private Long lang_id;


}
