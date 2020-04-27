package com.flexibledev.practice.springbootmvc.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by seonhyeonmin on 2020/04/27 10:54 오전
 */

@Entity
@Table(name = "tracks")
@Getter
public class Track {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name = "record_id", insertable = false, updatable = false)
    @JsonBackReference
    private Record record;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    @JsonIgnore
    private Member createdByMember;
}
