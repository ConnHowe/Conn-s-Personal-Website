package com.connhowe.controller;

import com.connhowe.entity.ArticleInfo;
import com.connhowe.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ArticleInfoController {

    @Autowired
    @Qualifier("ArticleInfoService")
    private ArticleInfoService articleInfoService;

    @GetMapping("/articleInfos")
    public String list(Model model) {
        List<ArticleInfo> articleInfos = articleInfoService.getArticleInfos();
        model.addAttribute("articleInfos", articleInfos);
        return "article/list";
    }

    @GetMapping("/article/add")
    public String toAdd() {
        return "article/add";
    }

    @PostMapping("/article/add")
    public String add(ArticleInfo articleInfo, @RequestParam("file") MultipartFile file) {
        articleInfoService.addArticle(articleInfo, file);
        return "redirect:/articleInfos";
    }
}
