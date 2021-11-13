package com.connhowe.controller;

import com.connhowe.entity.ArticleDO;
import com.connhowe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    @Qualifier("ArticleInfoService")
    private ArticleService articleService;

    @GetMapping()
    public String list(Model model) {
        List<ArticleDO> articleDOs = articleService.getArticleInfos();
        model.addAttribute("articleDOs", articleDOs);
        return "article/list";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/article";
    }

    @GetMapping("/add")
    public String toAdd() {
        return "article/add";
    }

    @PostMapping("/add")
    public String add(ArticleDO articleDO, @RequestParam("file") MultipartFile file) {
        articleService.addArticle(articleDO, file);
        return "redirect:/article";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        ArticleDO articleDO = articleService.getArticleInfoById(id);
        model.addAttribute("articleDO", articleDO);
        return "article/update";
    }

    @PostMapping("/update")
    public String update(ArticleDO articleDO, @RequestParam("file") MultipartFile file) {
        articleService.updateArticle(articleDO, file);
        return "redirect:/article";
    }
}
