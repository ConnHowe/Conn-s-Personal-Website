package com.connhowe.service;

import com.connhowe.entity.ArticleDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {

    List<ArticleDO> getArticleInfos();

    String storeArticle(MultipartFile file);

    void addArticle(ArticleDO articleDO, MultipartFile file);

    ArticleDO getArticleInfoById(Long id);

    void updateArticle(ArticleDO articleDO, MultipartFile file);

    void deleteArticleById(Long id);

}
