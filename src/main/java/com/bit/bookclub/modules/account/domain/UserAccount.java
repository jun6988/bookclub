package com.bit.bookclub.modules.account.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bit.bookclub.modules.account.domain.entity.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "joinedAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends User {
    @Id
    @Column(length = 50)
    private String userId;

    @Setter @Column(nullable = false) private String password;
//
    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickname;
//    
    @Setter @Column private LocalDateTime joinedAt;
    @Setter @Column private LocalDateTime modifiedAt;
    @Setter @Column private String modifiedBy;
    @Setter @Column private String createdBy;
//
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public UserAccount(Account account) {
        super(account.getNickname(), account.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.account = account;
    }
}

