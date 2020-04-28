package com.flexibledev.practice.springbootmvc.models.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Created by seonhyeonmin on 2020/04/27 5:36 오후
 */
@Entity
@Getter
public class Song {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalTime runningTIme;

    private String createdBy;

    private Member createdMember;

}
