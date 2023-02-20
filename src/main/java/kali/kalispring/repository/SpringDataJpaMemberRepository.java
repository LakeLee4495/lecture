package kali.kalispring.repository;

import kali.kalispring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository
        extends JpaRepository<Member, Long>, MemberRepository {
    // <>에서 앞은 t : member, 뒤는 id : entity에서 식별자 pk

    //@Override
    Optional<Member> findByName(String name);
}
