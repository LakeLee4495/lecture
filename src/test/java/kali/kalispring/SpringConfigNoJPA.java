package kali.kalispring;

import jakarta.persistence.EntityManager;
import kali.kalispring.repository.*;
import kali.kalispring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfigNoJPA {

    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // jpa 사용시 아래 em 설정
    private final EntityManager em;

    @Autowired
    public SpringConfigNoJPA(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
