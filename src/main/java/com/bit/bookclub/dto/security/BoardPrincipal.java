package com.bit.bookclub.dto.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bit.bookclub.dto.AccountDto;

import lombok.Getter;

public record BoardPrincipal(
        String name,
        String password,
        Collection<? extends GrantedAuthority> authorities,
        String email,
        String nickname
) implements UserDetails {

    public static BoardPrincipal of(String name, String password, String email, String nickname) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);

        return new BoardPrincipal(
                name,
                password,
                roleTypes.stream()
                        .map(RoleType::getName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet())
                ,
                email,
                nickname

        );
    }

    public static BoardPrincipal from(AccountDto dto) {
        return BoardPrincipal.of(
                dto.name(),
                dto.password(),
                dto.email(),
                dto.nickname()
        );
    }

    public AccountDto toDto() {
        return AccountDto.of(
                name,
                password,
                email
        );
    }


    public String getName() { return name; }
    @Override public String getPassword() { return password; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


    public enum RoleType {
        USER("ROLE_USER");

        @Getter private final String name;

        RoleType(String name) {
            this.name = name;
        }
    }

}
