package com.connhowe.controller;

import com.connhowe.entity.ArticleInfo;
import com.connhowe.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleInfoController {

    @Autowired
    private ArticleInfoService articleInfoService;

    @GetMapping("/articleInfos")
    public String list(Model model) {
        List<ArticleInfo> articleInfos = articleInfoService.getArticleInfos();
        model.addAttribute("articleInfos", articleInfos);
        return "article/list";
    }
}
