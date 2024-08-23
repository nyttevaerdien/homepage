package dev.kotprotiv.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  private final String username;
  private final String password;

  public SecurityConfig(
      @Value("${security.username}") String username,
      @Value("${security.password}") String password) {
    this.username = username;
    this.password = password;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        .httpBasic(httpSecurityHttpBasicConfigurer -> {})
        .csrf(AbstractHttpConfigurer::disable); // Disable CSRF protection

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
        User.withDefaultPasswordEncoder()
            .username(username)
            .password(password)
            .roles("USER")
            .build();

    return new InMemoryUserDetailsManager(user);
  }
}
