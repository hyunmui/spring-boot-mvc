package com.flexibledev.practice.springbootmvc.controllers;

import com.flexibledev.practice.springbootmvc.models.entities.Member;
import com.flexibledev.practice.springbootmvc.models.entities.Record;
import com.flexibledev.practice.springbootmvc.repositories.MemberRepository;
import com.flexibledev.practice.springbootmvc.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seonhyeonmin on 2020/04/27 10:48 오전
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping("/list")
    public List<Record> getRecords(@RequestParam(required = false, defaultValue = "") String title) {
        return recordRepository.findAllByTitleContains(title);
    }

    @PostMapping("/update")
    public Record update(@RequestBody Record record) {
        record = recordRepository.save(record);
        recordRepository.refresh(record);
        return record;
    }
}
