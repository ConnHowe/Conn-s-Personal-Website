package com.connhowe.service.impl;

import com.connhowe.entity.ArticleInfo;
import com.connhowe.mapper.ArticleInfoMapper;
import com.connhowe.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> getArticleInfos() {
        return articleInfoMapper.getArticleInfos();
    }
}
