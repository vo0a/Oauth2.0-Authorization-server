package com.example.resource_server.controller;

import com.example.resource_server.domain.User;
import com.example.resource_server.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

  private final UserRepository userRepository;

  @GetMapping(value = "/users")
  public List<User> findAllUser() {
    return userRepository.findAll();
  }
}