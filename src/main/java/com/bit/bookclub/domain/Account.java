//package com.bit.bookclub.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Getter
//@ToString
//@Table(indexes = {
//        @Index(columnList = "email", unique = true),
//        @Index(columnList = "joinedAt")
//})
//@Entity
//public class Account extends AuditingFields {
//    @Id
//    @Column(length = 100)
//    private String nickname;
//
//    @Setter @Column(nullable = false) private String password;
//
//    @Setter @Column(length = 100) private String email;
//    
//    @Setter private Boolean isValid;
//
//    @Setter  private String emailToken;
//
//    @Setter  private LocalDateTime joinedAt;
//    
//    @Setter private LocalDate birtday;
//    
//    @Setter
//    @Column(nullable = false)
//    private String gender;
//    
//    @Setter
//    private String name;
//    
//
//
//    protected Account() {}
//
//    private Account(String nickname, String password, String email) {
//        this.nickname = nickname;
//        this.password = password;
//        this.email = email;
//    }
//
//    public static Account of(String nickname, String Password, String email) {
//        return new Account(nickname, Password, email);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Account that)) return false;
//        return nickname != null && nickname.equals(that.getNickname());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nickname);
//    }
//
//	public boolean getIsValid() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}