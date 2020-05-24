package com.connhowe.service.impl;

import com.connhowe.entity.SortInfo;
import com.connhowe.mapper.SortInfoMapper;
import com.connhowe.service.SortInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class SortInfoServiceImpl implements SortInfoService {

    @Autowired
    private SortInfoMapper sortInfoMapper;

    public List<SortInfo> getSortInfos() {
        return this.sortInfoMapper.getSortInfos();
    }

    public SortInfo getSortInfoById(Long id) {
        return this.sortInfoMapper.getSortInfoById(id);
    }

    public void update(SortInfo sortInfo) {
        sortInfoMapper.update(sortInfo.getId(), sortInfo.getName(), sortInfo.getIsEffective(), new Date());
    }
}
