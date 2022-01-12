package com.devcamp.flametalk.repository;

import com.devcamp.flametalk.domain.Status;
import com.devcamp.flametalk.domain.User;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@DataJpaTest
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void insertNewUser() {
    userRepository.save(User.builder()
        .uid("ekfha22@gmail.com")
        .password(passwordEncoder.encode("1234"))
        .name("ekfha2")
        .status(Status.USER)
        .build());
  }
}