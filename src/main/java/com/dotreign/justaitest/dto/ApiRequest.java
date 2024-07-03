package com.dotreign.justaitest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ДТО тела запроса от VK
 */
@Getter
@Setter
@AllArgsConstructor
public class ApiRequest {

  private Long group_id;
  private String type;
  private String event_id;
  private String v;
  private RequestObject object;

}
