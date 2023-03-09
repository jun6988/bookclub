package com.bit.bookclub.infra.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final DataSource dataSource;
    private final PasswordEncoder passwordEconder; //
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/public/**").permitAll() //추가한거임 아래거 주석하고 
        .antMatchers("/", "/login", "/sign-up", "/check-email-token",
                "/email-login", "/check-email-login", "/login-link", "/login-by-email", "/search/study").permitAll()
        .antMatchers("/json", "/json-login", "/json-sign-up", "/json-check-email-token",
              "/json-email-login", "/json-check-email-login", "/json-login-link", "/json-login-by-email", "/search/json-study").permitAll()
        .antMatchers(HttpMethod.GET, "/profile/*").permitAll()
        .antMatchers("/node_modules/**").permitAll();
        //.anyRequest().authenticated();// 방금 품
        //모든 것에 security 적용 시키는 code = .anyRequest().authenticated();
        http.formLogin() // 스프링 로그인 기본 페이지 생성 지정하지않으면 
                .loginPage("/json-sign-up") //login 로그인페이지로 지정
                .permitAll(); //로그인 페지이ㅔ는 인증하지 않아도 접근 가능 
        http.logout() // 로그아웃 설정 
                .logoutSuccessUrl("/l"); // 로그아웃성공시 설정된 경로로 이동
       // http.rememberMe()
         //       .userDetailsService(userDetailsService)
           //     .tokenRepository(tokenRepository());
        http.cors();
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        
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
                .antMatchers("/node_modules/**");
    }
    
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    corsConfiguration.addAllowedOrigin("http://localhost:3000");
	    corsConfiguration.addAllowedHeader("*");
	    corsConfiguration.addAllowedMethod("*");
	    corsConfiguration.setAllowCredentials(true);
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfiguration);
	    return source;
	}
	
}