package com.connhowe.service.impl;

import com.connhowe.entity.ArticleDO;
import com.connhowe.mapper.ArticleMapper;
import com.connhowe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("ArticleInfoService")
public class ArticleServiceImpl implements ArticleService {
    private final static String fileStorageLocation = "/Users/connhowe/Temp/connsblog/files/";

    @Autowired
    private ArticleMapper articleMapper;

    public ArticleServiceImpl() {
    }

    @Override
    public List<ArticleDO> getArticleInfos() {
        return articleMapper.getArticleInfos();
    }

    @Override
    public String storeArticle(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("上传的文件包含不合法的字符：" + fileName);
            }
            fileName = UUID.randomUUID() + ".md";
            file.transferTo(new File(fileStorageLocation + fileName));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addArticle(ArticleDO articleDO, MultipartFile file) {
        String filename = storeArticle(file);
        articleDO.setContent(filename);
        articleDO.setCreatedTime(new Date());
        articleDO.setModifiedTime(new Date());
        articleMapper.addArticle(articleDO);
    }

    @Override
    public ArticleDO getArticleInfoById(Long id) {
        return articleMapper.getArticleInfoById(id);
    }

    @Override
    public void updateArticle(ArticleDO articleDO, MultipartFile file) {
        String filename = storeArticle(file);
        articleDO.setContent(filename);
        articleDO.setModifiedTime(new Date());
        articleMapper.updateArticle(articleDO);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleMapper.deleteArticleById(id);
    }
}
