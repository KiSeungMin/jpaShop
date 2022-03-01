package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
/*
WebSecurityConfiguerAdapter를 상속받는 클래스에 @EnableWebSecurity 어노테이션을 선언하면
SpringSecurityFilterChain이 자동으로 포함된다.
*/
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // http 요청에 대한 보안을 설저한다. 페이지 권한 설정, 로그인 페이지 설정, 로그아웃 메소드 등에 대한 설정을 작성한다.
    protected void configure(HttpSecurity http) throws Exception{

    }

    @Bean
    // BCryptPasswordEncoder 의 해시 함수를 이용하여 비밀번호를 암호화하여 저장한다
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
