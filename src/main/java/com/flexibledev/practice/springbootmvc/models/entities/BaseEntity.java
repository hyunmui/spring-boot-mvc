package com.flexibledev.practice.springbootmvc.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by seonhyeonmin on 2020/04/27 5:41 오후
 */
public abstract class BaseEntity {
    @Column(name = "created_by")
    protected String createdBy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    @JsonIgnore
    protected Member createdByMember;
}
