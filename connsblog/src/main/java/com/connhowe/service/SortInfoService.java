package com.connhowe.service;

import com.connhowe.entity.SortInfo;

import java.util.List;

public interface SortInfoService {

    List<SortInfo> getSortInfos();

    SortInfo getSortInfoById(Long id);

    void update(SortInfo sortInfo);
}
