//package com.bit.bookclub.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Getter
//@ToString
//@Table(indexes = {
//        @Index(columnList = "email", unique = true),
//        @Index(columnList = "createdAt"),
//        @Index(columnList = "createdBy")
//})
//@Entity
//public class UserAccount extends AuditingFields {
//    @Id
//    @Column(length = 50)
//    private String userId;
//
//    @Setter @Column(nullable = false) private String Password;
//
//    @Setter @Column(length = 100) private String email;
//    @Setter @Column(length = 100) private String nickname;
//    
//
//
//    protected UserAccount() {}
//
//    private UserAccount(String userId, String userPassword, String email, String nickname) {
//        this.userId = userId;
//        this.Password = Password;
//        this.email = email;
//        this.nickname = nickname;
//       
//    }
//
//    public static UserAccount of(String userId, String Password, String email, String nickname) {
//        return new UserAccount(userId, Password, email, nickname);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof UserAccount that)) return false;
//        return userId != null && userId.equals(that.getUserId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId);
//    }
//
//}