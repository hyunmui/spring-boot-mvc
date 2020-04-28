package com.flexibledev.practice.springbootmvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by seonhyeonmin on 2020/04/28 12:07 오후
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MemberNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "해당 아이디를 가진 멤버를 찾을 수 없습니다";
    }
}
