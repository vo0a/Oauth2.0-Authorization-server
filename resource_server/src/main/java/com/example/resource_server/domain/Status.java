package com.example.resource_server.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

  GUEST((short) 0, "ROLE_GUEST", "준회원"),
  USER((short) 1, "ROLE_USER", "정회원"),
  ADMIN((short) 2, "ROLE_ADMIN", "관리자");

  private final short key;
  private final String name;
  private final String description;

}
