package com.flexibledev.practice.springbootmvc.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flexibledev.practice.springbootmvc.models.domains.MemberRole;
import lombok.Generated;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by seonhyeonmin on 2020/04/27 12:06 오후
 */
@Entity
@Table
@Getter
public class Member implements UserDetails {

    @Column
    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private MemberRole memberRole;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(MemberRole.values()).map(i -> new SimpleGrantedAuthority(i.name())).collect(Collectors.toList());
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return id;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void readyToSignUp(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
        memberRole = MemberRole.ROLE_MEMBER;
    }
}
