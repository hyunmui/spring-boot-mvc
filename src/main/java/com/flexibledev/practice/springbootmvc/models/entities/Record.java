package com.flexibledev.practice.springbootmvc.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by seonhyeonmin on 2020/04/27 10:52 오전
 */
@Entity
@Table(name = "records")
@Getter
public class Record {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "record_id")
    private Collection<Track> tracks;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    @JsonIgnore
    private Member createdByMember;
}
