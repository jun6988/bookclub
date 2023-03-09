package com.bit.bookclub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bit.bookclub.modules.account.domain.entity.Account;



public record AccountDto(
        String nickname,
        String password,
        String email,
        //Boolean isValid,
        String emailToken,
        LocalDateTime joinedAt,
        LocalDate birtday,
        String gender,
        String name,
        Integer age
) {

    public static AccountDto of(String nickname, String password, String email) {
        return new AccountDto(nickname, password, email, null, null, null, null, null, null); // valid 잠시 주석떄문에 null하나 없음 
    }

    public static AccountDto of(
    		String nickname,
            String password,
            String email,
           //boolean isValid,
            String emailToken,
            LocalDateTime joinedAt,
            LocalDate birtday,
            String gender,
            String name,
            Integer age) {
        return new AccountDto(nickname, password, email, emailToken, joinedAt, birtday, gender, name, age); //is valid빠짐
    }

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getNickname(),
                entity.getPassword(),
                entity.getEmail(),
                //entity.isValid(),
                entity.getEmailToken(),
                entity.getJoinedAt(),
                entity.getBirtday(),
                entity.getGender(),
                entity.getName(),
                entity.getAge()
        );
    }

    public Account toEntity() {
        return Account.of(
                nickname,
                password,
                email
        );
    }
}