package kali.kalispring.domain;

import jakarta.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Entity
// entity -> jpa 가 관리하는 엔티티
public class Member {

    @Id
    // jpa 를 사용할땐 pk를 매핑해줘야함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "username")
    // 만약 db에 name이 username이라면 위와같은식으로 작성하면됨
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
