package com.connhowe.service;

import com.connhowe.entity.ArticleInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ArticleInfoService {

    List<ArticleInfo> getArticleInfos();

    String storeArticle(MultipartFile file);

    void addArticle(ArticleInfo articleInfo, MultipartFile file);

    ArticleInfo getArticleInfoById(Long id);

    void updateArticle(ArticleInfo articleInfo, MultipartFile file);

    void deleteArticleById(Long id);

}
