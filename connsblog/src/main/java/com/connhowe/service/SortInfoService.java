package com.connhowe.service;

import com.connhowe.entity.SortInfo;
import com.connhowe.mapper.SortInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SortInfoService {

    @Autowired
    private SortInfoMapper sortInfoMapper;

    public List<SortInfo> getSortInfos() {
        return this.sortInfoMapper.getSortInfos();
    }

    public SortInfo getSortInfoById(Long id) {
        return this.sortInfoMapper.getSortInfoById(id);
    }
}
