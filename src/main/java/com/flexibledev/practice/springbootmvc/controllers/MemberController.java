package com.flexibledev.practice.springbootmvc.controllers;

import com.flexibledev.practice.springbootmvc.exceptions.AlreadyExistMemberIdException;
import com.flexibledev.practice.springbootmvc.exceptions.MemberNotFoundException;
import com.flexibledev.practice.springbootmvc.models.domains.LoginModel;
import com.flexibledev.practice.springbootmvc.models.domains.MemberRole;
import com.flexibledev.practice.springbootmvc.models.entities.Member;
import com.flexibledev.practice.springbootmvc.providers.JwtTokenProvider;
import com.flexibledev.practice.springbootmvc.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by seonhyeonmin on 2020/04/28 9:54 오전
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/sign-in")
    public String signIn(@RequestBody LoginModel model) throws AuthException {
        Member member= memberRepository.findById(model.getUserId()).orElseThrow(AuthException::new);
        if (!passwordEncoder.matches(model.getPassword(), member.getPassword()))
            throw new AuthException("해당 사용자는 존재하지 않습니다");

        return jwtTokenProvider.createToken(member.getId(), Arrays.stream(MemberRole.values()).map(Enum::name).collect(Collectors.toList()));
    }

    @PostMapping("/sign-up")
    public Member signUp(@RequestBody Member newMember) throws AlreadyExistMemberIdException {
        newMember.readyToSignUp(passwordEncoder);
        if (memberRepository.existsById(newMember.getId()))
            throw new AlreadyExistMemberIdException();

        return memberRepository.save(newMember);
    }

    @GetMapping("/{id}")
    public Member info(@PathVariable String id) throws MemberNotFoundException {
        return memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
    }

}
