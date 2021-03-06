package com.devcamp.flametalk.config;

import com.devcamp.flametalk.domain.User;
import com.devcamp.flametalk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  @Override
  public Authentication authenticate(Authentication authentication) {

    String name = authentication.getName();
    String password = authentication.getCredentials().toString();

    User user = userRepository.findByUid(name)
        .orElseThrow(() -> new UsernameNotFoundException("user is not exists"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new BadCredentialsException("password is not valid");
    }

    return new UsernamePasswordAuthenticationToken(name, password, user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(
        UsernamePasswordAuthenticationToken.class);
  }
}