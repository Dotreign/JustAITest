package com.dotreign.justaitest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestObject {

  private Message message;
  private ClientInfo client_info;

}
