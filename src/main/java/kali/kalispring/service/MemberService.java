package kali.kalispring.service;

import kali.kalispring.domain.Member;
import kali.kalispring.repository.MemberRepository;
import kali.kalispring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
// jpa를 사용할땐 항상 service 에 Transactional을 붙여야됨
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member);         //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

//    long start = System.currentTimeMillis();
//        try {
//        validateDuplicateMember(member);         //중복 회원 검증
//        memberRepository.save(member);
//        return member.getId();
//    } finally {
//        long finish = System.currentTimeMillis();
//        long timeMs = finish - start;
//        System.out.println("join : " + timeMs + "ms소요");
//    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}