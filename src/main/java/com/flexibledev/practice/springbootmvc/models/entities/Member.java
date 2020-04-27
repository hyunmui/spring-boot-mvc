package com.flexibledev.practice.springbootmvc.models.entities;

import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by seonhyeonmin on 2020/04/27 12:06 오후
 */
@Entity
@Table
@Getter
public class Member {

    @Column
    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private String email;
}
