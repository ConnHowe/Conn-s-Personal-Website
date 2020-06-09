package com.connhowe.service.impl;

import com.connhowe.entity.ArticleInfo;
import com.connhowe.mapper.ArticleInfoMapper;
import com.connhowe.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("ArticleInfoService")
public class ArticleInfoServiceImpl implements ArticleInfoService {

    private final String fileStorageLocation = "C:\\Users\\Conn\\Desktop\\新建文件夹\\";

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    public ArticleInfoServiceImpl() {
    }

    @Override
    public List<ArticleInfo> getArticleInfos() {
        return articleInfoMapper.getArticleInfos();
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
    public void addArticle(ArticleInfo articleInfo, MultipartFile file) {
        String filename = storeArticle(file);
        articleInfo.setFilename(filename);
        articleInfo.setCreateBy(new Date());
        articleInfo.setModifiedBy(new Date());
        articleInfoMapper.addArticle(articleInfo);
    }

    @Override
    public ArticleInfo getArticleInfoById(Long id) {
        return articleInfoMapper.getArticleInfoById(id);
    }

    @Override
    public void updateArticle(ArticleInfo articleInfo, MultipartFile file) {
        String filename = storeArticle(file);
        articleInfo.setFilename(filename);
        articleInfo.setModifiedBy(new Date());
        articleInfoMapper.updateArticle(articleInfo);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleInfoMapper.deleteArticleById(id);
    }
}
