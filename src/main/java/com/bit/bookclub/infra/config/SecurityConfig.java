package com.bit.bookclub.infra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.bit.bookclub.dto.UserAccountDto;
import com.bit.bookclub.dto.security.BoardPrincipal;
import com.bit.bookclub.repository.UserAccountRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .mvcMatchers("/", "/login", "/sign-up", "/check-email-token",
                "/email-login", "/check-email-login", "/login-link", "/login-by-email", "/search/study").permitAll()
        .mvcMatchers("/json", "/json-login", "/json-sign-up", "/json-check-email-token",
                "/json-email-login", "/json-check-email-login", "/json-login-link", "/json-login-by-email", "/search/json-study").permitAll()
        .mvcMatchers(HttpMethod.GET, "/profile/*", "/", "/articles",  "/articles/search-hashtag" ).permitAll()
        .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .permitAll();
        http.logout()
                .logoutSuccessUrl("/");
        http.rememberMe()
                .userDetailsService(userDetailsService)
                .tokenRepository(tokenRepository());
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .mvcMatchers("/node_modules/**");
    }
}




//@Bean
//public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
//    return username -> userAccountRepository
//            .findById(username)
//            .map(UserAccountDto::from)
//            .map(BoardPrincipal::from)
//            .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
//}
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//}

