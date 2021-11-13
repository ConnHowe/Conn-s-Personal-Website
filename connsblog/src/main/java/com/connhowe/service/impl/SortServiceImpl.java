package com.connhowe.service.impl;

import com.connhowe.entity.SortDO;
import com.connhowe.mapper.SortMapper;
import com.connhowe.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    public List<SortDO> getSortInfos() {
        return this.sortMapper.getSortInfos();
    }

    public SortDO getSortInfoById(Long id) {
        return this.sortMapper.getSortInfoById(id);
    }

    public void update(SortDO sortDO) {
        sortDO.setModifiedTime(new Date());
        sortMapper.update(sortDO);
    }

    @Override
    public void delSortById(Long id) {
        sortMapper.delSortById(id);
    }

    @Override
    public void addSort(SortDO sortDO) {
        sortDO.setCreatedTime(new Date());
        sortDO.setModifiedTime(new Date());
        sortDO.setArticleNumber(0);
        sortMapper.addSort(sortDO);
    }
}
