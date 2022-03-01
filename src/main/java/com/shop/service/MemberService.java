package com.shop.service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// 로직을 처리하다가 에러가 발생하였다면, 변경된 데이터를 로직을 수행하기 이전 상태로 콜백 시켜준다.
@Transactional
// final 이나 @NonNull 이 붙은 필드에 생성자를 생성해줌
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    // 이미 가입된 회원의 경우 IllegalStateException 예외를 발생시킨다.
    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember !=  null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
