package com.connhowe.controller;

import com.connhowe.entity.SortInfo;
import com.connhowe.service.SortInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private SortInfoService sortInfoService;

    @GetMapping("/admin")
    public String hello(Model model) {
        return "admin";
    }

    @GetMapping("/admin/sortmanager")
    public String sortmanager(Model model) {
        List<SortInfo> sortInfos = sortInfoService.getSortInfos();
        model.addAttribute("sortInfos", sortInfos);
        return "sort/sortmanager";
    }

    @GetMapping("/admin/sort/{id}")
    public String toUpdateSort(@PathVariable("id") Long id, Model model) {
        SortInfo sortInfo = sortInfoService.getSortInfoById(id);
        model.addAttribute("sortInfo", sortInfo);
        return "sort/update";
    }
}
