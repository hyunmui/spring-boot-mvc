package com.flexibledev.practice.springbootmvc.repositories;

import com.flexibledev.practice.springbootmvc.models.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by seonhyeonmin on 2020/04/27 11:29 오전
 */
public interface RecordRepository extends LFRepository<Record, Long> {
    List<Record> findAllByTitleContains(String title);
}
