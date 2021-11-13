package com.connhowe.service;

import com.connhowe.entity.SortDO;

import java.util.List;

public interface SortService {

    List<SortDO> getSortInfos();

    SortDO getSortInfoById(Long id);

    void update(SortDO sortDO);

    void delSortById(Long id);

    void addSort(SortDO sortDO);
}
