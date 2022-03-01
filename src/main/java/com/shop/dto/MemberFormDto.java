package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 회원 가입 화면으로부터 넘어오는 가입정보를 담는 클래스
public class MemberFormDto {

    private String name;

    private String email;

    private String password;

    private String address;
}
