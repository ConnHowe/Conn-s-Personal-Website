package com.connhowe.controller;

import com.connhowe.entity.ArticleInfo;
import com.connhowe.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleInfoController {

    @Autowired
    @Qualifier("ArticleInfoService")
    private ArticleInfoService articleInfoService;

    @GetMapping()
    public String list(Model model) {
        List<ArticleInfo> articleInfos = articleInfoService.getArticleInfos();
        model.addAttribute("articleInfos", articleInfos);
        return "article/list";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        articleInfoService.deleteArticleById(id);
        return "redirect:/article";
    }

    @GetMapping("/add")
    public String toAdd() {
        return "article/add";
    }

    @PostMapping("/add")
    public String add(ArticleInfo articleInfo, @RequestParam("file") MultipartFile file) {
        articleInfoService.addArticle(articleInfo, file);
        return "redirect:/article";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        ArticleInfo articleInfo = articleInfoService.getArticleInfoById(id);
        model.addAttribute("articleInfo", articleInfo);
        return "article/update";
    }

    @PostMapping("/update")
    public String update(ArticleInfo articleInfo, @RequestParam("file") MultipartFile file) {
        articleInfoService.updateArticle(articleInfo, file);
        return "redirect:/article";
    }
}
