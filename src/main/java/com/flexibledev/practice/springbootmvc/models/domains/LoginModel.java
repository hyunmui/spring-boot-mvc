package com.flexibledev.practice.springbootmvc.models.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by seonhyeonmin on 2020/04/28 10:02 오전
 */
@AllArgsConstructor
public class LoginModel {
    @Getter(onMethod_= { @JsonProperty(required = true) })
    private final String userId;
    @Getter(onMethod_= { @JsonProperty(required = true) })
    private final String password;
}
