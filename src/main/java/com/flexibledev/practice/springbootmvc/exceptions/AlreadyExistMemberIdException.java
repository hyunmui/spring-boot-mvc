package com.flexibledev.practice.springbootmvc.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by seonhyeonmin on 2020/04/28 12:07 오후
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyExistMemberIdException extends RuntimeException {
    @Override
    public String getMessage() {
        return "이미 해당 아이디를 가진 회원이 존재합니다";
    }
}
