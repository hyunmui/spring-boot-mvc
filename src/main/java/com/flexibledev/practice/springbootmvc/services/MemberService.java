package com.flexibledev.practice.springbootmvc.services;

import com.flexibledev.practice.springbootmvc.exceptions.MemberNotFoundException;
import com.flexibledev.practice.springbootmvc.models.entities.Member;
import com.flexibledev.practice.springbootmvc.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by seonhyeonmin on 2020/04/28 10:08 오전
 */
@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws MemberNotFoundException {
        return memberRepository.findById(userId).orElseThrow(MemberNotFoundException::new);
    }
}
