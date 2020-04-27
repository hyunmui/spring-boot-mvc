package com.flexibledev.practice.springbootmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by seonhyeonmin on 2020/04/27 3:46 오후
 */
@NoRepositoryBean
public interface LFRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    void refresh(T t);
}
