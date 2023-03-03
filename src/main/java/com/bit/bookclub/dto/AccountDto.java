package com.bit.bookclub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bit.bookclub.modules.account.domain.entity.Account;



public record AccountDto(
        String nickname,
        String password,
        String email,
        Boolean isValid,
        String emailToken,
        LocalDateTime joinedAt,
        LocalDate birtday,
        String gender,
        String name,
        Integer age
) {

    public static AccountDto of(String nickname, String password, String email) {
        return new AccountDto(nickname, password, email, null, null, null, null, null, null, null);
    }

    public static AccountDto of(
    		String nickname,
            String password,
            String email,
            Boolean isValid,
            String emailToken,
            LocalDateTime joinedAt,
            LocalDate birtday,
            String gender,
            String name,
            Integer age) {
        return new AccountDto(nickname, password, email, isValid, emailToken, joinedAt, birtday, gender, name, age);
    }

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getNickname(),
                entity.getPassword(),
                entity.getEmail(),
                entity.isValid(),
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